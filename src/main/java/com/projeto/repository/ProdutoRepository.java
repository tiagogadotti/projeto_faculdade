package com.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
