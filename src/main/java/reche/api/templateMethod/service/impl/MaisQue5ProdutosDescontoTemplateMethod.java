package reche.api.templateMethod.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import reche.api.templateMethod.model.Produto;
import reche.api.templateMethod.service.DescontoAbstract;

@Component("maisQue5TemplateMethod")
public class MaisQue5ProdutosDescontoTemplateMethod extends DescontoAbstract {
	
	@Qualifier("semDescontoTemplateMethod")
	@Autowired
	private DescontoAbstract desconto;

	@Override
	protected boolean deveAplicarDesconto(Produto produto) {
		return produto.quantidade() > 5;
	}

	@Override
	protected BigDecimal aplicaDesconto(Produto produto) {
		return produto.valor().multiply(new BigDecimal("0.2"));
	}

	@Override
	protected DescontoAbstract proximoDesconto() {
		return this.desconto;
	}

}
