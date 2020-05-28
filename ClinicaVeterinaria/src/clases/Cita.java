package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cita {

	private int codigo;
	private int id_pet;
	private String id_vet;
	private String nombreMascota;
	private String fechaVisita;
	private String hora;
	private String descripcion;
	
	// setter & getters-------------------------------
	public int getId_pet() {
		return id_pet;
	}
	public void setId_pet(int id_pet) {
		this.id_pet = id_pet;
	}
	public String getId_vet() {
		return id_vet;
	}
	public void setId_vet(String id_vet) {
		this.id_vet = id_vet;
	}
	public String getFechaVisita() {
		return fechaVisita;
	}
	public void setFechaVisita(String fechaVisita) {
		this.fechaVisita = fechaVisita;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombreMascota() {
		return nombreMascota;
	}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String formatearFecha() {
		
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		String fechaCita = formato.format(fechaVisita);
		
		return fechaCita;
	}
	
}
