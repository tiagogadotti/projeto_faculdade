package com.projeto;

import java.sql.*;
import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaGetController {
	
	@GetMapping("getAllCategoria")
	public List<Categoria> getAllCategoria(){
		List<Categoria> categorias = new ArrayList<>();
		
		try (Connection conn = DBconn.getConnection()){
			String sql = "SELECT * FROM categoria c ORDER BY id ASC";
			Statement st = conn.createStatement();
			ResultSet r = st.executeQuery(sql);
			while (r.next()) {
				Categoria c = new Categoria(r.getLong("id"), r.getString("nome"));
				categorias.add(c);
			}			
			
		}catch(SQLException e) {
			System.out.print("Problemas na conexção: " + e.getStackTrace());			
		}
		
		return categorias;
		
		
		
		
	}
	
}
