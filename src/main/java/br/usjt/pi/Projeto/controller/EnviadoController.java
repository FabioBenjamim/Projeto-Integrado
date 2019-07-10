package br.usjt.pi.Projeto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/Enviado")

public class EnviadoController {

	@GetMapping("/Enviado")
	public String ola() {
		return "Enviado";
	}
}
