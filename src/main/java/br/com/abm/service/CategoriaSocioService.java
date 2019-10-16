package br.com.abm.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.abm.model.CategoriaSocio;
import br.com.abm.repository.Categorias;
import br.com.abm.service.exception.CategoriaSocioJaCadastradadoException;

@Service
public class CategoriaSocioService {

	@Autowired
	private Categorias categorias;
	
	@Transactional
	public CategoriaSocio salvar(CategoriaSocio categoriaSocio) throws CategoriaSocioJaCadastradadoException {
		Optional<CategoriaSocio> estiloOptional = categorias.findByNomeIgnoreCase(categoriaSocio.getNome());
		if (estiloOptional.isPresent()) {
			throw new CategoriaSocioJaCadastradadoException("Nome do estilo já cadastrado");
		}
		
		return categorias.saveAndFlush(categoriaSocio);
	}
	
	
}
