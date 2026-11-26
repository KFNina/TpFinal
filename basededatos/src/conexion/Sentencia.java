package conexion;

public class Sentencia {
	private static Conexion conex = new Conexion();
	
	public static final ComunaDao conexionComuna = new ComunaDao(conex);
	public static final BarrioDao conexionBarrio = new BarrioDao(conex,conexionComuna);
}
