package control;

import java.util.ArrayList;
import clases.Cliente;
import clases.Mascota;
import clases.Personal;
import clases.Tienda;
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

	public ArrayList<Tienda> getArticulosTienda(String animal) throws Exception{
		DBManager dbManager = new DBManager();
		
		ArrayList<Tienda> articulos = dbManager.getArticulosTienda(animal);
		
		return articulos;
	}
	
	
}
