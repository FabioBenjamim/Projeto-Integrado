package br.usjt.pi.Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.usjt.pi.Projeto.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	
	public Usuario findOneByLoginAndSenha(String login,String senha);
	
	@Query ("SELECT a FROM Usuario a  WHERE a.login = ?1 and a.senha = ?2")
	public Usuario fazerLogin (String login, String senha);
}
