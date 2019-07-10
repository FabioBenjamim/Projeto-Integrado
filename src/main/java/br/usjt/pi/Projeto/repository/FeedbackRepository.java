package br.usjt.pi.Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.usjt.pi.Projeto.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long>{
	
	@Query(value = "SELECT * FROM tb_feedback ORDER BY id DESC LIMIT 1", nativeQuery = true)
	public Feedback retornaUltimo();

}
