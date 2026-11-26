package tpfinal;

import java.util.ArrayList;

public abstract class Barrio {
	private String nombre; 
	private float superficieHectarea;
	private ArrayList<Persona> cantPersonas;
    
	
	public Barrio(String nombre,float superficieHectarea) {
		this.nombre = nombre;
		this.superficieHectarea = superficieHectarea;
	}
	
	public abstract boolean tieneCriticidad();
	
	public abstract float calcularDensidad();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getSuperficieHectarea() {
		return superficieHectarea;
	}

	public void setSuperficieHectarea(float superficieHectarea) {
		this.superficieHectarea = superficieHectarea;
	}

	public ArrayList<Persona> getCantPersonas() {
		return cantPersonas;
	}

	public void setCantPersonas(ArrayList<Persona> cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
}
