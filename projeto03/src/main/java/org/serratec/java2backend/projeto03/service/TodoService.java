package org.serratec.java2backend.projeto03.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.java2backend.projeto03.entity.TodoEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	List<TodoEntity> Lista = new ArrayList<TodoEntity>();
	
	public void create(TodoEntity aluno) {
		Lista.add(aluno);
	}
	
	public List<TodoEntity> getAll() {
		return this.Lista;
	}
	
	public TodoEntity procurar(Integer id) {
		for (TodoEntity element : Lista) {
			if (element.getId() == id) {
				return element;
			}
		}
		System.out.println("Id não encontrado");
		return null;
	}
	
	public void update(TodoEntity aluno) {
		for (TodoEntity element : Lista) {
			if (element.getId() == aluno.getId()) {
				element.setNome(aluno.getNome());
				element.setNota(aluno.getNota());
			}
		}
	}
	
	public void delete(Integer id) {
		for (TodoEntity element : Lista) {
			if (element.getId() == id) {
				Lista.remove(element);
				break;
			}
		}
	}
}
