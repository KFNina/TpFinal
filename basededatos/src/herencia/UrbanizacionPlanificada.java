package herencia;

public final class UrbanizacionPlanificada extends Barrio {
	
	private String leyLegislatura;     
	private boolean conexionAguaPotable;
	
	public UrbanizacionPlanificada(String nombre, float superficieHectarea,String leyLegislatura, boolean conexionAguaPotable) {
		super(nombre, superficieHectarea);
		this.conexionAguaPotable = conexionAguaPotable;
		this.leyLegislatura = leyLegislatura;
		// TODO Auto-generated constructor stub
	}
	
	public boolean tieneCriticidad() {
		if(conexionAguaPotable == false) {
			return true;
		}else {
			return false;
		}
	}
	
	public float calcularDensidad() {
		float densidad = getCantPersonas().size() / getSuperficieHectarea();
		
		return densidad;
	}

	public String getLeyLegislatura() {
		return leyLegislatura;
	}

	public void setLeyLegislatura(String leyLegislatura) {
		this.leyLegislatura = leyLegislatura;
	}

	public boolean isConexionAguaPotable() {
		return conexionAguaPotable;
	}

	public void setConexionAguaPotable(boolean conexionAguaPotable) {
		this.conexionAguaPotable = conexionAguaPotable;
	}
	
}
