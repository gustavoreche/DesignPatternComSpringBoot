package reche.api.chainOfResponsability.service;

import java.math.BigDecimal;

import reche.api.chainOfResponsability.model.Produto;

public interface DescontoInterface {
	
	BigDecimal calcula(Produto produto);
	
}
