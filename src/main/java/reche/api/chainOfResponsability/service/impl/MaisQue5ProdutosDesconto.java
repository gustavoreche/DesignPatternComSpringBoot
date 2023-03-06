package reche.api.chainOfResponsability.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import reche.api.chainOfResponsability.model.Produto;
import reche.api.chainOfResponsability.service.DescontoInterface;

@Component("maisQue5")
public class MaisQue5ProdutosDesconto implements DescontoInterface {
	
	@Qualifier("semDesconto")
	@Autowired
	private DescontoInterface desconto;

	@Override
	public BigDecimal calcula(Produto produto) {
		if(produto.quantidade() > 5) {
			return produto.valor().multiply(new BigDecimal("0.2"));
		}
		return this.desconto.calcula(produto);
	}

}
