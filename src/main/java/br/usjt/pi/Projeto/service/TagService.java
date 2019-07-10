package br.usjt.pi.Projeto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.usjt.pi.Projeto.model.Tag;
import br.usjt.pi.Projeto.repository.TagRepository;

@Service
public class TagService {

	TagRepository tgRepo;
	
	public List<Tag> ProcurarTag(){
		List <Tag> tg = tgRepo.findAll();
		return tg;
	}
}
