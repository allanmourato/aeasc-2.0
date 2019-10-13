package br.com.abm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CobrancaController {
	
	
	@RequestMapping("/individual")
	public ModelAndView cobrancaIndividual() {
		ModelAndView mv = new ModelAndView("/cobranca/NovaCobranca");
		return mv;
	}

}
