package tpfinal;

import java.util.ArrayList;

import herencia.Barrio;

public class Comuna {
	
	private String numerocomuna;
    private String nombreComuna;
    private int cantBarrios; 
    private ArrayList<Barrio> barrios = new ArrayList<>();
    
    public Comuna(String numerocomuna, String nombreComuna, int cantBarrio) {
    	this.numerocomuna = numerocomuna;
		this.nombreComuna = nombreComuna;
		this.cantBarrios = cantBarrio;
	}
    
    public Comuna(String numeroComuna, String nombrecomuna) {
    	this.numerocomuna = numeroComuna;
    	this.nombreComuna =nombrecomuna;
	}

	public boolean esDeAtencionPrioritaria() {
    	int barriosPrioritarios=0;
    	for(Barrio p : barrios){
    		if(p.tieneCriticidad()) {
    			barriosPrioritarios++;
    		}
    	}
    	return (cantBarrios*0.5) <= barriosPrioritarios;
    }

	public String getNumerocomuna() {
		return numerocomuna;
	}

	public void setNumerocomuna(String numerocomuna) {
		this.numerocomuna = numerocomuna;
	}

	public int getCantBarrios() {
		return cantBarrios;
	}

	public void setCantBarrios(int cantBarrios) {
		this.cantBarrios = cantBarrios;
	}

	public String getNombreComuna() {
		return nombreComuna;
	}

	public void setNombreComuna(String nombreComuna) {
		this.nombreComuna = nombreComuna;
	}
}
