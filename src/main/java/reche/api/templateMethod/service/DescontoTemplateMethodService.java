package reche.api.templateMethod.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import reche.api.templateMethod.model.Produto;


@Service
public class DescontoTemplateMethodService {
	
	@Qualifier("maiorQue100TemplateMethod")
	@Autowired
	private DescontoAbstract desconto;
	
	public String calcula(Produto produto) {
		var valorDesconto = desconto.calcula(produto);
		return """
				O valor do desconto é %s
				""".formatted(valorDesconto);
	}

}
