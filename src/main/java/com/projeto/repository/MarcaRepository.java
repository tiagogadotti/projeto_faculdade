package com.projeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto.model.*;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
	Marca getByNome(String nome);
}
