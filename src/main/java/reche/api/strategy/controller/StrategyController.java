package reche.api.strategy.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reche.api.strategy.model.Orcamento;
import reche.api.strategy.model.TipoImposto;
import reche.api.strategy.service.ImpostoService;

@RestController
@RequestMapping("/strategy")
public class StrategyController {
	
	@Autowired
	private ImpostoService impostoService;
	
	@GetMapping
	public ResponseEntity<String> calculaImposto(
			@RequestParam(required = true) Double valor,
			@RequestParam(required = true) TipoImposto tipoImposto
			){
		return new ResponseEntity<String>(this.impostoService
				.calcula(new Orcamento(new BigDecimal(valor)), tipoImposto), 
				HttpStatus.OK);
	}

}
