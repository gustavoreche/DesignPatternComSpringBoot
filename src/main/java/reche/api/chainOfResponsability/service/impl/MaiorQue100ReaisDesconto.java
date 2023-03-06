package reche.api.chainOfResponsability.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import reche.api.chainOfResponsability.model.Produto;
import reche.api.chainOfResponsability.service.DescontoInterface;

@Component("maiorQue100")
public class MaiorQue100ReaisDesconto implements DescontoInterface {
	
	@Qualifier("maisQue5")
	@Autowired
	private DescontoInterface desconto;

	@Override
	public BigDecimal calcula(Produto produto) {
		if(produto.valor().compareTo(new BigDecimal("100")) == 1) {
			return produto.valor().multiply(new BigDecimal("0.1"));
		}
		return this.desconto.calcula(produto);
	}

}
