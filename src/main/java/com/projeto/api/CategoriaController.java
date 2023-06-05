package com.projeto.api;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.*;
import com.projeto.dto.CategoriaDTO;
import com.projeto.model.Categoria;
import com.projeto.service.CategoriaService;

@RestController
public class CategoriaController {

	private final CategoriaService categoriaService;

	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping("/api/saveCategoria")
	public ResponseEntity<?> saveCategoria(@RequestBody CategoriaDTO categoriaDto) {
		try {
			categoriaService.saveCategoria(categoriaDto);
			return new ResponseEntity(categoriaDto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity("ERRO AO CRIAR CATEGORIA: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/api/listCategoria")
	public ResponseEntity<?> listarCategorias() {
		return new ResponseEntity(categoriaService.listarCategorias(), HttpStatus.OK);
	}
	
	@DeleteMapping("/api/deleteCategoriasById")
	public ResponseEntity<?> deleteCategoriasById(@RequestParam Long id) {
		try {
			categoriaService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("ERRO: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
