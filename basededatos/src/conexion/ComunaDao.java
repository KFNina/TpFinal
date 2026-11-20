package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tpfinal.Comuna;

public class ComunaDao {
	private Conexion c;
	
	public ComunaDao(Conexion c) {
		this.c = c;
	}
	
	
	public void cargarComuna(Comuna com) {
		Connection conexion = c.conectar();
		
		String sql = "INSERT INTO Comuna(NombreSede,NumeroSede)VALUES(?,?)";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			
			stmt.setString(2, com.getNombreComuna());
			stmt.setString(1, com.getNumerocomuna());
			
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
	
	public int conseguirId(String numeroSede) {
		int id = 0;
		Connection conexion = c.conectar();
		
		String sql = "SELECT ID_Comuna FROM Comuna WHERE Numero_Comuna = ?";

		try{
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, numeroSede);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	id = rs.getInt("ID_comuna");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

		return id;
	}
	
	public void modificarComuna(Comuna comuna, String numeroSedeAntiguo) {
		Connection conexion = c.conectar();

	    String nombre = comuna.getNombreComuna();
	    String numeroSede =comuna.getNumerocomuna();
	    
	    String sql = "UPDATE Comuna "
	    		+ "SET NombreSede = ?, "
	    		+ "    NumeroSede = ? "
	    		+ "WHERE NumeroSede = ?;";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        
	        stmt.setString(2,nombre);
	        stmt.setString(1,numeroSede);
	        stmt.setString(3,numeroSedeAntiguo);
	        
	        stmt.executeUpdate();
	        

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	}
	
	public boolean eliminarComunaSeleccionada(String numeroSede) {
		Connection conexion = c.conectar();
		String sql = "DELETE FROM Comuna where NumeroSede = ?";
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
		Connection conexion = c.conectar();
		
	    ArrayList<Comuna> comunas = new ArrayList<>();

	    String nombre;
	    String numeroComuna;
	    
	    String sql = "SELECT * FROM comuna";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	
	        	nombre = rs.getString("NombreSede");
	        	numeroComuna = rs.getString("NumeroSede");
	        	
	            Comuna comuna = new Comuna(numeroComuna, nombre);
	            
	            comunas.add(comuna);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return comunas;
	}
	
	public Comuna conseguirComunaeEspecifica(String numeroSede) {
		Connection conexion = c.conectar();
		
		Comuna com = null;

	    String nombre;
	    String numeroComuna;
	    
	    String sql = "SELECT * FROM comuna WHERE NumeroSede = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        
	        stmt.setString(1, numeroSede);
	        
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	
	        	nombre = rs.getString("NombreSede");
	        	numeroComuna = rs.getString("NumeroSede");
	        	
	            com = new Comuna(numeroComuna, nombre);
	            
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return com;
	}

}
