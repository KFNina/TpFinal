package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tpfinal.Comuna;

public class Conexion {
	String user = "root";
	String psw = "admin";

	
	String path = "jdbc:mysql://localhost:3306/Tpfinalnk";
		
		
	public Connection conectar() {
		Connection c = null;
		try {
			c = DriverManager.getConnection(path, user, psw);
			System.out.println("g");
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return c;
	}
	
	
}
