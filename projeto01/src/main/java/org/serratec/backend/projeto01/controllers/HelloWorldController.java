package org.serratec.backend.projeto01.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saudacao")
public class HelloWorldController {
	
	@GetMapping("/ola")
	public String olaMundo(@RequestParam String nome) {
		return nome.toUpperCase();
	}
	
	@RequestMapping("/numero")
	public int olaNumero() {
		return 50;
	}
	
	@RequestMapping("/boolean")
	public boolean verdadeiro() {
		return true;
	}

}
