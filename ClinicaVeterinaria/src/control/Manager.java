package control;

import java.util.ArrayList;

import clases.Cita;
import clases.Cliente;
import clases.Mascota;
import clases.Personal;
import clases.Usuario;

public class Manager {

	public Usuario getUsuario(String wUsuario, String clave) throws Exception {
		
		DBManager dbManager = new DBManager();
		Usuario usuario = dbManager.getUsuario(wUsuario, clave);
		
		return usuario;	
	}
	
	public Cliente getCliente(String wDni) throws Exception{
		DBManager dbManager = new DBManager();
		
		Cliente cliente = dbManager.getDatosPersonalesCliente(wDni);
		return cliente;
	}
	
	public ArrayList<Cliente> getClientes() throws Exception{
		DBManager dbManager = new DBManager();
		
		ArrayList <Cliente> clientes = dbManager.getClientes();
		
		return clientes;
	}
	
	public Personal getPersonal(String dniUsuario) throws Exception {
		DBManager dbManager = new DBManager();
		
		Personal personal = dbManager.getPersonal(dniUsuario);
		
		return personal;
	}

	public void guardarDatos(Cliente nuevoC) throws Exception {
		DBManager dbManager = new DBManager();
		
		dbManager.guardarDatos(nuevoC);
	}

	public void crearUsuario(String dni, String clave, int tipo) throws Exception {
		DBManager dbManager = new DBManager();
		
		dbManager.crearUsuario(dni, clave, tipo);
		
	}

	public void guardarDatosMascota(Mascota nuevaM) throws Exception {
		DBManager dbManager = new DBManager();
		
		dbManager.guardarDatosMascota(nuevaM);
		
	}

	public ArrayList<Mascota> getMascotasCliente(String dniCliente) throws Exception {
		DBManager dbManager = new DBManager();
		
		ArrayList <Mascota> mascotas = dbManager.getMascotasCliente(dniCliente);
		
		return mascotas;
	}

	
	public ArrayList<Mascota> getRegistroMascotas() throws Exception{
		DBManager dbManager = new DBManager();
		
		ArrayList <Mascota> mascotas = dbManager.getRegistroMascotas();
		
		return mascotas;
	}

	public void cambiarDatosUsuario(Cliente cambiado) throws Exception{
		DBManager dbManager = new DBManager();
		
		dbManager.cambiarDatosUsuario(cambiado);
		
	}

	public Mascota getMascota(String dniPropietario, String nombre) throws Exception {
		DBManager dbManager = new DBManager();
		
		Mascota mascota = dbManager.getMascota(dniPropietario, nombre);
		
		return mascota;
	}

	public void editarDatosMascota(Mascota m) throws Exception{
		DBManager dbManager = new DBManager();
		
		dbManager.editarDatosMascota(m);
		
	}

	public void borrarMascota(String id, String nombre) throws Exception{
		
		DBManager dbManager = new DBManager();
		
		dbManager.borrarMascota(id, nombre);
		
	}

	public void borrarCliente(String dni) throws Exception{
		
		DBManager dbManager = new DBManager();
		
		dbManager.borrarCliente(dni);
		
	}

	public Personal getVeterinarioAsignado(String especie) throws Exception {
		
		DBManager dbManager = new DBManager();
		
		Personal veterinario = dbManager.getVeterinarioAsignado(especie);
		
		return veterinario;
	}

	public String getEspecie(String nombre, String dni) throws Exception {
		DBManager dbManager = new DBManager();
		String especie = dbManager.getEspecie(nombre, dni);
		return especie;
	}

	public void insertarCita(Cita cita) throws Exception {
		
		DBManager dbManager = new DBManager();
		
		dbManager.insertarCita(cita);
	}

	public void updateAnotacion(String codigo, String descripcion) throws Exception {
		DBManager dbManager = new DBManager();
		
		dbManager.updateAnotacion(codigo, descripcion);
		
	}

	public ArrayList<Cita> getCitas() throws Exception{
		
		DBManager dbManager = new DBManager();
		
		ArrayList <Cita> citas = dbManager.getCitas();
		
		return citas;
	}

	
	
	
}
