package herencia;

import java.util.ArrayList;

import tpfinal.Persona;

public abstract class Barrio {
	private String nombre; 
	private int superficieHectarea;
	private ArrayList<Persona> cantPersonas;
    
	
	public Barrio(String nombre,int superficieHectarea) {
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

	public int getSuperficieHectarea() {
		return superficieHectarea;
	}

	public void setSuperficieHectarea(int superficieHectarea) {
		this.superficieHectarea = superficieHectarea;
	}

	public ArrayList<Persona> getCantPersonas() {
		return cantPersonas;
	}

	public void setCantPersonas(ArrayList<Persona> cantPersonas) {
		this.cantPersonas = cantPersonas;
	}
}
