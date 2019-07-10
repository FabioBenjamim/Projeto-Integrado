package br.usjt.pi.Projeto.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.pi.Projeto.model.Cards;
import br.usjt.pi.Projeto.model.Feedback;
import br.usjt.pi.Projeto.model.Imagem;
import br.usjt.pi.Projeto.model.Tag;
import br.usjt.pi.Projeto.model.Texto;
import br.usjt.pi.Projeto.model.Video;
import br.usjt.pi.Projeto.repository.CardsRepository;
import br.usjt.pi.Projeto.repository.FeedbackRepository;
import br.usjt.pi.Projeto.repository.ImagemRepository;
import br.usjt.pi.Projeto.repository.TagRepository;
import br.usjt.pi.Projeto.repository.TextoRepository;
import br.usjt.pi.Projeto.repository.VideoRepository;


@Controller
public class ImagemController {
	


	@Autowired 
	private ImagemRepository imgRe;
	
	@Autowired
	private VideoRepository vdRepo;
	
	@Autowired
	private TextoRepository txtRepo;
	
	@Autowired
	TagRepository tgRepo;
	
	@Autowired
	private CardsRepository cdRepo;
	
	@Autowired
	private FeedbackRepository fbRepo;
	
	
	@GetMapping("/Imagem")
	public ModelAndView listarTags() {
		ModelAndView mv = new ModelAndView ("Imagem");
		//Busque a coleçãocom o repositório
		//adicione a coleção ao objeto 
		 mv.addObject(new Tag());
		 mv.addObject("tags", tgRepo.findAll());
		//devolva o ModelAndView
		return mv;
	}
	
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public ModelAndView  upload(HttpServletRequest request , Cards cards) throws IOException {
		ModelAndView mv = new ModelAndView("Feedback");
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("file");
		String x =  multipartFile.getOriginalFilename();
		String array[]= new String[3];
		array = x.split("\\.");
		if(array[1].equals("txt")) {
			salvaArquivo(multipartFile);
		}else 
			if(array[1].equals("mp4")){
			salvaVideo(multipartFile);
		}else {
			salvaImagem(multipartFile);
		}
		return mv;
	}
	
	private void salvaImagem(MultipartFile multipartFile) throws IOException {
		Path diretorioPath = Paths.get("C:\\Users\\pi\\Downloads\\Projeto\\Projeto\\src\\main\\resources\\static\\","Fotos");
		Path arquivoPath = diretorioPath.resolve(multipartFile.getOriginalFilename());
		Files.createDirectories(diretorioPath);
		multipartFile.transferTo(arquivoPath.toFile());
		
		Imagem imagem = new Imagem();
		imagem.setNome(multipartFile.getOriginalFilename());
		imagem.setUrl("C:\\Users\\pi\\Downloads\\Projeto\\Projeto\\src\\main\\resources\\static\\" + imagem.getNome());
		imgRe.save(imagem);

	}
	
	private void salvaVideo(MultipartFile multipartFile) throws IOException {
		Path diretorioPath = Paths.get("C:\\Users\\pi\\Downloads\\Projeto\\Projeto\\src\\main\\resources\\static\\","Videos");
		Path arquivoPath = diretorioPath.resolve(multipartFile.getOriginalFilename());
		Files.createDirectories(diretorioPath);
		multipartFile.transferTo(arquivoPath.toFile());
		
		Video video = new Video();
		video.setNome(multipartFile.getOriginalFilename());
		video.setUrl("C:\\Users\\pi\\Download\\Projeto\\Projeto\\src\\main\\resources\\static\\" + video.getNome());
		vdRepo.save(video);;

	}
	private void salvaArquivo(MultipartFile multipartFile) throws IOException {
		Path diretorioPath = Paths.get("C:\\Users\\pi\\Downloads\\Projeto\\Projeto\\src\\main\\resources\\static\\","Arquivo");
		Path arquivoPath = diretorioPath.resolve(multipartFile.getOriginalFilename());
		Files.createDirectories(diretorioPath);
		multipartFile.transferTo(arquivoPath.toFile());
		
		Texto texto = new Texto();
		texto.setNome(multipartFile.getOriginalFilename());
		texto.setUrl("C:\\Users\\pi\\Download\\Projeto\\Projeto\\src\\main\\resources\\static\\" + texto.getNome());
		txtRepo.save(texto);;

	}
	
	@PostMapping("/posta")
	public void PostaCard(Cards cards) {
		Feedback feed = new Feedback();
		feed.setGostei(0);
		feed.setVisualizacao(0);
		fbRepo.save(feed);
		cards.setFeedback(fbRepo.retornaUltimo());
		cdRepo.save(cards);
		
	}
}
