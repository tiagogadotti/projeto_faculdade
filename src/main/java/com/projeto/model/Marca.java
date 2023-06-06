package com.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Embeddable
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String nome;
	@Column
	private String empresa;	

	public Marca() {
	}

	public Marca(Long id, String nome, String empresa) {
		this.id = id;
		this.nome = nome;
		this.empresa = empresa;
	}

	public Marca(String nome, String empresa) {
		super();
		this.nome = nome;
		this.empresa = empresa;
	}

	public Marca(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", nome=" + nome + ", empresa=" + empresa + "]";
	}

}