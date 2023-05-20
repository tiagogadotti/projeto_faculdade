package com.projeto;

public record Marca( long id, 
						String nome
						) {

	public Marca() {
		this((long)0, "");
	}
	public Marca(long id) {
		this(id, "");
	}
	public Marca(int id, String nome) {
		this((long)id, nome);
	}
}