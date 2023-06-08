
package com.projeto.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.projeto.dto.ProdutoDTO;
import com.projeto.model.*;
import com.projeto.repository.*;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;
	private final MarcaRepository marcaRepository;
	private final CategoriaRepository categoriaRepository;

	public ProdutoService(ProdutoRepository produtoRepository, MarcaRepository marcaRepository,
			CategoriaRepository categoriaRepository) {
		this.produtoRepository = produtoRepository;
		this.marcaRepository = marcaRepository;
		this.categoriaRepository = categoriaRepository;
	}

	public void saveProduto(ProdutoDTO produtoDto) throws Exception {
		
		Marca marca = (Marca) marcaRepository.getByNome(produtoDto.getMarca().getNome().toUpperCase());
		Categoria categoria = (Categoria) categoriaRepository.getCategoriaByNome(produtoDto.getCategoria().getNome().toUpperCase());
		
		if (marca == null) {
			produtoDto.getMarca().setNome(produtoDto.getMarca().getNome().toUpperCase());
			marca = marcaRepository.save(produtoDto.getMarca());
		}
		
		if (categoria == null) {
			produtoDto.getCategoria().setNome(produtoDto.getCategoria().getNome().toUpperCase());;
			categoria = categoriaRepository.save(produtoDto.getCategoria());
		}
				
		Produto produto = new Produto.Builder().setId(produtoDto.getId()).setCategoria(categoria).setMarca(marca)
				.setNome(produtoDto.getNome()).setPreco(produtoDto.getPreco())
				.setQuantidadeEstoque(produtoDto.getQuantidadeEstoque()).build();
		
		produtoRepository.save(produto);

	}

	public List<Produto> listProduto() {
		return produtoRepository.findAll();
	}

	public Produto produtoById(Long id) {
		return produtoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Produto com id " + id + " não encontrado"));
	}
	
	public void deleteProdutoById(Long id) throws Exception{
		produtoRepository.deleteById(id);
	}
	
}
