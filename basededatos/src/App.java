import conexion.Conexion;
import tpfinal.Comuna;

public class App {
	
	public static void main(String[] args) {
		
		Conexion c = new Conexion();
		
		Comuna com = new Comuna("Kevin","3");
		
		c.cargarComuna(com);
	}
}
