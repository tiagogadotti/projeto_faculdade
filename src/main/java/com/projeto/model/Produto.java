package com.projeto.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nome;
	@ManyToOne
	private Marca marca;
	@Column
	private BigDecimal preco;
	@ManyToOne
	private Categoria categoria;
	@Column
	@JsonProperty("quantidade_estoque")
	private int quantidadeEstoque;

	private Produto() {
	}

	private Produto(Produto.Builder builder) {
		this.id = builder.getId();
		this.nome = builder.getNome();
		this.marca = builder.getMarca();
		this.preco = builder.getPreco();
		this.categoria = builder.getCategoria();
		this.quantidadeEstoque = builder.getQuantidadeEstoque();
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

	public static class Builder {
		private Long id;
		private String nome;
		private Marca marca;
		private BigDecimal preco;
		private Categoria categoria;
		private int quantidadeEstoque;

		public Long getId() {
			return id;
		}

		public String getNome() {
			return nome;
		}

		public Marca getMarca() {
			return marca;
		}

		public BigDecimal getPreco() {
			return preco;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public int getQuantidadeEstoque() {
			return quantidadeEstoque;
		}

		public Builder setId(Long id) {
			this.id = id;
			return this;
		}

		public Builder setNome(String nome) {
			this.nome = nome;
			return this;
		}

		public Builder setMarca(Marca marca) {
			this.marca = marca;
			return this;
		}

		public Builder setPreco(BigDecimal preco) {
			this.preco = preco;
			return this;
		}

		public Builder setCategoria(Categoria categoria) {
			this.categoria = categoria;
			return this;
		}

		public Builder setQuantidadeEstoque(int quantidadeEstoque) {
			this.quantidadeEstoque = quantidadeEstoque;
			return this;
		}

		public Produto build() {
			return new Produto(this);
		}

	}

	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", marca=" + marca + ", preco=" + preco + ", categoria="
				+ categoria + ", quantidadeEstoque=" + quantidadeEstoque + "]";
	}

	
}
