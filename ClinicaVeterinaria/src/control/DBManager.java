package control;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import clases.Cliente;
import clases.Mascota;
import clases.Personal;
import clases.Tienda;
import clases.Usuario;

public class DBManager {

	private Connection con;
	private Statement stmt;

	private void openConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost/db_veterinaria"+"?serverTimezone=Europe/Madrid";  //
		con = DriverManager.getConnection(url, "db_veterinaria", "db_veterinaria");
		stmt = con.createStatement();
	}

	private void closeConnection() throws SQLException {
		stmt.close();
		con.close();
	}
	
	// método para obtener los datos de acceso de un usuario
	public Usuario getUsuario(String wUsuario, String clave) throws Exception {
		
		//cargamos usuario de la tabla Usuarios
		Usuario usuario = new Usuario();
		this.openConnection();
		String select = "select * from usuarios where usuario = '"+wUsuario+"' and password = '"+clave+"'";  
		
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			usuario.setUsuario(wUsuario);
			usuario.setPassword(clave);
			usuario.setTipo(rs.getInt("tipo"));
		}
		rs.close();
		this.closeConnection();
		
		//devolvemos el usuario 
		return usuario;
	}

	// método para obtener a todos los clientes
	public ArrayList<Cliente> getClientes() throws Exception {
		
		ArrayList <Cliente> clientes = new ArrayList<Cliente>();
		Cliente aux;
		
		this.openConnection();
		String select = "select dni, nombre, apellido1, apellido2, direccion, localidad, telefono1, telefono2 from clientes order by apellido1";
		ResultSet rs = stmt.executeQuery(select);
		
		// Bucle para cada resultado en la consulta
		while (rs.next())
		{
		   aux = new Cliente();
		   aux.setDni(rs.getString("dni"));
		   aux.setNombre(rs.getNString("nombre"));
		   aux.setApellido1(rs.getString("apellido1"));
		   aux.setApellido2(rs.getString("apellido2"));
		   aux.setDireccion(rs.getString("direccion"));
		   aux.setLocalidad(rs.getString("localidad"));
		   aux.setTelefono1(rs.getString("telefono1"));
		   aux.setTelefono2(rs.getString("telefono2"));
		   clientes.add(aux);
		}
		
		rs.close();
		this.closeConnection();
		
		return clientes;
	
	}

	// método para obtener los datos de un cliente
	public Cliente getDatosPersonalesCliente(String wDni) throws Exception {
		Cliente cliente = new Cliente();
		this.openConnection();
		
		String select = "select * from clientes where dni = '"+wDni+"'";
		ResultSet rs = stmt.executeQuery(select);
		
		while (rs.next()) {
			cliente.setDni(wDni);
			cliente.setNombre(rs.getString(2));
			cliente.setApellido1(rs.getString(3));
			cliente.setApellido2(rs.getString(4));
			cliente.setDireccion(rs.getString(5));
			cliente.setLocalidad(rs.getString(6));
			cliente.setTelefono1(rs.getString(7));
			cliente.setTelefono2(rs.getString(8));
		}
		
		rs.close(); //cerramos cursor
		this.closeConnection(); //cerramos conexión con la base de datos
		return cliente;
	}

	// método para obtener los datos de un empleado
	public Personal getPersonal(String dniUsuario) throws Exception{
		Personal personal = new Personal();
		
		this.openConnection();
		
		String select = "select * from personal where id = '"+dniUsuario+"'";
		
		ResultSet rs = stmt.executeQuery(select);
		// cargamos datos del personal
		while (rs.next()) {
			personal.setId(dniUsuario);
			personal.setNombre(rs.getString(2));
			personal.setApellido1(rs.getString(3));
			personal.setApellido2(rs.getString(4));
			personal.setCargo(rs.getString(5));
			personal.setEspecialidad(rs.getString(6));
		}
		
		rs.close(); //cerramos cursor
		this.closeConnection(); //cerramos conexión con la base de datos
		return personal;
	}

	// método para guardar los datos de un nuevo cliente
	public void guardarDatos(Cliente nuevoC) throws Exception {
		
		this.openConnection();
		
		String insert = "insert into clientes (dni, nombre, apellido1, apellido2, direccion, localidad, telefono1, telefono2) values ('"+nuevoC.getDni()+"','"+nuevoC.getNombre()+"','"+nuevoC.getApellido1()+"','"+nuevoC.getApellido2()+"','"+nuevoC.getDireccion()+"','"+nuevoC.getLocalidad()+"','"+nuevoC.getTelefono1()+"','"+nuevoC.getTelefono2()+"');";
		//ejecutamos la insert
		stmt.executeUpdate(insert);
		
		this.closeConnection(); //cerramos conexión con la base de datos
	}

	// método para guardar los datos de un nuevo usuario
	public void crearUsuario(String dni, String clave, int tipo) throws Exception {
		this.openConnection();
		
		String insert = "insert into usuarios (usuario, password, tipo) values ('"+dni+"','"+clave+"',"+tipo+");";
		
		stmt.executeUpdate(insert);
		
		this.closeConnection(); //cerramos conexión con la base de datos
	}

	// método para guardar los datos de una nueva mascota
	public void guardarDatosMascota(Mascota nuevaM) throws Exception{
		
		this.openConnection();
		
		String insert = "insert into mascotas (id, nombre, especie, raza, sexo, fechaNacimiento, castrado) values ('"+nuevaM.getId()+"','"+nuevaM.getNombre()+"','"+nuevaM.getEspecie()+"','"+nuevaM.getRaza()+"','"+nuevaM.getSexo()+"','"+nuevaM.getFechaNacimiento()+"',"+nuevaM.isBlnCastrado()+");";
		
	//	String insert = "insert into mascotas (id, nombre, tipo, raza, sexo) values ('"+nuevaM.getId()+"','"+nuevaM.getNombre()+"','"+nuevaM.getTipo()+"','"+nuevaM.getRaza()+"','"+nuevaM.getSexo()+"');"; //'"+nuevaM.getFechaNacimiento()+"'
		
		stmt.executeUpdate(insert);
		
		this.closeConnection(); //cerramos conexión con la base de datos
	}

	// método para obtener las mascotas del cliente registrado
	public ArrayList<Mascota> getMascotasCliente(String dniCliente) throws Exception{
		ArrayList <Mascota> mascotas = new ArrayList <Mascota>();
		Mascota aux;
		this.openConnection();
		
		String select = "select * from mascotas where id = '" +dniCliente+"'"; //se escribe la Select
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			aux = new Mascota();
			aux.setId(rs.getString("id"));
			aux.setNombre(rs.getNString("nombre"));
			aux.setEspecie(rs.getString("especie"));
			aux.setRaza(rs.getString("raza"));
			aux.setSexo(rs.getString("sexo"));
			aux.setFechaNacimiento(rs.getDate("fechaNacimiento"));
			aux.setBlnCastrado(rs.getBoolean("castrado"));
			mascotas.add(aux);
		}
		
		rs.close();
		this.closeConnection();
		
		return mascotas;
	}

	
	// método para obtener todas las mascotas registradas
	public ArrayList<Mascota> getRegistroMascotas() throws Exception{
		ArrayList <Mascota> mascotas = new ArrayList <Mascota>();
		Mascota aux;
		this.openConnection();
		
		String select = "select id, nombre, especie, raza, sexo, fechaNacimiento, castrado from mascotas order by id desc"; //se escribe la Select
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			aux = new Mascota();
			aux.setId(rs.getString("id"));
			aux.setNombre(rs.getNString("nombre"));
			aux.setEspecie(rs.getString("especie"));
			aux.setRaza(rs.getString("raza"));
			aux.setSexo(rs.getString("sexo"));
			aux.setFechaNacimiento(rs.getDate("fechaNacimiento"));
			aux.setBlnCastrado(rs.getBoolean("castrado"));
			mascotas.add(aux);
		}
		
		rs.close();
		this.closeConnection();
		
		return mascotas;
	}

	// método para actualizar datos del usuario en área cliente
	public void cambiarDatosUsuario(Cliente cambiado) throws Exception{
		this.openConnection();
		
		String update = "update clientes set direccion= '"+cambiado.getDireccion()+"', localidad= '"+cambiado.getLocalidad()+"', telefono1 = '"+cambiado.getTelefono1()+"', telefono2 = '"+cambiado.getTelefono2()+"' where dni = '"+cambiado.getDni()+"';";
		stmt.executeUpdate(update);
		
		this.closeConnection();
	}

	// método para cargar los artículos de la tienda
	public ArrayList<Tienda> getArticulosTienda(String animal) throws Exception{
		ArrayList <Tienda> articulos = new ArrayList <Tienda>();
		Tienda aux;
	//	Image finalImg =null;
	//	InputStream is =null;
		this.openConnection();
		
		String select = "select codigo, nombre, descripcion, animal, tipo, precio_PVP, almacenados from tienda where animal='"+animal+"'"; //se escribe la Select
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			aux = new Tienda();
			aux.setCodigo(rs.getString("codigo"));
			aux.setNombre(rs.getNString("nombre"));
			aux.setDescripcion(rs.getString("descripcion"));
			aux.setAnimal(rs.getString("animal"));
			aux.setTipo(rs.getString("tipo"));
			/*
			is = rs.getBinaryStream("foto");
		    
		    // hay que convertir el array de bytes en un buffer para poder pasarlo a image 
		    BufferedImage biFoto=ImageIO.read(is);
		    finalImg = biFoto;
		    aux.setFoto(finalImg);*/
			aux.setPrecio(rs.getFloat("precio_PVP"));
			aux.setAlmacenados(rs.getInt("almacenados"));
			articulos.add(aux);
		}
		
		rs.close();
		this.closeConnection();
		
		return articulos;
	}

}
