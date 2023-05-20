package com.projeto;

import java.sql.*;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import static com.projeto.DBconn.getConnection;

@RestController
public class ProdutoGETController {

	@GetMapping("getProdutoById")
	public Produto getProduto(@RequestParam(name = "id", required = true) long id) {

		try (Connection conn = getConnection()) {
			String sql = "SELECT p.id as idProduto, p.nome as nomeProduto, m.nome as nomeMarca, p.preco as precoProduto, c.nome as nomeCategoria, p.quantidade_estoque as quantidadeEstoque FROM produto p  JOIN marca m on p.marca = m.id  JOIN categoria c on p.categoria = c.id WHERE p.id = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return new Produto(rs.getInt("idProduto"), rs.getString("nomeProduto"), rs.getString("nomeMarca"),
					rs.getBigDecimal("precoProduto"), rs.getString("nomeCategoria"), rs.getInt("quantidadeEstoque"));

		} catch (SQLException e) {

			System.err.println("Erro ao conectar-se ao banco de dados: " + e.getMessage());
		}
		return null;

	}
	
	
	@GetMapping("getAllListaProdutos")
	public List<Produto> getAllListaProdutos() {
		List<Produto> listaProdutos = new ArrayList<>();
		try (Connection conn = getConnection()) {
			String sql = "SELECT p.id as idProduto, p.nome as nomeProduto, m.nome as nomeMarca, p.preco as precoProduto, c.nome as nomeCategoria, p.quantidade_estoque as quantidadeEstoque FROM produto p  JOIN marca m on p.marca = m.id JOIN categoria c on p.categoria = c.id";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				listaProdutos.add(
						new Produto(
									rs.getInt("idProduto"), 
									rs.getString("nomeProduto"), 
									rs.getString("nomeMarca"),
									rs.getBigDecimal("precoProduto"), 
									rs.getString("nomeCategoria"), 
									rs.getInt("quantidadeEstoque")));
			}
			return listaProdutos;
		} catch (SQLException e) {

			System.err.println("Erro ao conectar-se ao banco de dados: " + e.getMessage());
		}
		return null;

	}

}
