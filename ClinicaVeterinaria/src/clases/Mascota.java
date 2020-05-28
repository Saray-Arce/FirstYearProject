package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Mascota {
	private int id;
	private String propietario;
	private String nombre;
	private String especie;
	private String raza;
	private String sexo;
	private String fechaNacimiento;
	private boolean blnCastrado;
	
	
	// methods setter & getter
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public boolean isBlnCastrado() {
		return blnCastrado;
	}
	public void setBlnCastrado(boolean blnCastrado) {
		this.blnCastrado = blnCastrado;
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
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fecha) {
		this.fechaNacimiento = fecha;
	}
		
	
}
