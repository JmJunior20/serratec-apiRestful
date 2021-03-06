package org.serratec.java2backend.projeto03.entity;

public class TodoEntity {
	
	private Integer id;
	private String nome;
	private Double nota;
	
	public TodoEntity(Integer id, String nome, Double nota) {
		super();
		this.id = id;
		this.nome = nome;
		this.nota = nota;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
}
