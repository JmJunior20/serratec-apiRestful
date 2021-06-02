package org.com.serratec.backend.Projeto04.controller;

import java.util.List;

import org.com.serratec.backend.Projeto04.entity.BookEntity;
import org.com.serratec.backend.Projeto04.exceptions.BookNotFoundException;
import org.com.serratec.backend.Projeto04.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class BookController {

	@Autowired
	BookService service;
	
	@GetMapping
	public ResponseEntity<List<BookEntity>> getAll(@RequestParam(name= "ordenar", required = false, defaultValue = "id") String ordem) {
		return new ResponseEntity<List<BookEntity>>(service.findAll(ordem), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookEntity> getBuId(@PathVariable long id) throws BookNotFoundException {
		return new ResponseEntity<BookEntity>(service.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BookEntity> create(@RequestBody BookEntity entity) {
		return new ResponseEntity<BookEntity>(service.create(entity), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookEntity> update(@PathVariable Long id, @RequestBody BookEntity entity) throws BookNotFoundException {
		return new ResponseEntity<BookEntity>(service.update(id, entity), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
	}
}
