package br.usjt.pi.Projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.pi.Projeto.model.Link;
import br.usjt.pi.Projeto.service.LinkService;

@Controller
public class PerfilController {
	
	@Autowired
	private LinkService liService;

	@GetMapping("/Perfil")
	public ModelAndView str() {
		ModelAndView mv = new ModelAndView("Perfil");
		Link link = new Link();
		mv.addObject("link",link);
		return mv;
	}
	
	@PostMapping("/live")
	public ModelAndView IniciarLive(Link link) {
		ModelAndView mv  = new ModelAndView("Live");
		liService.salvar(link);
		Link link1 = new Link();
		link1 = link;
		mv.addObject("link1",link1);
		return mv;
	}
}
