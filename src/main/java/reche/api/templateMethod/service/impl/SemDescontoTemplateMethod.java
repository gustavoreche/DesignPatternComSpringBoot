package reche.api.templateMethod.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import reche.api.templateMethod.model.Produto;
import reche.api.templateMethod.service.DescontoAbstract;

@Component("semDescontoTemplateMethod")
public class SemDescontoTemplateMethod extends DescontoAbstract {

	@Override
	protected boolean deveAplicarDesconto(Produto produto) {
		return true;
	}

	@Override
	protected BigDecimal aplicaDesconto(Produto produto) {
		return BigDecimal.ZERO;
	}

	@Override
	protected DescontoAbstract proximoDesconto() {
		return null;
	}

}
