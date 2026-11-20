package herencia;

public final class TrazadoFormal extends Barrio{
	
	private int cantEdificios;
	private int porcetajeAsfalto;
	
	public TrazadoFormal(String nombre, float superficieHectarea, int cantEdificios, int porcentajeAsfalto) {
		super(nombre, superficieHectarea);
		this.porcetajeAsfalto = porcentajeAsfalto;
		this.cantEdificios = cantEdificios;
	}
	
	public boolean tieneCriticidad() {
		if(porcetajeAsfalto < 95) {
			return true;
		}else {
			return false;
		}
	}
	
	public float calcularDensidad() {
		float densidad = getCantPersonas().size() / cantEdificios;
		
		return densidad;
	}

	public int getCantEdificios() {
		return cantEdificios;
	}

	public void setCantEdificios(int cantEdificios) {
		this.cantEdificios = cantEdificios;
	}

	public int getPorcetajeAsfalto() {
		return porcetajeAsfalto;
	}

	public void setPorcetajeAsfalto(int porcetajeAsfalto) {
		this.porcetajeAsfalto = porcetajeAsfalto;
	}

}
