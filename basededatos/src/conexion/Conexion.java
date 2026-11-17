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
	String path = "jdbc:mysql://localhost:3306/mydb";
		
		
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
	

	public void cargarComuna(Comuna c) {
		Connection conexion = conectar();
		
		String sql = "INSERT INTO Comuna(Nombre,NumeroDeSede)VALUES(?,?)";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1, c.getNombreComuna());
			stmt.setString(2, c.getNumerocomuna());
			
			stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			try {
				conexion.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void modificarComuna(Comuna comuna, String numeroSedeAntiguo) {
		Connection c = conectar();

	    String nombre = comuna.getNombreComuna();
	    String numeroSede =comuna.getNumerocomuna();
	    
	    String sql = "UPDATE Comuna "
	    		+ "SET Nombre = ?, "
	    		+ "    NumeroDeSede = ? "
	    		+ "WHERE NumeroDeSede = ?;";

	    try {
	        PreparedStatement stmt = c.prepareStatement(sql);
	        
	        stmt.setString(1,nombre);
	        stmt.setString(2,numeroSede);
	        stmt.setString(3,numeroSedeAntiguo);
	        
	        stmt.executeUpdate();
	        

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	}
	
	public boolean eliminarComunaSeleccionada(String numeroSede) {
		Connection conexion = conectar();
		String sql = "DELETE FROM Comuna where NumeroDeSede = ?";
		int filasAfectadas = 0;
		try {
		
			PreparedStatement stmt = conexion.prepareStatement(sql);

	        stmt.setString(1, numeroSede);
	        
	        filasAfectadas = stmt.executeUpdate();

		
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			try {
				conexion.close();

			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
		return filasAfectadas > 0;
	}
	
	public ArrayList<Comuna> conseguirTodasLasComunas() {
		Connection c = conectar();
		
	    ArrayList<Comuna> comunas = new ArrayList<>();

	    String nombre;
	    String numeroComuna;
	    
	    String sql = "SELECT * FROM comuna";

	    try {
	        PreparedStatement stmt = c.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	
	        	nombre = rs.getString("Nombre");
	        	numeroComuna = rs.getString("NumeroDeSede");
	        	
	            Comuna comuna = new Comuna(numeroComuna, nombre);
	            
	            comunas.add(comuna);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return comunas;
	}
	
	
}
