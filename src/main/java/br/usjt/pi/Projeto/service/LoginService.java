package br.usjt.pi.Projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.pi.Projeto.model.Usuario;
import br.usjt.pi.Projeto.repository.UsuarioRepository;

@Service
public class LoginService {

	@Autowired
	UsuarioRepository usuarioRepo;
	
	public boolean logar(Usuario usuario) {
		return usuarioRepo.fazerLogin(usuario.getLogin(), usuario.getSenha()) != null;
	}
	
	
		
}
