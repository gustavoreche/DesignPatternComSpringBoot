package reche.api.strategy.service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reche.api.strategy.model.Orcamento;
import reche.api.strategy.model.TipoImposto;

@Service 
public class ImpostoService {
	
	@Autowired
	private Map<String, Imposto> defineImposto;
	
	public String calcula(Orcamento orcamento,
			TipoImposto imposto) {
		var tipoImposto = this.defineImposto.get(imposto.name());
		if(Objects.nonNull(tipoImposto)) {
			 var valorImposto = tipoImposto.calcula(orcamento);
			 return montaRetorno(valorImposto);
		}
		return """
				Imposto selecionado nao existe!
				""";
	}

	private String montaRetorno(BigDecimal valorImposto) {
		return """
				O valor do imposto é %s
				""".formatted(valorImposto);
	}

}
