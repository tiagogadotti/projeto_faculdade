package com.projeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.model.*;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	Categoria getCategoriaByNome(String nome);
}
