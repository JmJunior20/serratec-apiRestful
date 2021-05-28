package org.serratec.java2backend.projeto03.controllers;

import java.util.List;

import org.serratec.java2backend.projeto03.entity.TodoEntity;
import org.serratec.java2backend.projeto03.service.TodoService;
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
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@GetMapping
	public List<TodoEntity> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public TodoEntity procurar(@PathVariable Integer id) {
		return service.procurar(id);
	}
	
	@PostMapping
	public TodoEntity criar(@RequestBody TodoEntity aluno) {
		return service.create(aluno);
	}	
	
	@PutMapping("/{id}")
	public TodoEntity update(@PathVariable Integer id, @RequestBody TodoEntity aluno) {
		return service.update(id, aluno);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		return service.delete(id);
	}	
}
