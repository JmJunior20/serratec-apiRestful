package org.com.serratec.backend.Projeto04.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.com.serratec.backend.Projeto04.dto.BookDTO;
import org.com.serratec.backend.Projeto04.entity.BookEntity;
import org.com.serratec.backend.Projeto04.exceptions.BookNotFoundException;
import org.com.serratec.backend.Projeto04.mapper.BookMapper;
import org.com.serratec.backend.Projeto04.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	
	@Autowired
	BookRepository repository;
	
	@Autowired
	BookMapper mapper;
	
	public List<BookDTO> findAll(String ordem) {
		return repository.findAll(Sort.by(ordem)).stream().map(mapper::toDTO).collect(Collectors.toList());
	}
	
	public BookDTO findById(Long id) throws BookNotFoundException {
		Optional<BookEntity> book = repository.findById(id);
		if(book.isEmpty()) {
			throw new BookNotFoundException("O livro não foi encontrado com esse id: " + id);
		}
		return mapper.toDTO(book.get());
	}
	
	public BookDTO create(BookDTO dto) {
		return mapper.toDTO(repository.save(mapper.toEntity(dto)));
	}
	
	public BookDTO update(Long id, BookDTO entity) throws BookNotFoundException {
		BookEntity book = mapper.toEntity(this.findById(id));
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
		
		return mapper.toDTO(repository.save(book));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
