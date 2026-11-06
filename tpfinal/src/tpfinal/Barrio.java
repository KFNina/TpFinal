package tpfinal;

public abstract class Barrio {
	private String nombre; 
	private String superficieHectarea;
    
	
	public Barrio(String nombre,String superficieHectarea) {
		this.nombre = nombre;
		this.superficieHectarea = superficieHectarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSuperficieHectarea() {
		return superficieHectarea;
	}

	public void setSuperficieHectarea(String superficieHectarea) {
		this.superficieHectarea = superficieHectarea;
	}
}
