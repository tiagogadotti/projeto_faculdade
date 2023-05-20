package com.projeto;

import java.sql.*;
import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class MarcaGetController {
	
	@GetMapping("getAllMarca")
	public List<Marca> getAllCategoria(){
		List<Marca> marcas = new ArrayList<>();
		
		try (Connection conn = DBconn.getConnection()){
			String sql = "SELECT * FROM marca c ORDER BY id ASC";
			Statement st = conn.createStatement();
			ResultSet r = st.executeQuery(sql);
			while (r.next()) {
				Marca m = new Marca(r.getLong("id"), r.getString("nome"));
				marcas.add(m);
			}			
			
		}catch(SQLException e) {
			System.out.print("Problemas na conexção: " + e.getStackTrace());			
		}
		
		return marcas;
		
		
		
		
	}
	
}
