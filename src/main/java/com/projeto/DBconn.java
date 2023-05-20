package com.projeto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	
//	private static String url = "jdbc:postgresql://127.0.0.1:5433/supermercado";
//    private static final String user = "postgres";
//    private static final String password = "postgres";
    
    private static String url = "jdbc:h2:file:./src/main/database/projeto_new;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;IFEXISTS=TRUE";
    private static final String user = "sa";
    private static final String password = "";
    private static final String driver = "org.h2.Driver";

    public static Connection getConnection() throws SQLException {
    	try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new SQLException("H2 driver not found", e);
        }
        return DriverManager.getConnection(url, user, password);
    }
}
