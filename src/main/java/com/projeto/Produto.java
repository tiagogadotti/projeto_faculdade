package com.projeto;

import java.math.BigDecimal;

public record Produto(	long id, 
						String nome, 
						String marca, 
						BigDecimal preco, 
						String categoria, 
						int quantidadeEstoque
						) {

	public Produto() {
		this((long)0, "", "", BigDecimal.ZERO, "", 0 );
	}
	public Produto(long id) {
		this(id, "", "", BigDecimal.ZERO, "", 0 );
	}
	public Produto(int id, String nome, String marca, BigDecimal preco) {
		this((long)id, nome, marca, preco, "", 0);
	}
	public Produto(int id, String nome, String marca, BigDecimal preco, String categoria, int quantidadeEstoque) {
		this((long)id, nome, marca, preco, categoria, quantidadeEstoque);
	}
	

}
