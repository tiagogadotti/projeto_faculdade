package com.projeto.service;

import com.projeto.dto.MarcaDTO;
import com.projeto.model.Marca;
import com.projeto.repository.MarcaRepository;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class MarcaService {

	private final MarcaRepository marcaRepository;
	
	public MarcaService(MarcaRepository marcaRepository) {
		this.marcaRepository = marcaRepository;
	}
	
	public void saveMarca(MarcaDTO marcaDto) {
		Marca marca = new Marca(marcaDto.getId(), marcaDto.getNome().toUpperCase(), marcaDto.getEmpresa());
		marcaRepository.save(marca);
	}
	
	public List<Marca> listMarca(){
		return marcaRepository.findAll();
	}
	
	public void deleteById(Long id) {
		marcaRepository.deleteById(id);
	}
	
}
