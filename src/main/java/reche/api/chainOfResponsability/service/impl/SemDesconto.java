package reche.api.chainOfResponsability.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import reche.api.chainOfResponsability.model.Produto;
import reche.api.chainOfResponsability.service.DescontoInterface;

@Component("semDesconto")
public class SemDesconto implements DescontoInterface {

	@Override
	public BigDecimal calcula(Produto produto) {
		return BigDecimal.ZERO;
	}

}
