package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import tpfinal.Barrio;
import tpfinal.Comuna;

public class ComunaDao {
	private Conexion c;
	private BarrioDao conexionBarrio;
	
	public ComunaDao(Conexion c) {
		this.c = c;
		conexionBarrio = new BarrioDao(c,this);
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
		
		String sql = "SELECT IdComuna FROM Comuna WHERE NumeroSede = ?";

		try{
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, numeroSede);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	id = rs.getInt("Idcomuna");
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
	
	public boolean existeComunaConEsteNumero(String numeroComunaACheckear) {
		boolean existe = false;
		Connection conexion = c.conectar();

		String sql = "SELECT * FROM comuna WHERE Numero_Comuna = ?";
		
		try{
			PreparedStatement stmt = conexion.prepareStatement(sql);
		
			stmt.setString(1, numeroComunaACheckear);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				existe = true;
			}
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
		return existe;
	}
	
	public ArrayList<Comuna> asociarComunasConBarrios(){
		Connection conexion = c.conectar();
		ArrayList<Comuna> comunas = conseguirTodasLasComunas();
		ArrayList<Barrio> barrios = conexionBarrio.conseguirTodosLosBarrios();

		String numeroSedeComuna;
	    String nombreBarrio;
	    
	    
	    String sql = "SELECT c.NumeroSede, b.Nombre "
	    		+ "FROM comuna c "
	    		+ "INNER JOIN barrio b "
	    		+ "    ON c.IdComuna = b.Comuna_IdComuna;";

	    try{
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	        	numeroSedeComuna = rs.getString("Numero_Comuna");
	        	nombreBarrio = rs.getString("nombre");
	        	for (Comuna com : comunas) {
	        		//hace un ciclo dentro de las comunas, para luego ver si la fila de la base de datos, que tiene un barrio asociado,
	        		//es el mismo que el del ciclo
	                if (com.getNumerocomuna().equals(numeroSedeComuna)) {
	                	//si es, hace otro ciclo de todos los barrios
	                    for (Barrio b : barrios) {
	                    		//y luego comprueba de solamente añadir el barrio el cual corresponda con la fila del inner join
	                        if (b.getNombre().equals(nombreBarrio)) {

	                            com.getBarrios().add(b);
	                            break;//corta el for de busqueda de barrios si ya lo encontró

	                        }

	                    }

	                    break;//si ya añadió el barrio, corta el for de las comunas tambien para pasar a la siguiente fila

	                }

	            }

	        }

	    }catch(SQLException e) {
	        e.printStackTrace();
	    }
		
		return comunas;
	}

}
