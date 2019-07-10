package br.usjt.pi.Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.pi.Projeto.model.Texto;

public interface TextoRepository extends JpaRepository<Texto,Long>{

}
