package com.projeto.service;
import java.time.LocalDate;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.dto.*;
import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {
	private String mensagem;
	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	private void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public void saveUsuario(UsuarioDTO usuarioDto) throws Exception{
		
		checkIdade(usuarioDto.getDataNascimento());
		
		Usuario usuario = new Usuario.Builder()
									 .setId(usuarioDto.getId())
									 .setNome(usuarioDto.getNome())
									 .setEmail(usuarioDto.getEmail())
									 .setSenha(usuarioDto.getSenha())
									 .build();
		usuarioRepository.save(usuario);
	}
	
	private static void checkIdade(LocalDate dataNascimento) throws Exception{
		if (!dataNascimento.isBefore(LocalDate.now().minusYears(18))) 
			throw new Exception("Menor de 18 anos!");
	}
	
	
}
