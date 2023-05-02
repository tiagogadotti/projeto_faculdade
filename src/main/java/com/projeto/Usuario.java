package com.projeto;

public record Usuario(  long id, 
						String nome,
						String email,
						String senha
						) {

	public Usuario() {
		this((long)0, "", "", "");
	}
	public Usuario(long id) {
		this(id, "", "", "");
	}	
	public Usuario(int id, String nome) {
		this((long)id, nome, "", "");
	}
	public Usuario(int id, String nome, String senha, String email){
		this((long)id, nome, email, senha);
	}
	
	


}
