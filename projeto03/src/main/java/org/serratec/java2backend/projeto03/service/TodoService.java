package org.serratec.java2backend.projeto03.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2backend.projeto03.entity.TodoEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	List<TodoEntity> lista = new ArrayList<TodoEntity>();
	
	public TodoEntity create(TodoEntity aluno) {
		lista.add(aluno);
		return aluno;
	}
	
	public List<TodoEntity> getAll() {
		return this.lista;
	}
	
	public TodoEntity procurar(Integer id) {
		for (TodoEntity element : lista) {
			if (element.getId() == id) {
				return element;
			}
		}
		System.out.println("Id não encontrado");
		return null;
	}
	
	public TodoEntity update(Integer id, TodoEntity aluno) {
		for (TodoEntity element : lista) {
			if (element.getId() == id) {
				if (aluno.getNome() != null) {
					element.setNome(aluno.getNome());
				}
				if (aluno.getNota() != null) {
					element.setNota(aluno.getNota());
				}
				return element;
			}			
		}
		System.out.println("Não temos tarefas com esse id");
		return null;
	}
	
	public String delete(Integer id) {
		for (TodoEntity element : lista) {
			if (element.getId() == id) {
				lista.remove(element);
				return "Deletado com sucesso";
			}
		}
		return "Id não encontrado";
	}
}
