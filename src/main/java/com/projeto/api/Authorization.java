package com.projeto.api;

import java.sql.*;
import java.sql.SQLException;
import com.projeto.*;

import org.json.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Authorization {
//	@PostMapping("/api/login")
//	public ResponseEntity<Boolean> login(@RequestBody String jsonString) {
//		boolean isAuthorized = false;
//		JSONObject json = new JSONObject(jsonString);
//		try(Connection conn = DBconn.getConnection()){
//			String sql = "select * from usuario WHERE email = ? AND senha = ?";
//			PreparedStatement stat = conn.prepareStatement(sql);
//			stat.setString(1, json.getString("email"));
//			stat.setString(2, json.getString("senha"));
//			ResultSet r = stat.executeQuery();
//			if(!r.isBeforeFirst()) {
//				isAuthorized = false;
//				System.out.println("Tentativa de login: " + "email: " + json.getString("email") + " senha: " + json.getString("senha"));
//			}else {
//				System.out.println("Login com sucesso: " + "email: " + json.getString("email") + " senha: " + json.getString("senha"));
//				isAuthorized =  true;
//			}
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return ResponseEntity.ok(isAuthorized);
//	}
}
