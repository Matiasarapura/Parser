package com.ibm.ar;

import java.sql.Date;

public class Pais {
	double id;
	String nombre;
	Date fecha;
	public double getId() {
		return id;
	}
	public void setId(double d) {
		this.id = d;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
