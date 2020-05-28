package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Cita;
import clases.Cliente;
import clases.Mascota;
import clases.Personal;
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
		String select = "select * from clientes";
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
	public void guardarDatosMascota(Mascota nuevaM) {
		
		try {
			this.openConnection();
		
			
			
			int codigo = 0;
			
			String select = "select max(id) from mascotas";
			
			try {
				ResultSet rs = stmt.executeQuery(select);
				while(rs.next()) {
					codigo = rs.getInt("max(id)");
				}
				codigo = codigo+1;
				
				
				
				String insert = "insert into mascotas (id, propietario,nombre, especie, raza, sexo, fechaNacimiento, castrado) values ("+codigo+",'"+nuevaM.getPropietario()+"','"+nuevaM.getNombre()+"','"+nuevaM.getEspecie()+"','"+nuevaM.getRaza()+"','"+nuevaM.getSexo()+"','"+nuevaM.getFechaNacimiento()+"',"+nuevaM.isBlnCastrado()+");";
				
				stmt.executeUpdate(insert);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		
			this.closeConnection(); //cerramos conexión con la base de datos
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// método para obtener las mascotas del cliente registrado
	public ArrayList<Mascota> getMascotasCliente(String dniCliente) throws Exception{
		ArrayList <Mascota> mascotas = new ArrayList <Mascota>();
		Mascota aux;
		this.openConnection();
		
		String select = "select * from mascotas where propietario = '" +dniCliente+"'"; //se escribe la Select
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			aux = new Mascota();
			aux.setId(rs.getInt("id"));
			aux.setPropietario(rs.getString("propietario"));
			aux.setNombre(rs.getNString("nombre"));
			aux.setEspecie(rs.getString("especie"));
			aux.setRaza(rs.getString("raza"));
			aux.setSexo(rs.getString("sexo"));
			
			aux.setFechaNacimiento(rs.getDate("fechaNacimiento").toString());
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
		
		String select = "select * from mascotas"; //se escribe la Select
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			aux = new Mascota();
			aux.setId(rs.getInt("id"));
			aux.setPropietario(rs.getString("propietario"));
			aux.setNombre(rs.getString("nombre"));
			aux.setEspecie(rs.getString("especie"));
			aux.setRaza(rs.getString("raza"));
			aux.setSexo(rs.getString("sexo"));
			aux.setFechaNacimiento(rs.getDate("fechaNacimiento").toString());
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


	public Mascota getMascota(String dniPropietario, String nombre) throws Exception{
		Mascota mascota = new Mascota ();
		this.openConnection();
		
		String select = "select id, propietario, nombre, especie, raza, sexo, fechaNacimiento, castrado from mascotas where propietario='"+dniPropietario+"' and nombre='"+nombre+"';";
		
		ResultSet rs =stmt.executeQuery(select);
		
		while(rs.next()) {
			mascota.setId(rs.getInt("id"));
			mascota.setPropietario(rs.getString("propietario"));
			mascota.setNombre(rs.getString("nombre"));
			mascota.setEspecie(rs.getString("especie"));
			mascota.setRaza(rs.getString("raza"));
			mascota.setSexo(rs.getString("sexo"));
			mascota.setFechaNacimiento(rs.getDate("fechaNacimiento").toString());
			mascota.setBlnCastrado(rs.getBoolean("castrado"));
		}
		
		rs.close();
		this.closeConnection();
		
		return mascota;
	}

	public void editarDatosMascota(Mascota m) throws Exception{
		
		this.openConnection();
		
		String update = "update mascotas set raza ='"+m.getRaza()+"', sexo = '"+m.getSexo()+"', fechaNacimiento = '"+m.getFechaNacimiento()+"', castrado = "+m.isBlnCastrado()+" where id ="+m.getId()+";";
		
		stmt.executeUpdate(update);
		
		this.closeConnection();
		
	}

	public void borrarMascota(String id, String nombre) throws Exception {
		
		this.openConnection();
		
		String delete = "delete from mascotas where id= '"+id+"' and nombre = '"+nombre+"';";
		
		stmt.executeUpdate(delete);
		
		this.closeConnection();
	}

	public void borrarCliente(String dni) throws Exception{
		
		this.openConnection();
		
		// borramos registro en tabla usuarios
		String delete = "delete from usuarios where usuario= '"+dni+"';";
		
		stmt.executeUpdate(delete);
		
		// borramos las mascotas
		String delete2 = "delete from mascotas where propietario= '"+dni+"';";
		
		stmt.executeUpdate(delete2);
		
		// borramos al cliente de la tabla clientes
		String delete3 = "delete from clientes where dni= '"+dni+"' ;";
		
		stmt.executeUpdate(delete3);
		
		this.closeConnection();
		
	}

	public Personal getVeterinarioAsignado(String especie) throws Exception {
		
		Personal veterinario = new Personal();
		
		this.openConnection();
		
		String select = "select * from personal where especialidad like '%"+especie+"%';";
		
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			veterinario.setId(rs.getString("id"));
			veterinario.setNombre(rs.getNString("nombre"));
			veterinario.setApellido1(rs.getString("apellido1"));
			veterinario.setApellido2(rs.getString("apellido2"));
			veterinario.setEspecialidad(rs.getString("especialidad"));
		}
		
		this.closeConnection();
		
		return veterinario;
	}

	public String getEspecie(String nombre, String dni) throws Exception{
		String especie ="";
		this.openConnection();
		String select = "select especie from mascotas where propietario ='"+dni+"' and nombre = '"+nombre+"';";
		
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			especie=rs.getString("especie");
		}
		
		this.closeConnection();
		return especie;
	}

	public void insertarCita(Cita cita) throws Exception {
		this.openConnection();
		
		int codigo = 0;
		
		String select = "select max(codigo) from citas";
		ResultSet rs = stmt.executeQuery(select);
		while(rs.next()) {
			codigo = rs.getInt("max(codigo)");
		}
		codigo = codigo+1;
		
		
		String insert = "insert into citas (codigo, id_mascota, id_vet, nombre_mascota, fecha_visita, hora_visita, descripcion) values ('"+codigo+"','"+cita.getId_pet()+"','"+cita.getId_vet()+"','"+cita.getNombreMascota()+"','"+cita.getFechaVisita()+"','"+cita.getHora()+"','"+cita.getDescripcion()+"');";
		
		stmt.executeUpdate(insert);
		
		this.closeConnection();
	}

	public String obtenerIdMascota(String nombre, String propietario) throws Exception{
		this.openConnection();
		
		String id ="";
		String select = "select especie from mascotas where propietario ='"+propietario+"' and nombre = '"+nombre+"';";
		
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			id=rs.getString("id");
		}
		this.closeConnection();
		return id;
	}

	public void updateAnotacion(String codigo, String descripcion) throws Exception{
		
		this.openConnection();
		
		String update = "update citas set descripcion = '"+descripcion+"' where codigo = '"+codigo+"';";
		
		stmt.executeUpdate(update);
		
		
		this.closeConnection();
		
	}

	public ArrayList<Cita> getCitas() throws Exception{
		ArrayList <Cita> citas = new ArrayList <Cita>();
		Cita aux;
		this.openConnection();
		
		String select = "select * from citas"; //se escribe la Select
		ResultSet rs = stmt.executeQuery(select);
		
		while(rs.next()) {
			aux = new Cita();
			aux.setCodigo(rs.getInt("codigo"));
			aux.setId_pet(rs.getInt("id_mascota"));
			aux.setId_vet(rs.getNString("id_vet"));
			aux.setNombreMascota(rs.getString("nombre_mascota"));
			aux.setFechaVisita(rs.getDate("fecha_visita").toString());
			aux.setHora(rs.getString("hora_visita"));
			aux.setDescripcion(rs.getString("descripcion"));
			citas.add(aux);
		}
		
		rs.close();
		this.closeConnection();
		
		return citas;
	}

}
