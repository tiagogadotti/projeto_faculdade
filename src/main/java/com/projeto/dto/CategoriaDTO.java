package com.projeto.dto;
import com.projeto.model.Categoria;

public class CategoriaDTO {
		private Long id;
		private String nome;

		public CategoriaDTO() {}

		public CategoriaDTO(Long id, String nome) {
			this.id = id;
			this.nome = nome;
		}
		
		public CategoriaDTO(Categoria caterogia) {
			this.id = caterogia.getId();
			this.nome = caterogia.getNome();
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
	
}
