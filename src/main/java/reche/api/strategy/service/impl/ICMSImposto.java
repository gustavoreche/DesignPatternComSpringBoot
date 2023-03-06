package reche.api.strategy.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import reche.api.strategy.model.Orcamento;
import reche.api.strategy.service.Imposto;

@Component("ICMS")
public class ICMSImposto implements Imposto {

	@Override
	public BigDecimal calcula(Orcamento orcamento) {
		return orcamento.valor().multiply(new BigDecimal("0.1"));
	}

}
