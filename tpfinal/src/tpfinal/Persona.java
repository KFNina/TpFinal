package tpfinal;


import java.time.*;

import Enumeradores.SituacionLaboral;

public class Persona {
	
	private SituacionLaboral situacion;
	private String dni;
	private LocalDate  fechaNacimiento;
	private String nombreCompl;
	
	public Persona(SituacionLaboral situacion, String dni, LocalDate fechaNacimiento, String nombreCompl) {
		this.situacion = situacion;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.nombreCompl = nombreCompl;
	}


	public SituacionLaboral getSituacion() {
		return situacion;
	}


	public void setSituacion(SituacionLaboral situacion) {
		this.situacion = situacion;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getNombreCompl() {
		return nombreCompl;
	}


	public void setNombreCompl(String nombreCompl) {
		this.nombreCompl = nombreCompl;
	}
	
	
}
