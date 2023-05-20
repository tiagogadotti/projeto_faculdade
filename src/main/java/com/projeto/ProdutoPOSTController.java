package com.projeto;

import java.sql.*;
import java.time.LocalDateTime;
import org.json.*;
import org.springframework.web.bind.annotation.*;
import static com.projeto.DBconn.getConnection;

@RestController
public class ProdutoPOSTController {

	@GetMapping("updateProduto")
	public Produto updatetProduto(@RequestParam(name = "json", required = true) String json) {

		try (Connection conn = getConnection()) {

		} catch (SQLException e) {
			System.err.println("Erro ao conectar-se ao banco de dados: " + e.getMessage());
		}
		return null;

	}

	@PostMapping("insertProduto")
	public Produto insertProduto(@RequestBody String jsonString) {

		JSONObject json = new JSONObject(jsonString);
		System.out.println(json);
		try (Connection conn = getConnection()) {
			String sql = "INSERT INTO produto (nome, marca, preco, categoria, quantidade_estoque) VALUES(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, json.getString("nome"));
			pstmt.setInt(2, json.getInt("marca"));
			pstmt.setDouble(3, json.getDouble("preco"));
			pstmt.setInt(4, json.getInt("categoria"));
			pstmt.setInt(5, json.getInt("quantidadeEstoque"));

			int rowsInserted = pstmt.executeUpdate();
			System.out.println("rowsInserted: " + rowsInserted + " / " + LocalDateTime.now());
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			System.err.println("Erro ao conectar-se ao banco de dados: " + e.getMessage());
		}
		return null;

	}
}
