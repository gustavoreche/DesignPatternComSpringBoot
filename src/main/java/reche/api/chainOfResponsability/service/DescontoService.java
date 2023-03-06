package reche.api.chainOfResponsability.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import reche.api.chainOfResponsability.model.Produto;

@Service
public class DescontoService {
	
	@Qualifier("maiorQue100")
	@Autowired
	private DescontoInterface desconto;
	
	public String calcula(Produto produto) {
		var valorDesconto = desconto.calcula(produto);
		return """
				O valor do desconto é %s
				""".formatted(valorDesconto);
	}

}
