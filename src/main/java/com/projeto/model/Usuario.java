package com.projeto.model;
import jakarta.persistence.*;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String nome;
	@Column
	private String email;
	@Column
	private String senha;

	public Usuario() {}

	public Usuario(Usuario.Builder builder) {
		this.id = builder.id;
		this.nome = builder.nome;
		this.senha = builder.senha;
		this.email = builder.email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public static class Builder{
		private long id;
		private String nome;
		private String email;
		private String senha;
		
		public Builder setId(long id) {
			this.id = id;
			return this;
		}
		public Builder setNome(String nome) {
			this.nome = nome;
			return this;
		}
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}
		public Builder setSenha(String senha) {
			this.senha = senha;
			return this;
		}
		public Usuario build() {
			return new Usuario(this);
		}
	}

	
}
