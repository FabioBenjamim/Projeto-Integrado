package br.usjt.pi.Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.pi.Projeto.model.Imagem;

public interface ImagemRepository extends JpaRepository<Imagem, Integer>{

		Imagem findById(long id);
	
}
