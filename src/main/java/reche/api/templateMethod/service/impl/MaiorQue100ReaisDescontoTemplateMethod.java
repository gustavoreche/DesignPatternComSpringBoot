package reche.api.templateMethod.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import reche.api.templateMethod.model.Produto;
import reche.api.templateMethod.service.DescontoAbstract;

@Component("maiorQue100TemplateMethod")
public class MaiorQue100ReaisDescontoTemplateMethod extends DescontoAbstract {
	
	@Qualifier("maisQue5TemplateMethod")
	@Autowired
	private DescontoAbstract desconto;

	@Override
	protected boolean deveAplicarDesconto(Produto produto) {
		return produto.valor().compareTo(new BigDecimal("100")) == 1;
	}

	@Override
	protected BigDecimal aplicaDesconto(Produto produto) {
		return produto.valor().multiply(new BigDecimal("0.1"));
	}

	@Override
	protected DescontoAbstract proximoDesconto() {
		return this.desconto;
	}

}
