package br.usjt.pi.Projeto.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.usjt.pi.Projeto.model.Cards;

public interface CardsRepository extends JpaRepository<Cards,Long>{

	@Query ("SELECT a FROM Cards a WHERE a.categoria = ?1")
	public List <Cards> buscarPorCategoria (String categoria);
	
	@Query ("SELECT  a FROM Cards a where a.tag like %?1%")
	public List <Cards> buscarPorTag (String titulo);
	
	@Query ("SELECT a FROM Cards a WHERE a.titulo = ?1")
	public Cards buscarCorpo (String nome);
	
	@Transactional
	@Modifying
	@Query("Update Feedback set visualizacao = ?1 where id = ?2")
	public void attVisu(int visu, long id);
	
	@Transactional
	@Modifying
	@Query("Update Feedback set gostei = ?1 where id = ?2")
	public void attLike(int visu, long id);
	
	
}
