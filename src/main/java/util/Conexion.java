package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/zk_practica";
    private static final String USER = "root";
    private static final String PASS = "root";
    
    public static Connection getConnection() {
    	
    	Connection conn = null;
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		conn = DriverManager.getConnection(URL, USER, PASS);
    		return conn;
    		
    		
    	}catch (Exception e) {
    		
    	e.printStackTrace();
    	return null;
    	}
    	
    	
    }
}

