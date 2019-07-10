package br.usjt.pi.Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.usjt.pi.Projeto.model.Video;

public interface VideoRepository extends JpaRepository<Video, Long>{
	
	Video findById(long id);

}
