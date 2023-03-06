package reche.api.strategy.service;

import java.math.BigDecimal;

import reche.api.strategy.model.Orcamento;

public interface Imposto {
	
	BigDecimal calcula(Orcamento orcamento);

}
