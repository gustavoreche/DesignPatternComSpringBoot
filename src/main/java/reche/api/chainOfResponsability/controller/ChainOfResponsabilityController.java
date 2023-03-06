package reche.api.chainOfResponsability.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reche.api.chainOfResponsability.model.Produto;
import reche.api.chainOfResponsability.service.DescontoService;

@RestController
@RequestMapping("/chain-of-responsability")
public class ChainOfResponsabilityController {
	
	@Autowired
	private DescontoService descontoService;
	
	@GetMapping
	public ResponseEntity<String> calculaDesconto(
			@RequestParam(required = true) Double valor,
			@RequestParam(required = true) Integer quantidade
			){
		return new ResponseEntity<String>(this.descontoService
				.calcula(new Produto(new BigDecimal(valor), quantidade)), 
				HttpStatus.OK);
	}

}
