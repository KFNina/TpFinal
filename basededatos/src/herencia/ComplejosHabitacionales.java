package herencia;

public final class ComplejosHabitacionales extends Barrio{
	
	private int cantMonoblocks;
	private boolean siTieneConsorcio;
	
	public ComplejosHabitacionales(String nombre, float superficieHectarea,int cantMonoblocks, boolean siTieneConsorcio) {
		super(nombre, superficieHectarea);
		this.cantMonoblocks = cantMonoblocks;
		this.siTieneConsorcio = siTieneConsorcio;
		// TODO Auto-generated constructor stub
	}
	
	public boolean tieneCriticidad() {
		if(siTieneConsorcio == false) {
			return true;
		}else {
			return false;
		}
	}
	
	public float calcularDensidad() {
		float densidad = getCantPersonas().size() /  cantMonoblocks;
		
		return densidad;
	}
	
	public int getCantMonoblocks() {
		return cantMonoblocks;
	}

	public void setCantMonoblocks(int cantMonoblocks) {
		this.cantMonoblocks = cantMonoblocks;
	}

	public boolean getSiTieneConsorcio() {
		return siTieneConsorcio;
	}

	public void setSiTieneConsorcio(boolean siTieneConsorcio) {
		this.siTieneConsorcio = siTieneConsorcio;
	}

}
