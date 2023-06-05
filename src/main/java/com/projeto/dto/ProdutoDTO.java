package com.projeto.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.projeto.model.Categoria;
import com.projeto.model.Marca;
import com.projeto.model.Produto;


public class ProdutoDTO {
	private Long id;
	private String nome;
	private Marca marca;
	private BigDecimal preco;
	private Categoria categoria;
	@JsonProperty("quantidade_estoque")
	private int quantidadeEstoque;

	public ProdutoDTO() {
	}

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.marca = produto.getMarca();
		this.preco = produto.getPreco();
		this.categoria = produto.getCategoria();
		this.quantidadeEstoque = produto.getQuantidadeEstoque();
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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	
	

	@Override
	public String toString() {
		return "ProdutoDTO [id=" + id + ", nome=" + nome + ", marca=" + marca + ", preco=" + preco + ", categoria="
				+ categoria + ", quantidadeEstoque=" + quantidadeEstoque + "]";
	}
	
}
