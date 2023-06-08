package com.projeto.api;

import com.projeto.dto.ProdutoDTO;
import com.projeto.model.Produto;
import com.projeto.service.ProdutoService;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutoController {

	private final ProdutoService service;

	public ProdutoController(ProdutoService service) {
		this.service = service;
	}

	@PostMapping("/api/saveProduto")
	public ResponseEntity<?> saveProduto(@RequestBody ProdutoDTO produtoDto) {
		try {
			Map<String, String> retorno = new HashMap<>();
			service.saveProduto(produtoDto);
			retorno.put("mensagem", "Produto cadastrado com sucesso");
			return new ResponseEntity<Map<String, String>>(retorno, HttpStatus.CREATED);
		} catch (Exception e) {
			Map<String, String> retorno = new HashMap<>();
			retorno.put("mensagem", "Erro ao salvar produto: " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity<Map<String, String>>(retorno, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/api/listProduto")
	public ResponseEntity<?> listProduto(){
		return new ResponseEntity<>(service.listProduto(), HttpStatus.OK);
	}
	
	@GetMapping("/api/produtoById")
	public ResponseEntity<?> produtoById(@RequestParam Long id){
		try {
			Produto p = service.produtoById(id);
			ProdutoDTO produtoDTO = new ProdutoDTO(p);
			return new ResponseEntity<ProdutoDTO>(produtoDTO, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>("ERRO: " +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/api/deleteProdutoById")
	public ResponseEntity<?> deleteProdutoById(@RequestParam Long id){
		try {
			service.deleteProdutoById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>("ERRO: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
