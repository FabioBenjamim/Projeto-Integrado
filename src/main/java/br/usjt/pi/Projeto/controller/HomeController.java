package br.usjt.pi.Projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.pi.Projeto.model.Cards;
import br.usjt.pi.Projeto.model.Feedback;
import br.usjt.pi.Projeto.model.Link;
import br.usjt.pi.Projeto.model.Pesquisa;
import br.usjt.pi.Projeto.repository.CardsRepository;

@Controller
public class HomeController {

	@Autowired
	private CardsRepository cdRepo;
	
	@GetMapping("/index")
	public ModelAndView ola() {
		ModelAndView mv = new ModelAndView("TimeLine");
		List <Cards> cards = cdRepo.findAll();
		mv.addObject("cards", cards);
		Pesquisa pesquisa = new Pesquisa();
		mv.addObject("pesquisa", pesquisa);
		mv.addObject("cardP", criaCardParaPost());
		mv.addObject("link", criaLinkParaPost());
		return mv;
	}
	@GetMapping("/ciencia")
	public ModelAndView trocaCien() {
		ModelAndView mv = new ModelAndView("TimeLine");
		List <Cards> cards = cdRepo.buscarPorCategoria("Ciência");
		mv.addObject("cards", cards);
		Cards cards1 = new Cards();
		cards1.setCategoria("Ciência");
		mv.addObject("cards1",cards1);
		Pesquisa pesquisa = new Pesquisa();
		mv.addObject("pesquisa", pesquisa);
		mv.addObject("cardP", criaCardParaPost());
		mv.addObject("link", criaLinkParaPost());
		return mv;
	}
	@GetMapping("/tecnologia")
	public ModelAndView trocaTec() {
		ModelAndView mv = new ModelAndView("TimeLine");
		List <Cards> cards = cdRepo.buscarPorCategoria("Tecnologia");
		mv.addObject("cards", cards);
		Cards cards1 = new Cards();
		cards1.setCategoria("Tecnologia");
		mv.addObject("cards1",cards1);
		Pesquisa pesquisa = new Pesquisa();
		mv.addObject("pesquisa", pesquisa);
		mv.addObject("cardP", criaCardParaPost());
		mv.addObject("link", criaLinkParaPost());
		return mv;
	}
	@GetMapping("/buscaTag")
	public ModelAndView trocaTitulo(Pesquisa pesquisa) {
		ModelAndView mv = new ModelAndView("TimeLine");
		List <Cards> cards = cdRepo.buscarPorTag(pesquisa.getNome());
		mv.addObject("cards", cards);
		Pesquisa pesquisa1 = new Pesquisa();
		mv.addObject("pesquisa", pesquisa1);
		mv.addObject("cardP", criaCardParaPost());
		mv.addObject("link", criaLinkParaPost());
		return mv;
	}
	
	@GetMapping("/esportes")
	public ModelAndView trocaEsportes() {
		ModelAndView mv = new ModelAndView("TimeLine");
		List <Cards> cards = cdRepo.buscarPorCategoria("Esportes");
		mv.addObject("cards", cards);
		Cards cards1 = new Cards();
		cards1.setCategoria("Ciência");
		mv.addObject("cards1",cards1);
		Pesquisa pesquisa = new Pesquisa();
		mv.addObject("pesquisa", pesquisa);
		mv.addObject("cardP", criaCardParaPost());
		mv.addObject("link", criaLinkParaPost());
		return mv;
	}
	
	@GetMapping("/economia")
	public ModelAndView trocaEconomia() {
		ModelAndView mv = new ModelAndView("TimeLine");
		List <Cards> cards = cdRepo.buscarPorCategoria("Economia");
		mv.addObject("cards", cards);
		Cards cards1 = new Cards();
		cards1.setCategoria("Ciência");
		mv.addObject("cards1",cards1);
		Pesquisa pesquisa = new Pesquisa();
		mv.addObject("pesquisa", pesquisa);
		mv.addObject("cardP", criaCardParaPost());
		mv.addObject("link", criaLinkParaPost());
		return mv;
	}
	@GetMapping("/politica")
	public ModelAndView trocaPolitica() {
		ModelAndView mv = new ModelAndView("TimeLine");
		List <Cards> cards = cdRepo.buscarPorCategoria("Politica");
		mv.addObject("cards", cards);
		Cards cards1 = new Cards();
		cards1.setCategoria("Ciência");
		mv.addObject("cards1",cards1);
		Pesquisa pesquisa = new Pesquisa();
		mv.addObject("pesquisa", pesquisa);
		mv.addObject("cardP", criaCardParaPost());
		mv.addObject("link", criaLinkParaPost());
		return mv;
	}
	
	@GetMapping("/buscaPagina")
	public ModelAndView oi(Cards cards6) {
		return new ModelAndView(cards6.getNome());
	}
	
	@GetMapping("/index/{nome}")
	public ModelAndView ola (@PathVariable String nome) {
		ModelAndView mv = new ModelAndView("teste");
		Cards card = cdRepo.buscarCorpo(nome);
		Feedback feed = card.getFeedback();
		cdRepo.attVisu((feed.getVisualizacao() + 1), feed.getId());
		mv.addObject("card",card);
		mv.addObject("cardP", criaCardParaPost());
		mv.addObject("link", criaLinkParaPost());
		return mv;
	}
	@PostMapping("/like/{nome}")
	public ModelAndView like(@PathVariable String nome) {
		ModelAndView mv = new ModelAndView("teste");
		Cards card = cdRepo.buscarCorpo(nome);
		Feedback feed = card.getFeedback();
		cdRepo.attLike(feed.getGostei() + 1, feed.getId());
		mv.addObject("card",card);
		mv.addObject("cardP", criaCardParaPost());
		mv.addObject("link", criaLinkParaPost());
		return mv;
	}
	
	private Cards criaCardParaPost() {
		Cards card = new Cards();
		return card;
	}
	private Link criaLinkParaPost() {
		Link link = new Link();
		return link;
	}

}
