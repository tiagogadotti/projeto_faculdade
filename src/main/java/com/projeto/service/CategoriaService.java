package com.projeto.service;

import com.projeto.repository.CategoriaRepository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projeto.dto.*;
import com.projeto.model.Categoria;

@Service
public class CategoriaService {

	private final CategoriaRepository categoriaRepository;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public void saveCategoria(CategoriaDTO categoriaDto) throws Exception {
		Categoria categoria = new Categoria(categoriaDto.getNome().toUpperCase());
		categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listarCategorias(){
		return categoriaRepository.findAll();
	}
	
	public void deleteById(Long id) {
		categoriaRepository.deleteById(id);
	}
	
	
}
