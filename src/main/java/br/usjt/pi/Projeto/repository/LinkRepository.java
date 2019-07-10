package br.usjt.pi.Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.pi.Projeto.model.Link;

public interface LinkRepository  extends JpaRepository<Link, Long>{

	Link findById(long id);
}
