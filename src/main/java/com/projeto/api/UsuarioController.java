package com.projeto.api;


import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.projeto.dto.UsuarioDTO;
import com.projeto.service.*;

@RestController
public class UsuarioController {

	private static String mensagemRetorno;
	private Map<String, String> responseBody = new HashMap<String, String>();
	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping("/api/saveUsuario")
	public ResponseEntity<?> saveUsuario(@RequestBody UsuarioDTO usuarioDto) {

		if (!validarParametros(usuarioDto)) {
			responseBody.put("mensagem", mensagemRetorno);
			return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		try {
			usuarioService.saveUsuario(usuarioDto);
			responseBody.put("mensagem", "Usuário cadastrado com sucesso!");
			return new ResponseEntity<>(responseBody, HttpStatus.OK);
		} catch (Exception e) {
			responseBody.put("mensagem", e.getMessage());
			return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private static boolean validarParametros(UsuarioDTO usuarioDto) {
		if (usuarioDto.getNome().isBlank()) {
			mensagemRetorno = "Nome Faltante!";
			return false;
		}
		if (usuarioDto.getEmail().isBlank()) {
			mensagemRetorno = "Email Faltante!";
			return false;
		}
		if (usuarioDto.getSenha().isBlank()) {
			mensagemRetorno = "Senha Faltante!";
			return false;
		}

		if (usuarioDto.getDataNascimento() == null) {
			mensagemRetorno = "Data de Nascimento Faltante!";
			return false;
		}
		return true;
	}

}
