package br.com.abm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.abm.model.CategoriaSocio;
import br.com.abm.service.CategoriaSocioService;
import br.com.abm.service.exception.CategoriaSocioJaCadastradadoException;

@Controller
@RequestMapping("/categorias")
public class CategoriaSocioController {
	
	@Autowired
	private CategoriaSocioService css;
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<?> salva(@RequestBody @Valid CategoriaSocio categoriaSocio, BindingResult result) throws CategoriaSocioJaCadastradadoException {
		
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}
		
		System.out.println("chamou o metodo salvar");
		categoriaSocio = css.salvar(categoriaSocio);
				
		return ResponseEntity.ok(categoriaSocio);
	}

}
