package com.projeto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	
	private static String url = "jdbc:postgresql://127.0.0.1:5433/supermercado";
    private static final String user = "postgres";
    private static final String password = "postgres";  
    private static final String driver = "org.postgresql.Driver";
    
    public static Connection getConnection() throws SQLException {
    	try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL driver not found", e);
        }
        return DriverManager.getConnection(url, user, password);
    }
}
