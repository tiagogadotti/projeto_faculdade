package com.projeto.api;

import java.util.*;
import com.projeto.dto.MarcaDTO;
import com.projeto.model.Marca;
import com.projeto.service.MarcaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarcaController {

	private final MarcaService marcaService;
	
	public MarcaController(MarcaService marcaService) {
		this.marcaService = marcaService;
	}
	@PostMapping("/api/saveMarca")
	public ResponseEntity<?> saveMarca(@RequestBody MarcaDTO marcaDto){
		System.out.println(marcaDto);
		try {
			marcaService.saveMarca(marcaDto);
			return new ResponseEntity<Map<String, String>>(Util.mapearRetornoSimples("mensagem", "Marca criada com sucesso!"), HttpStatus.CREATED);
		}catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<Map<String, String>>(Util.mapearRetornoSimples("mensagem", e.getMessage()), HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/api/listMarca")
	public List<Marca> listMarca(){
		return marcaService.listMarca();
	}
	
	@DeleteMapping("/api/deleteMarcaById")
	public ResponseEntity<?> deleteMarcaById(@RequestParam Long id) {
		try {
			marcaService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("ERRO: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
