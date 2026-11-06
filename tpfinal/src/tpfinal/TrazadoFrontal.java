package tpfinal;

public class TrazadoFrontal extends Barrio{
	
	private int cantEdificios;
	private int porcetajeAsfalto;
	
	public TrazadoFrontal(String nombre, String superficieHectarea, int cantEdificios, int porcentajeAsfalto) {
		super(nombre, superficieHectarea);
		this.porcetajeAsfalto = porcentajeAsfalto;
		this.cantEdificios = cantEdificios;
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
