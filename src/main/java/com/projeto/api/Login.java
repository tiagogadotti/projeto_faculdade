package com.projeto.api;

import com.projeto.dto.UsuarioDTO;
import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Login {
	
	private final UsuarioRepository usuarioRepository;
	
	public Login(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@PostMapping("/api/login")
	public ResponseEntity<?> login(@RequestBody UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		if (usuario == null) {
			return  new ResponseEntity<String>("Erro ao logar", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Login efetuado com sucesso", HttpStatus.OK);
	}
}
