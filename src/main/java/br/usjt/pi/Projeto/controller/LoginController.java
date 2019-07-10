package br.usjt.pi.Projeto.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.pi.Projeto.model.Perfil;
import br.usjt.pi.Projeto.model.Usuario;
import br.usjt.pi.Projeto.repository.PerfilRepository;
import br.usjt.pi.Projeto.repository.UsuarioRepository;
import br.usjt.pi.Projeto.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired 
	private UsuarioRepository usu;
	
	@Autowired 
	private PerfilRepository pr;
	
	@GetMapping({"/login", "/"})
	public ModelAndView Tela(HttpServletRequest request, Usuario usuario) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject(new Usuario());
		return mv;
	}
	
	@PostMapping ("/fazerLogin")
			public String fazerLogin (HttpServletRequest request, Usuario usuario) {
				if (loginService.logar(usuario)) {
					
					Perfil perfil = new Perfil();
					perfil.setAdmin(false);
					perfil.setNome("");
					perfil.setFotoPerfil("");
					usuario.setId(27);
					usuario.setPerfil(perfil);
					pr.save(perfil);
					request.getSession().setAttribute("usuarioLogado", usuario);
					HttpSession session = request.getSession();
					usu.save((Usuario)session.getAttribute("usuarioLogado"));
					
				return"redirect:index";
			}else{
				return"/index";
			}
	}
	
}
