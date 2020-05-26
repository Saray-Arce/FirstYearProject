package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mascota {
	private String id;
	private String nombre;
	private String especie;
	private String raza;
	private String sexo;
	private Date fechaNacimiento;
	private boolean blnCastrado;
	
	
	// methods setter & getter
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String tipo) {
		this.especie = tipo;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public boolean isBlnCastrado() {
		return blnCastrado;
	}
	public void setBlnCastrado(boolean blnCastrado) {
		this.blnCastrado = blnCastrado;
	}
	public String formatearFecha() {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		String fechaNac = formato.format(fechaNacimiento);
		
		return fechaNac;
	}
	
	public String esCastrado() {
		
		String estaCastrado;
		
		if(isBlnCastrado()) {
			estaCastrado= "SI";
		}
		else {
			estaCastrado="NO";
		}
		return estaCastrado;
		
	}
		
	
}
