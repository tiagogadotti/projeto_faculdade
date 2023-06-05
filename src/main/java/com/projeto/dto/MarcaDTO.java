package com.projeto.dto;

import com.projeto.model.Marca;

public class MarcaDTO {

	private Long id;
	private String nome;
	private String empresa;

	public MarcaDTO() {
	}

	public MarcaDTO(Long id, String nome, String empresa) {
		this.id = id;
		this.nome = nome;
		this.empresa = empresa;
	}
	public MarcaDTO(Marca marca) {
		this.id = marca.getId();
		this.nome = marca.getNome();
		this.empresa = marca.getEmpresa();
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
	
}
