package tpfinal;

public class ComplejosHabitacionales extends Barrio{
	
	private int cantMonoblocks;
	private boolean siTieneConsorcio;
	
	public ComplejosHabitacionales(String nombre, String superficieHectarea,int cantMonoblocks, boolean siTieneConsorcio) {
		super(nombre, superficieHectarea);
		this.cantMonoblocks = cantMonoblocks;
		this.siTieneConsorcio = siTieneConsorcio;
		// TODO Auto-generated constructor stub
	}

	public int getCantMonoblocks() {
		return cantMonoblocks;
	}

	public void setCantMonoblocks(int cantMonoblocks) {
		this.cantMonoblocks = cantMonoblocks;
	}

	public boolean isSiTieneConsorcio() {
		return siTieneConsorcio;
	}

	public void setSiTieneConsorcio(boolean siTieneConsorcio) {
		this.siTieneConsorcio = siTieneConsorcio;
	}

}
