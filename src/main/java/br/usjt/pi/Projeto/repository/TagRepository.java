package br.usjt.pi.Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.pi.Projeto.model.Tag;

public interface TagRepository extends JpaRepository<Tag, String> {

}
