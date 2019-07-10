package br.usjt.pi.Projeto.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.pi.Projeto.JPAUtil;
import br.usjt.pi.Projeto.model.Link;
import br.usjt.pi.Projeto.repository.LinkRepository;

@Service
public class LinkService {
	
	@Autowired
	private LinkRepository lkRepo;
	
	public void salvar(Link link) {
		lkRepo.save(link);
	}
	
	public Link UltimoElemento() {
		List<Link> linkLista = lkRepo.findAll();
		Link link  = new Link();
		link = linkLista.get(linkLista.size()-1);
		return link;
	}
	public void Atualiza(Link link) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Link l = manager.find(Link.class, 1L);
		l.setLinkNome();
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}
}
