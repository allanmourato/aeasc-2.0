package br.com.abm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.abm.model.Socio;
import br.com.abm.repository.Categorias;

@Controller
public class SocioController {
	
	@Autowired
	private Categorias categorias;
	
	
	@RequestMapping("/cadastro/socio")
	public String cadastroSocio(Socio socio) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("categorias", categorias.findAll());
		return "/socio/CadastroSocio";
	}
	
	@RequestMapping(value = "/cadastro/socio", method = RequestMethod.POST)
	public String cadastrar(@Valid Socio socio, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return cadastroSocio(socio);
		}
		
		attributes.addFlashAttribute("mensagem", "Sócio cadastrado com sucesso!");
		return "redirect:/cadastro/socio";
	}
	

}
