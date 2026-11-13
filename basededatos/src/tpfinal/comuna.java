package tpfinal;

import java.util.ArrayList;

import herencia.Barrio;

public class comuna {
	
	private String numerocomuna;
    private String sedecomuna;
    private ArrayList<Barrio> cantBarrios; 
    
    public comuna(String numerocomuna, String sedecomuna, ArrayList<Barrio> cantBarrio) {
		this.numerocomuna = numerocomuna;
		this.sedecomuna = sedecomuna;
		this.cantBarrios = cantBarrio;
	}
    
    public void esDeAtencionPrioritaria() {
    	
    	
    }
}
