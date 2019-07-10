package br.usjt.pi.Projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.pi.Projeto.model.Link;
import br.usjt.pi.Projeto.repository.LinkRepository;

@Controller
public class LiveController {
	
	@Autowired
	private LinkRepository liRepo;

	
	@GetMapping("/transmissao")
	public ModelAndView ola() {
		ModelAndView mv = new ModelAndView("Live");
		List<Link> link = liRepo.findAll();
		Link link1 = new Link();
		link1 = link.get(link.size()-1);
		link1.setLinkNome(link1.getLinkNome() + "?autoplay=1");
		mv.addObject("link1",link1);
		return mv;
		
	}
}
