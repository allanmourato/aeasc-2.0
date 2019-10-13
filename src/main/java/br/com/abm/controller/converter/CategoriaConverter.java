package br.com.abm.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.abm.model.CategoriaSocio;

public class CategoriaConverter implements Converter<String, CategoriaSocio>{

	@Override
	public CategoriaSocio convert(String codigo) {
		
		if (!StringUtils.isEmpty(codigo)) {
			CategoriaSocio categoriaSocio = new CategoriaSocio();
			categoriaSocio.setId(Long.valueOf(codigo));
			return categoriaSocio;
		}
		
		return null;
	}

}
