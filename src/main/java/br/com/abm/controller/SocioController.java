package br.com.abm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.abm.model.Socio;
import br.com.abm.model.StatusSocio;
import br.com.abm.model.TipoPessoa;
import br.com.abm.repository.Categorias;
import br.com.abm.repository.Socios;
import br.com.abm.repository.filter.SocioFilter;
import br.com.abm.service.SocioService;
import br.com.abm.service.exception.CategoriaSocioJaCadastradadoException;

@Controller
@RequestMapping("/socio")
public class SocioController {
	
	@Autowired
	private SocioService socioService;
	
	@Autowired
	private Categorias categorias;
	
	@Autowired
	private Socios socios;

	
	@RequestMapping("/novo")
	public ModelAndView cadastroSocio(Socio socio) {
		ModelAndView mv = new ModelAndView("/socio/CadastroSocio");
		mv.addObject("categorias", categorias.findAll());
		mv.addObject("tipoPessoa", TipoPessoa.values());
		mv.addObject("statusSocio", StatusSocio.values());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Socio socio, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return cadastroSocio(socio);
		}
		try {
			socioService.salvar(socio);
		} catch (CategoriaSocioJaCadastradadoException e) {
			attributes.addFlashAttribute("mensagem", "Erro ao cadastrar sócio!");
			e.printStackTrace();
		}
		attributes.addFlashAttribute("mensagem", "Sócio cadastrado com sucesso!");
		return new ModelAndView("redirect:/socio/novo");
	}
	
	@GetMapping
	public ModelAndView pesquisa(SocioFilter socioFilter, BindingResult result) {
		ModelAndView mv = new ModelAndView("/socio/PesquisaSocio");
		mv.addObject("categorias", categorias.findAll());
		mv.addObject("statusSocio", StatusSocio.values());
		
		mv.addObject("socios", socios.filtrar(socioFilter));
		
		return mv;
		
	}
	

}
