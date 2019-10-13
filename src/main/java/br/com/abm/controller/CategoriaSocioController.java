package br.com.abm.controller;

import javax.transaction.Transactional;
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

import br.com.abm.dao.CategoriaSocioDao;
import br.com.abm.model.CategoriaSocio;

@Controller
@Transactional
@RequestMapping("/categorias")
public class CategoriaSocioController {
	
	@Autowired
	private CategoriaSocioDao categoriaSocioDao;
	
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody ResponseEntity<?> salva(@RequestBody @Valid CategoriaSocio categoriaSocio, BindingResult result) {
		
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getFieldError("nome").getDefaultMessage());
		}
		
		categoriaSocioDao.adiciona(categoriaSocio);
				
		return ResponseEntity.ok(categoriaSocio);
	}

}
