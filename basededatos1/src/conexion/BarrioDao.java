package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tpfinal.Barrio;
import tpfinal.ComplejosHabitacionales;
import tpfinal.TrazadoFormal;
import tpfinal.UrbanizacionPlanificada;

public class BarrioDao {
	private Conexion c;
	private ComunaDao conexComuna;

	public BarrioDao(Conexion c, ComunaDao conexComuna) {
		this.c = c;
		this.conexComuna = conexComuna;
	}
	
	
	public void cargarBarrio(Barrio b, String numeroSedeComuna) {
		Connection conexion = c.conectar();
		String sql = "INSERT INTO `tpfinalnk`.`barrio`(`Nombre`,`Superficie`,`CantEdificios`,`PorcentajeAsfalto`,`NumLey`,`ConexionAgua`,`CantMonoblock`,`TieneConsorcio`,`Comuna_idComuna`)\r\n"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?);";
		
		try {
			PreparedStatement stmt = conexion.prepareStatement(sql);
			
			stmt.setFloat(2, b.getSuperficieHectarea());
			stmt.setString(1, b.getNombre());
			stmt.setInt(9, conexComuna.conseguirId(numeroSedeComuna));
			
			for(int i = 3;i<9;i++) {
				stmt.setObject(i, null);
			}
			
			
			if(b instanceof ComplejosHabitacionales) {
				ComplejosHabitacionales barrioCH = (ComplejosHabitacionales) b; 
				
				stmt.setInt(7, barrioCH.getCantMonoblocks());
				stmt.setBoolean(8,barrioCH.getSiTieneConsorcio());
				
			}
			else if(b instanceof TrazadoFormal) {
				
				TrazadoFormal barrioTF = (TrazadoFormal) b;
				
				stmt.setInt(3, barrioTF.getCantEdificios());
				stmt.setInt(4, barrioTF.getPorcetajeAsfalto());
			}
			else if(b instanceof UrbanizacionPlanificada) {
				UrbanizacionPlanificada barrioUP = (UrbanizacionPlanificada) b;
				
				stmt.setString(5, barrioUP.getLeyLegislatura());
				stmt.setBoolean(6, barrioUP.isConexionAguaPotable());
				
			}
			
			stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}		
		
	}
	
	public boolean eliminarBarrioSeleccionado(String nombreBarrio) {
		
		Connection conexion = c.conectar();
		String sql = "DELETE FROM barrio WHERE nombre = ?";
		int filasAfectadas = 0;
		try {
		
			PreparedStatement stmt = conexion.prepareStatement(sql);
	
	        stmt.setString(1, nombreBarrio);
	        
	        filasAfectadas = stmt.executeUpdate();
	
		
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
		return filasAfectadas > 0;
	}
	
	public void modificarBarrioElegido(Barrio b, String nombreBarrioAntiguo, String numeroSedeComuna) {
		Connection conexion = c.conectar();
		String nombre = b.getNombre();
	    float superficie = b.getSuperficieHectarea();
	    
	    String sql = "UPDATE `barrio`"
	    		+ "SET"
	    		+ "`Nombre` = ?,`Superficie` = ?,"
	    		+ "`CantEdificios` =?,`PorcentajeAsfalto` = ?,`NumLey` =?,"
	    		+ "`ConexionAgua` = ?,`CantMonoblock` = ?,`TieneConsorcio` = ?,`Comuna_idComuna` =?"
	    		+ "WHERE `idBarrio` = ?;";

	    try{
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        
	        stmt.setFloat(2,superficie);
	        stmt.setString(1,nombre);
	        stmt.setInt(9,conexComuna.conseguirId(numeroSedeComuna));
	        stmt.setString(10,nombreBarrioAntiguo);
	        
	        for(int i = 3;i<9;i++) {
				stmt.setObject(i, null);
			}
			
	        if(b instanceof ComplejosHabitacionales) {
				ComplejosHabitacionales barrioCH = (ComplejosHabitacionales) b; 
				
				stmt.setInt(7, barrioCH.getCantMonoblocks());
				stmt.setBoolean(8,barrioCH.getSiTieneConsorcio());
				
			}
			else if(b instanceof TrazadoFormal) {
				
				TrazadoFormal barrioTF = (TrazadoFormal) b;
				
				stmt.setInt(3, barrioTF.getCantEdificios());
				stmt.setInt(4, barrioTF.getPorcetajeAsfalto());
			}
			else if(b instanceof UrbanizacionPlanificada) {
				UrbanizacionPlanificada barrioUP = (UrbanizacionPlanificada) b;
				
				stmt.setString(5, barrioUP.getLeyLegislatura());
				stmt.setBoolean(6, barrioUP.isConexionAguaPotable());
				
			}
	        
	        stmt.executeUpdate();
	        

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	}
	
	public Barrio buscarBarrioPorNombre(String nombreBarrioAntiguo){
		Barrio b = null;
		
		Connection conexion = c.conectar();
		
		String nombre;
	    float superficie;
	    
	    int cantMonoblock;
	    boolean tieneConsorcio;
	    
	    int cantEdificios;
	    int porcentajeAsf;
	    
	    String numLey;
	    boolean conexionAgua;
	    
	    boolean esComplejo;
	    boolean esTrazadoFormal;
	    String sql = "SELECT * FROM barrio WHERE nombre = ?";

	    try {
	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        
	        stmt.setString(1, nombreBarrioAntiguo);
	        
	        ResultSet rs = stmt.executeQuery();
	        
	        
	        while(rs.next()) {
	       	 	
	 		   nombre = rs.getString("nombre");
	 		   superficie = rs.getFloat("Superficie");
	 		   	
	 		   cantMonoblock = rs.getInt("CantMonoblock");
	 		   tieneConsorcio = rs.getBoolean("TieneConsorcio");
	 		   
	 		   esComplejo = !rs.wasNull();
	 		        
	 		        
	 		   porcentajeAsf = rs.getInt("PorcentajeAsfalto");
	 		   cantEdificios = rs.getInt("CantEdificios");
	 		        	
	 		   esTrazadoFormal = !rs.wasNull();
	 		        	
	 		   numLey = rs.getString("Numley"); 
	 		   conexionAgua = rs.getBoolean("ConexionAgua");
	 		        	
	 		        	
	 		   if(esComplejo) 
	 		   {
	 			   b = (Barrio) new ComplejosHabitacionales(nombre,superficie, cantMonoblock,tieneConsorcio);
	 		   }
	 		   else if(esTrazadoFormal) {
	 			   b = (Barrio) new TrazadoFormal(nombre,superficie,cantEdificios, porcentajeAsf);
	 		   }
	 		   else {
	 			   b = (Barrio) new UrbanizacionPlanificada(nombre,superficie,numLey,conexionAgua);
	 		   }

	            
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        
	    }		
	    
		return b;
	}
	
}