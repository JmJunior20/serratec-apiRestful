package org.com.serratec.backend.Projeto04.service;

import java.util.List;
import java.util.Optional;

import org.com.serratec.backend.Projeto04.entity.BookEntity;
import org.com.serratec.backend.Projeto04.exceptions.BookNotFoundException;
import org.com.serratec.backend.Projeto04.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	
	@Autowired
	BookRepository repository;
	
	public List<BookEntity> findAll(String ordem) {
		return repository.findAll(Sort.by(ordem));
	}
	
	public BookEntity findById(Long id) throws BookNotFoundException {
		Optional<BookEntity> book = repository.findById(id);
		if(book.isEmpty()) {
			throw new BookNotFoundException("O livro não foi encontrado com esse id: " + id);
		}
		return book.get();
	}
	
	public BookEntity create(BookEntity entity) {
		return repository.save(entity);
	}
	
	public BookEntity update(Long id, BookEntity entity) throws BookNotFoundException {
		BookEntity book = this.findById(id);
		if(entity.getTitulo() != null) {
			book.setTitulo(entity.getTitulo());
		}
		if(entity.getAutor() != null) {
			book.setAutor(entity.getAutor());
		}
		if(entity.getTipo() != null) {
			book.setTipo(entity.getTipo());
		}
		if(entity.getData() != null) {
			book.setData(entity.getData());
		}
		
		return repository.save(book);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
