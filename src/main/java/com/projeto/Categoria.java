package com.projeto;

public record Categoria( long id, 
						String nome
						) {

	public Categoria() {
		this((long)0, "");
	}
	public Categoria(long id) {
		this(id, "");
	}
	public Categoria(int id, String nome) {
		this((long)id, nome);
	}
}