package reche.api.templateMethod.service;

import java.math.BigDecimal;

import reche.api.templateMethod.model.Produto;

public abstract class DescontoAbstract {
	
	public BigDecimal calcula(Produto produto) {
		if(this.deveAplicarDesconto(produto)) {
			return this.aplicaDesconto(produto);
		}
		return this.proximoDesconto().calcula(produto);
	}
	
	protected abstract boolean deveAplicarDesconto(Produto produto);
	
	protected abstract BigDecimal aplicaDesconto(Produto produto);
	
	protected abstract DescontoAbstract proximoDesconto();

}
