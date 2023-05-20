package com.projeto.api;

import java.sql.*;
import java.time.*;
import org.json.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import static com.projeto.DBconn.getConnection;

@RestController
public class UsuarioCadastroController {

	@PostMapping("cadastrarUsuario")
	public ResponseEntity<?> cadastrarUsuario(@RequestBody String jsonString) {
		boolean isBadRequest = false;
		String mensagemRetorno = "";
		try {
			JSONObject json = new JSONObject(jsonString);
			
			if (json.isEmpty())
				throw new JSONException("Problema ao processar os parametros");
			
			 String nome = json.getString("nome");
			 String email = json.getString("email");
			 String dataNascimento = json.getString("dataNascimento");
			 String senha = json.getString("senha");
			 
			 testBlank("nome", nome);
			 testBlank("email", email);
			 testBlank("dataNascimento", dataNascimento);
			 testBlank("senha", senha);
			 
			 testAge(dataNascimento);
			 
			
			try (Connection conn = getConnection()) {
				String sql = "INSERT INTO usuario (id, nome, senha, email) VALUES(nextval('user_id_seq'),?,?,?)";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, nome);
				pstmt.setString(2, senha);
				pstmt.setString(3, email);
				
				int rowsInserted = pstmt.executeUpdate();
				
				System.out.println("rowsInserted: " + rowsInserted + " / " + LocalDateTime.now());
				pstmt.close();
				conn.close();

			} catch (SQLException e) {
				isBadRequest = true;
				mensagemRetorno = e.getMessage();
				System.err.println("Erro ao conectar-se ao banco de dados: " + e.getMessage());
			}
			
		} catch (JSONException ex) {
			isBadRequest = true;
			mensagemRetorno = ex.getMessage();
		}

		if (isBadRequest) {
			return new ResponseEntity<>(
					new JSONObject().put("mensagem", "Problemas ao processar os parâmetros: " +mensagemRetorno).toString(),
					HttpStatus.BAD_REQUEST
			);
		}
		return new ResponseEntity<>(new JSONObject().put("mensagem", "Usuário Cadastrado com sucesso").toString(),
				HttpStatus.OK);
	}
	
	
	private static void testBlank(String parametro, String conteudo) throws JSONException{
		if (conteudo.isBlank())
			throw new JSONException(parametro + " faltante");
	}
	
	private static void testAge(String dataNascimento)  throws JSONException{
		LocalDate date = LocalDate.parse(dataNascimento);
		System.out.println(date);
		System.out.println(LocalDate.now().minusYears(18));
		if (!date.isBefore(LocalDate.now().minusYears(18)))
			throw new JSONException("Menor de 18 anos!");
	}

}
