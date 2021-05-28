package org.serratec.backend.projeto04.controllers;

import java.util.List;

import org.serratec.backend.projeto04.entity.ContaEntity;
import org.serratec.backend.projeto04.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	ContaService service;	
	
	@GetMapping
	public List<ContaEntity> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{numero}")
	public ContaEntity procurar(@PathVariable Integer numero) {
		return service.procurar(numero);
	}
	
	@PostMapping
	public ContaEntity create(@RequestBody ContaEntity conta) {
		return service.create(conta);
	}
	
	@PutMapping("/{numero}")
	public ContaEntity update(@PathVariable Integer numero, @RequestBody ContaEntity conta) {
		return service.update(numero, conta);
	}
	
	@DeleteMapping("/{numero}")
	public String delete(@PathVariable Integer numero) {
		return service.delete(numero);
	}
	
}
