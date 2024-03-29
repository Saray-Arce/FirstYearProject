package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.mysql.cj.protocol.a.result.TextBufferRow;
import com.toedter.calendar.JCalendar;

import clases.Cliente;
import clases.Mascota;
import clases.Personal;
import clases.Tienda;
import control.Manager;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageProducer;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class VentanaClinica extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Manager manager = new Manager();
	private JTabbedPane panelPestanas;
	// atributos del panel de �rea personal cliente---------------
	private JComboBox <String> listaMascotas;
	private JCalendar calendar;
	private JComboBox cmbHora;
	private JComboBox cmbMinutos;
	private JTextPane textDatosCita;
	private JButton btnValidarCita;
	private JButton btnCancelarCita;
	private JButton btnSalirCita;
	private JLabel lblUser;
	private JTextField textDniUser;
	private JTextField textNombreUser;
	private JTextField textApellUser1;
	private JTextField textDireccUser;
	private JTextField textTelefUser;
	private JTextField textApellUser2;
	private JTextField textLocalidad;
	private JTextField textTelefUser2;
	private JButton btnEditar;
	private JButton btnMascotas;
	private JButton btnCitas;
	private JButton btnPedidos;
	private JButton btnCerrarSesionCliente;
	private JButton btnAceptarCambios;
	private JButton btnCancelarCambios;
	
	// atributos de las mascotas del cliente-----------------------
	private JLabel lblFotoMascota1;
	private JLabel lblNombreMascota;
	private JTextField textNombreMascota;
	private JLabel lblEspecie;
	private JTextField textEspecie;
	private JLabel lblRaza;
	private JTextField textRaza;
	private JLabel lblSexo;
	private JTextField textSexo;
	private JLabel lblFechaNaci;
	private JTextField textFechaNaci;
	private JCheckBox chckbxEsterilizado;
	private JScrollPane scrollPaneMascotas;
	private JTable tablaMascotas;
	private JLabel lblDatosMascota;
	private JSeparator separatorMascotas;
	
	// atributos tienda-------------------------------------------
	private JPanel tienda;
	private JButton btnCarrito;
	private JButton btnGatos;
	private JButton btnPerros;
	private JButton btnOtros;
	private JTable tablaArticulo;
	
	
	// atributos trabajadores-------------------------------------
	private JLabel lblTrabajador;
	private JTextField textCargo;
	private JTextField textEspecialidad;
	private JButton btnAltaMascotas;
	private JButton btnAltaClientes;
	private JButton btnAsignarCita;
	private JButton btnCerrarSesionPersonal;
	private JSeparator separator;
	
	private JLabel lblDniCliente;
	private JTextField textaltaDni;
	private JLabel lblNombreCliente;
	private JTextField textAltaNombre;
	private JLabel lblApellCliente1;
	private JTextField textAltaApell1;
	private JLabel lblApellCliente2;
	private JTextField textAltaApell2;
	private JLabel lblTelefCliente1;
	private JTextField textAltaTelef1;
	private JLabel lblTelefCliente2;
	private JTextField textAltaTelef2;
	private JLabel lblDirecCliente;
	private JTextField textAltaDirec;
	private JLabel lblLocalCliente;
	private JTextField textAltaLocal;
	private JLabel lblDatosRegistro;
	private JButton btnRegistrarCliente;
	private JButton btnCrearUsuario;
	private JButton btnCancelarCliente;
	private JButton btnRegistraMascota;
	
	private JLabel lblDatosRegistroMascota;
	private JLabel lblNombreAltaMascota;
	private JTextField textAltaNombreMascota;
	private JLabel lblEspecieMascota;
	private JTextField textEspecieMascota;
	private JLabel lblRazaMascota;
	private JTextField textRazaMascota;
	private JLabel lblFechaNacimiento;
	private JTextField textFechaNaciMascota;
	private JLabel lblSexoMascota;
	private JTextField textSexoMascota;
	private JCheckBox chckbxEsterilizadoAlta;
	private JButton btnRegistrarAnimal;
	private JButton btnCancelarMascota;
	
	private JTable tablaClientes;
	private JTable tablaRegistroMascotas;
	private JTextField textDniBuscar;
	private JButton btnBuscar;
	private JLabel lblResultado;
	private JButton btnEditarRegistro;
	private JButton btnEliminarCliente;
	private JTextPane textResultadoBusquedaMascota;
	private JButton btnEditarRegistroMascota;
	private JButton btnEliminarMascota;
	private JLabel lblNombreBuscado;
	private JTextField textNombreC;
	private JLabel lblApellidoBuscado;
	private JTextField textPrimerApellidoC;
	private JLabel lblApellidoBuscado2;
	private JTextField textSegundoApellido;
	private JLabel lblDireccBuscada;
	private JTextField textDireccBuscada;
	private JLabel lblLocalidadB;
	private JTextField textLocalidadBuscada;
	private JLabel lblTelefonosBuscados;
	private JTextField textTelfBusc1;
	private JTextField textTelfBusc2;
	
	/**
	 * Create the dialog.
	 * @param login 
	 * @throws Exception 
	 */
	public VentanaClinica(Login login, String dniUsuario, int tipoUsuario) throws Exception {
		
		super(login);
		setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\vet_verde.png"));
		this.setModal(true);
		
		getContentPane().setBackground(new Color(176, 224, 230));
		setTitle("CLINICA VETERINARIA");
		setBounds(100, 100, 1470, 813);
		getContentPane().setLayout(null);
		
		panelPestanas = new JTabbedPane(JTabbedPane.TOP);
		panelPestanas.setBounds(10, 11, 1434, 752);
		getContentPane().add(panelPestanas);
		
		 
		switch (tipoUsuario) {
			case 2:
				crearPanelPersonal(dniUsuario);
				crearPanelRegistroClientes();
				crearPanelRegistroMascotas();
				break;
			case 3:
				crearPanelAreaCliente(dniUsuario);
				crearPanelCita();
				crearPanelTienda();
			break;
		}
		//crearPanelAreaCliente(dniUsuario);
		
		//crearPanelCita();
		 
		//crearPanelTienda();
		 
		//crearPanelPersonal(dniUsuario);
		
		//crearPanelRegistroClientes();
		//crearPanelRegistroMascotas();
		 
	}

	//------------M�TODOS PARA CREAR LOS PANELES--------------------------------------------------------------------------------------------------//
	
	private void crearPanelPersonal(String dniUsuario) {
		/// Panel ficha del personal-------------------------------------------------------------------------------------------------------------------
		 
		 JPanel personal = new JPanel();
		 personal.setBackground(Color.WHITE);
		 panelPestanas.addTab("Personal", null, personal, null);
		 personal.setLayout(null);
		 
		 lblTrabajador = new JLabel("");
		 lblTrabajador.setBounds(68, 11, 121, 107);
		 ImageIcon imagenTrabajador = new ImageIcon("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\vet_verde.png");
		 Icon iconoTrabajador = new ImageIcon(imagenTrabajador.getImage().getScaledInstance(lblTrabajador.getWidth(), lblTrabajador.getHeight(), Image.SCALE_DEFAULT));
		 lblTrabajador.setIcon(iconoTrabajador);
		 personal.add(lblTrabajador);
		 
		 JLabel lblDatos = new JLabel("DATOS PERSONALES");
		 lblDatos.setFont(new Font("Tahoma", Font.BOLD, 12));
		 lblDatos.setHorizontalAlignment(SwingConstants.CENTER);
		 lblDatos.setBounds(28, 129, 203, 22);
		 personal.add(lblDatos);
		 
		 JLabel lblNombreTrab = new JLabel("Nombre : ");
		 lblNombreTrab.setBounds(23, 158, 221, 14);
		 personal.add(lblNombreTrab);
		   
		 textNombreUser = new JTextField();
		 textNombreUser.setBackground(Color.WHITE);
		 textNombreUser.setEditable(false);
		 textNombreUser.setBounds(23, 173, 221, 20);
		 personal.add(textNombreUser);
		 textNombreUser.setColumns(10);
		 
		 JLabel lblPrimerApellidoT = new JLabel("Primer apellido : ");
		 lblPrimerApellidoT.setBounds(23, 204, 221, 14);
		 personal.add(lblPrimerApellidoT);
		   
		 textApellUser1 = new JTextField();
		 textApellUser1.setBackground(Color.WHITE);
		 textApellUser1.setEditable(false);
		 textApellUser1.setBounds(23, 219, 221, 20);
		 personal.add(textApellUser1);
		 textApellUser1.setColumns(10);
		 
		 JLabel lblSegundoApellidoT = new JLabel("Segundo apellido : ");
		 lblSegundoApellidoT.setBounds(23, 250, 221, 14);
		 personal.add(lblSegundoApellidoT);
		   
		 textApellUser2 = new JTextField();
		 textApellUser2.setEditable(false);
		 textApellUser2.setColumns(10);
		 textApellUser2.setBackground(Color.WHITE);
		 textApellUser2.setBounds(23, 264, 221, 20);
		 personal.add(textApellUser2);
		 
		 JLabel lblCargo = new JLabel("Cargo :");
		 lblCargo.setBounds(23, 295, 221, 14);
		 personal.add(lblCargo);
		   
		 textCargo = new JTextField();
		 textCargo.setBackground(Color.WHITE);
		 textCargo.setEditable(false);
		 textCargo.setBounds(23, 310, 221, 20);
		 personal.add(textCargo);
		 textCargo.setColumns(10);
		   
		 JLabel lblEspecialidad = new JLabel("Especialidad : ");
		 lblEspecialidad.setBounds(23, 341, 221, 14);
		 personal.add(lblEspecialidad);
		   
		 textEspecialidad = new JTextField();
		 textEspecialidad.setBackground(Color.WHITE);
		 textEspecialidad.setEditable(false);
		 textEspecialidad.setBounds(23, 356, 221, 20);
		 personal.add(textEspecialidad);
		 textEspecialidad.setColumns(10);
		 
		 btnAltaMascotas = new JButton("ALTA DE MASCOTA");
		 btnAltaMascotas.setBounds(23, 483, 225, 44);
		 personal.add(btnAltaMascotas);
		 btnAltaMascotas.addActionListener(this);
		   
		 btnAltaClientes = new JButton("ALTA DE CLIENTE");
		 btnAltaClientes.setBounds(23, 407, 225, 44);
		 personal.add(btnAltaClientes);
		 btnAltaClientes.addActionListener(this);
		   
		 btnCerrarSesionPersonal = new JButton("CERRAR SESI\u00D3N");
		 btnCerrarSesionPersonal.setBounds(23, 641, 225, 44);
		 personal.add(btnCerrarSesionPersonal);
		 btnCerrarSesionPersonal.addActionListener(this);
		 
		 btnAsignarCita = new JButton("ASIGNAR CITA");
		 btnAsignarCita.setBounds(23, 563, 225, 44);
		 personal.add(btnAsignarCita);
		 btnAsignarCita.addActionListener(this);
		 
		 
		 JSeparator separator_1 = new JSeparator();
		 separator_1.setOrientation(SwingConstants.VERTICAL);
		 separator_1.setForeground(new Color(176, 224, 230));
		 separator_1.setBounds(275, 24, 1, 678);
		 personal.add(separator_1);
		 
		// hacemos llamada a altaCliente(); y altaMascota(); funci�n que se encarga de crear los dise�os
		// le pasamos por par�metro un booleano a false para no mostrar la info si no le da al bot�n de Alta de cliente o Alta Mascota
		// le pasamos por par�metro el panel en el que ha de crear el dise�o 
		 
		 altacliente(personal, false);
		 
		 altaMascota(personal, false);
		
		 try {
			 Personal p = manager.getPersonal(dniUsuario);
			 textNombreUser.setText(p.getNombre());
			 textApellUser1.setText(p.getApellido1());
			 textApellUser2.setText(p.getApellido2());
			 textCargo.setText(p.getCargo());
			 textEspecialidad.setText(p.getEspecialidad());
			 
		 }
		 catch(Exception e1) {
			 e1.getMessage();
		 }
	}

	private void crearPanelTienda() throws Exception {
		// Panel 3  TIENDA------------------------------------------------------------------------------------------------------------------------------------------------------
		 tienda = new JPanel();
		 tienda.setBackground(Color.WHITE);
		 panelPestanas.addTab("Tienda", null, tienda, null);
		 tienda.setLayout(null);
		 
		 btnGatos = new JButton("ALIMENTO PARA GATOS");
		 btnGatos.setBackground(new Color(176, 224, 230));
		 btnGatos.setBounds(57, 0, 417, 23);
		 tienda.add(btnGatos);
		 btnGatos.addActionListener(this);
		 
		 btnPerros = new JButton("ALIMENTO PARA PERROS");
		 btnPerros.setBackground(new Color(216, 191, 216));
		 btnPerros.setBounds(472, 0, 420, 23);
		 tienda.add(btnPerros);
		 btnPerros.addActionListener(this);
		 
		 btnOtros = new JButton("COMPLEMENTOS");
		 btnOtros.setBackground(new Color(143, 188, 143));
		 btnOtros.setBounds(890, 0, 420, 23);
		 tienda.add(btnOtros);
		 btnOtros.addActionListener(this);
		 
		 btnCarrito = new JButton("");
		 btnCarrito.setForeground(Color.WHITE);
		 btnCarrito.setBackground(Color.WHITE);
		 
		 ImageIcon carrito = new ImageIcon("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\carrito.png");
		 
		 btnCarrito.setBounds(1346, 0, 46, 43);
		 Icon iconoCarrito = new ImageIcon(carrito.getImage().getScaledInstance(btnCarrito.getWidth(), btnCarrito.getHeight(), Image.SCALE_DEFAULT));
		 btnCarrito.setIcon(iconoCarrito);
		 btnCarrito.addActionListener(this);
		 tienda.add(btnCarrito);
		 
		
		 // Fin del panel Tienda----------------------------------------------------------------------------------------------------------------------
				 
		
	}

	private void crearPanelAreaCliente(String dniUsuario) throws Exception {
		// Panel Ficha------------------------------------------------------------------------------------------------------------------------------------------------------
		 JPanel ficha = new JPanel();
		 ficha.setBackground(Color.WHITE);
		 panelPestanas.addTab("�rea personal", null, ficha, null);
		 ficha.setLayout(null);
		 
		 ImageIcon imagen = new ImageIcon("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\user.png");
		 this.repaint();
		 ImageIcon lapiz = new ImageIcon("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\editar.png");
		 lblUser = new JLabel("");
		 lblUser.setBounds(52, 11, 166, 107);
		 Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblUser.getWidth(), lblUser.getHeight(), Image.SCALE_DEFAULT));
		 lblUser.setIcon(icono);
		 ficha.add(lblUser);
		   
		 JLabel lblDatosUser = new JLabel("DATOS PERSONALES");
		 lblDatosUser.setFont(new Font("Tahoma", Font.BOLD, 12));
		 lblDatosUser.setHorizontalAlignment(SwingConstants.CENTER);
		 lblDatosUser.setBounds(34, 129, 203, 22);
		 ficha.add(lblDatosUser);
		   
		 JLabel lblNombreUser = new JLabel("Nombre : ");
		 lblNombreUser.setBounds(23, 158, 221, 14);
		 ficha.add(lblNombreUser);
		 
		 textDniUser = new JTextField();
		 textDniUser.setBackground(Color.WHITE);
		 textDniUser.setEditable(false);
		 textDniUser.setBounds(23, 173, 221, 20);
		 textDniUser.setVisible(false);
		 ficha.add(textDniUser);
		 textDniUser.setColumns(10);
		 
		 textNombreUser = new JTextField();
		 textNombreUser.setBackground(Color.WHITE);
		 textNombreUser.setEditable(false);
		 textNombreUser.setBounds(23, 173, 221, 20);
		 ficha.add(textNombreUser);
		 textNombreUser.setColumns(10);
		   
		 JLabel lblPrimerApellido = new JLabel("Primer apellido : ");
		 lblPrimerApellido.setBounds(23, 204, 221, 14);
		 ficha.add(lblPrimerApellido);
		   
		 textApellUser1 = new JTextField();
		 textApellUser1.setBackground(Color.WHITE);
		 textApellUser1.setEditable(false);
		 textApellUser1.setBounds(23, 219, 221, 20);
		 ficha.add(textApellUser1);
		 textApellUser1.setColumns(10);
		 
		 JLabel lblSegundoApellido = new JLabel("Segundo apellido : ");
		 lblSegundoApellido.setBounds(23, 250, 221, 14);
		 ficha.add(lblSegundoApellido);
		   
		 textApellUser2 = new JTextField();
		 textApellUser2.setEditable(false);
		 textApellUser2.setColumns(10);
		 textApellUser2.setBackground(Color.WHITE);
		 textApellUser2.setBounds(23, 264, 221, 20);
		 ficha.add(textApellUser2);
		   
		 JLabel lblDireccUser = new JLabel("Direcci\u00F3n :");
		 lblDireccUser.setBounds(23, 295, 221, 14);
		 ficha.add(lblDireccUser);
		   
		 textDireccUser = new JTextField();
		 textDireccUser.setBackground(Color.WHITE);
		 textDireccUser.setEditable(false);
		 textDireccUser.setBounds(23, 310, 221, 20);
		 ficha.add(textDireccUser);
		 textDireccUser.setColumns(10);
		   
		 JLabel lblTelefUser = new JLabel("Tel\u00E9fono : ");
		 lblTelefUser.setBounds(23, 386, 221, 14);
		 ficha.add(lblTelefUser);
		   
		 textTelefUser = new JTextField();
		 textTelefUser.setBackground(Color.WHITE);
		 textTelefUser.setEditable(false);
		 textTelefUser.setBounds(23, 402, 221, 20);
		 ficha.add(textTelefUser);
		 textTelefUser.setColumns(10);
		   
		 JLabel lblLocalidad = new JLabel("Localidad :");
		 lblLocalidad.setBounds(23, 341, 221, 14);
		 ficha.add(lblLocalidad);
		   
		 textLocalidad = new JTextField();
		 textLocalidad.setBackground(Color.WHITE);
		 textLocalidad.setEditable(false);
		 textLocalidad.setBounds(23, 355, 221, 20);
		 ficha.add(textLocalidad);
		 textLocalidad.setColumns(10);
		   
		 JLabel lblTelfonoSecundario = new JLabel("Tel\u00E9fono secundario: ");
		 lblTelfonoSecundario.setBounds(23, 437, 221, 14);
		 ficha.add(lblTelfonoSecundario);
		   
		 textTelefUser2 = new JTextField();
		 textTelefUser2.setEditable(false);
		 textTelefUser2.setColumns(10);
		 textTelefUser2.setBackground(Color.WHITE);
		 textTelefUser2.setBounds(23, 452, 221, 20);
		 ficha.add(textTelefUser2);
		   
		 btnEditar = new JButton("");
		 btnEditar.setForeground(Color.WHITE);
		 btnEditar.setBackground(Color.WHITE);
		 btnEditar.setBounds(225, 127, 20, 20);
		 Icon iconoLapiz = new ImageIcon(lapiz.getImage().getScaledInstance(btnEditar.getWidth(), btnEditar.getHeight(), Image.SCALE_DEFAULT));
		 btnEditar.setIcon(iconoLapiz);
		 ficha.add(btnEditar);
		 btnEditar.addActionListener(this);
		   
		 btnMascotas = new JButton("MIS MASCOTAS");
		 btnMascotas.setBackground(new Color(176, 224, 230));
		 btnMascotas.setBounds(23, 504, 225, 44);
		 ficha.add(btnMascotas);
		 btnMascotas.addActionListener(this);
		   
		 btnCitas = new JButton("CONSULTAR CITAS");
		 btnCitas.setBackground(new Color(176, 224, 230));
		 btnCitas.setBounds(23, 559, 225, 44);
		 ficha.add(btnCitas);
		 btnCitas.addActionListener(this);
		  
		 btnPedidos = new JButton("MIS PEDIDOS");
		 btnPedidos.setBackground(new Color(176, 224, 230));
		 btnPedidos.setBounds(23, 614, 225, 44);
		 ficha.add(btnPedidos);
		 btnPedidos.addActionListener(this);
		   
		 btnCerrarSesionCliente = new JButton("CERRAR SESI\u00D3N");
		 btnCerrarSesionCliente.setBackground(new Color(176, 224, 230));
		 btnCerrarSesionCliente.setBounds(23, 669, 225, 44);
		 ficha.add(btnCerrarSesionCliente);
		 btnCerrarSesionCliente.addActionListener(this);
		   
		 btnAceptarCambios = new JButton("ACEPTAR");
		 btnAceptarCambios.setBounds(23, 504, 225, 44);
		 btnAceptarCambios.setVisible(false);
		 ficha.add(btnAceptarCambios);
		 btnAceptarCambios.addActionListener(this);
		   
		 btnCancelarCambios = new JButton("CANCELAR");
		 btnCancelarCambios.setBounds(23, 585, 225, 44);
		 btnCancelarCambios.setVisible(false);
		 ficha.add(btnCancelarCambios);
		 btnCancelarCambios.addActionListener(this);
		   
		 JSeparator separator_2 = new JSeparator();
		 separator_2.setForeground(new Color(176, 224, 230));
		 separator_2.setOrientation(SwingConstants.VERTICAL);
		 separator_2.setBounds(289, 11, 1, 702);
		 ficha.add(separator_2);
		 
		 //obtenemos los datos del cliente
		 datosCliente(dniUsuario);
		 
		 //m�todo que carga la interfaz de las mascotas
		 datosMascota(ficha, false, dniUsuario);	
		 
		 lblDatosMascota = new JLabel("DATOS DE LA MASCOTA");
		 lblDatosMascota.setHorizontalAlignment(SwingConstants.CENTER);
		 lblDatosMascota.setFont(new Font("Tahoma", Font.BOLD, 14));
		 lblDatosMascota.setBounds(755, 485, 486, 14);
		 lblDatosMascota.setVisible(false);
		 ficha.add(lblDatosMascota);
		 
		 separatorMascotas = new JSeparator();
		 separatorMascotas.setForeground(new Color(176, 224, 230));
		 separatorMascotas.setBounds(311, 470, 1097, 2);
		 separatorMascotas.setVisible(false);
		 ficha.add(separatorMascotas);
	}
	
	private void crearPanelCita() {
		
		
		// Panel 2 Citas-------------------------------------------------------------------------------------------------------------------------------------------
		 JPanel Cita = new JPanel();
		 Cita.setBackground(SystemColor.control);
		 Cita.setForeground(Color.WHITE);
		 panelPestanas.addTab("Solicitar Cita", null, Cita, null);
		 Cita.setLayout(null);
		 
		 JLabel lblPaso1 = new JLabel("PASO 1.");
		 lblPaso1.setForeground(new Color(128, 0, 0));
		 lblPaso1.setFont(new Font("Tahoma", Font.BOLD, 12));
		 lblPaso1.setBounds(66, 49, 75, 27);
		 Cita.add(lblPaso1);
		 
		 JLabel lblSelecMascota = new JLabel("SELECCIONA MASCOTA :");
		 lblSelecMascota.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblSelecMascota.setBounds(66, 81, 173, 27);
		 Cita.add(lblSelecMascota);
		 
		 
		 //combo para seleccionar la mascota-----------------
		 listaMascotas = new JComboBox();
		 listaMascotas.setForeground(Color.BLACK);
		 listaMascotas.setBackground(Color.WHITE);
		 listaMascotas.setBounds(239, 81, 173, 27);
		 Cita.add(listaMascotas);
		 
		 
		  // Seleccionar fecha y Jcalendar-------------------------------------
		 
		 JLabel lblPaso2 = new JLabel("PASO 2.");
		 lblPaso2.setForeground(new Color(128, 0, 0));
		 lblPaso2.setFont(new Font("Tahoma", Font.BOLD, 12));
		 lblPaso2.setBounds(66, 149, 75, 27);
		 Cita.add(lblPaso2);
		 
		 JLabel lblSelecFecha = new JLabel("SELECCIONA FECHA :");
		 lblSelecFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblSelecFecha.setBounds(66, 176, 173, 27);
		 Cita.add(lblSelecFecha);
		 
		 calendar = new JCalendar();
		 calendar.getDayChooser().getDayPanel().setBackground(Color.WHITE);
		 calendar.setBounds(66, 226, 331, 269);
		 Cita.add(calendar);
		 // Color del numero de d�a 
		  calendar.setForeground(Color.BLACK);
		  
		 // Cambiamos color de letra del dia domingo
		 calendar.setSundayForeground(Color.RED);
		 //color de letra de semana
		 calendar.setWeekdayForeground(Color.BLUE);
		 
		// Fecha minima seleccionable
		 calendar.setMinSelectableDate(calendar.getDate());
		 
		 calendar.setWeekOfYearVisible(false);
		 
		 
		 // Seleccionar hora + combos------------------------------------
		 
		 JLabel lblPaso3 = new JLabel("PASO 3.");
		 lblPaso3.setForeground(new Color(128, 0, 0));
		 lblPaso3.setFont(new Font("Tahoma", Font.BOLD, 12));
		 lblPaso3.setBounds(66, 531, 75, 27);
		 Cita.add(lblPaso3);
		 
		 JLabel lblSelecHora = new JLabel("SELECCIONA HORA :");
		 lblSelecHora.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblSelecHora.setBounds(66, 556, 173, 27);
		 Cita.add(lblSelecHora);
		 
		 //combo para seleccionar la hora
		 cmbHora = new JComboBox();
		 cmbHora.setModel(new DefaultComboBoxModel(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		 cmbHora.setBounds(71, 594, 70, 22);
		 Cita.add(cmbHora);
		 
		 //combo para seleccionar los minutos
		 cmbMinutos = new JComboBox();
		 cmbMinutos.setModel(new DefaultComboBoxModel(new String[] {"00", "15", "30", "45"}));
		 cmbMinutos.setBounds(141, 594, 70, 22);
		 Cita.add(cmbMinutos);
		 
		 textDatosCita = new JTextPane();
		 textDatosCita.setBounds(815, 74, 563, 467);
		 Cita.add(textDatosCita);
		 
		 JLabel lblDatosCita = new JLabel("DATOS DE LA CITA : ");
		 lblDatosCita.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblDatosCita.setBounds(815, 49, 331, 14);
		 Cita.add(lblDatosCita);
		 
		 
		 btnValidarCita = new JButton("Validar");
		 btnValidarCita.setBounds(815, 582, 113, 35);
		 Cita.add(btnValidarCita);
		 btnValidarCita.addActionListener(this);
		 
		 btnCancelarCita = new JButton("Cancelar");
		 btnCancelarCita.setBounds(1053, 582, 113, 35);
		 Cita.add(btnCancelarCita);
		 btnCancelarCita.addActionListener(this);
		 
		 btnSalirCita = new JButton("Salir");
		 btnSalirCita.setBounds(1265, 581, 113, 35);
		 Cita.add(btnSalirCita);
		 btnSalirCita.addActionListener(this);
				 
		
	}

	private void crearPanelRegistroClientes() throws Exception{
		JPanel registro = new JPanel();
		registro.setBackground(Color.WHITE);
		panelPestanas.addTab("Registro de clientes", null, registro, null);
		registro.setLayout(null);
	
		 
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 119, 1315, 160);
		registro.add(scrollPane);
		
		ArrayList <Cliente> clientes = manager.getClientes();
				
		String titulos[]= {"DNI","NOMBRE","APELLIDOS","DIRECCION","LOCALIDAD","TEL�FONO", "TEL�FONO SECUNDARIO"};
		String  fila[][]= new String[clientes.size()] [titulos.length];
				
		for(int i=0;i<clientes.size();i++) {			
			fila[i][0]= clientes.get(i).getDni();
			fila[i][1]= clientes.get(i).getNombre();
			fila[i][2]= clientes.get(i).getApellido1()+" "+clientes.get(i).getApellido2();
			fila[i][3]= clientes.get(i).getDireccion();
			fila[i][4]= clientes.get(i).getLocalidad();
			fila[i][5]= clientes.get(i).getTelefono1();
			fila[i][6]= clientes.get(i).getTelefono2();
		}
		
		tablaClientes = new JTable(fila, titulos);
		tablaClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tablaClientes.setEnabled(false);
		scrollPane.setViewportView(tablaClientes);
		
		JLabel lblBuscador = new JLabel("BUSCADOR : ");
		lblBuscador.setBackground(Color.WHITE);
		lblBuscador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuscador.setBounds(58, 27, 545, 14);
		registro.add(lblBuscador);
		
		textDniBuscar = new JTextField();
		textDniBuscar.setToolTipText("introduce el DNI o NIE");
		textDniBuscar.setBounds(58, 46, 187, 20);
		registro.add(textDniBuscar);
		textDniBuscar.setColumns(10);
		
		ImageIcon lupa = new ImageIcon ("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\lupa.png");
		btnBuscar = new JButton("");
		btnBuscar.setBounds(265, 39, 32, 27);
		Icon iconoLupa = new ImageIcon(lupa.getImage().getScaledInstance(btnBuscar.getWidth(), btnBuscar.getHeight(), Image.SCALE_DEFAULT));
		btnBuscar.setIcon(iconoLupa);
		btnBuscar.addActionListener(this);
		registro.add(btnBuscar);
		
		lblResultado = new JLabel("RESULTADO DE LA B\u00DASQUEDA :");
		lblResultado.setBackground(Color.WHITE);
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResultado.setBounds(58, 362, 767, 14);
		registro.add(lblResultado);
		
		btnEditarRegistro = new JButton("EDITAR DATOS");
		btnEditarRegistro.setBackground(new Color(176, 224, 230));
		btnEditarRegistro.setBounds(787, 387, 199, 23);
		registro.add(btnEditarRegistro);
		
		btnEliminarCliente = new JButton("ELIMINAR CLIENTE");
		btnEliminarCliente.setBackground(new Color(205, 92, 92));
		btnEliminarCliente.setBounds(787, 439, 199, 23);
		registro.add(btnEliminarCliente);
		
		lblNombreBuscado = new JLabel("Nombre :");
		lblNombreBuscado.setBackground(Color.WHITE);
		lblNombreBuscado.setBounds(58, 387, 114, 14);
		registro.add(lblNombreBuscado);
		
		textNombreC = new JTextField();
		textNombreC.setBackground(Color.WHITE);
		textNombreC.setBounds(58, 401, 562, 20);
		registro.add(textNombreC);
		textNombreC.setColumns(10);
		
		lblApellidoBuscado = new JLabel("Primer apellido :");
		lblApellidoBuscado.setBackground(Color.WHITE);
		lblApellidoBuscado.setBounds(58, 440, 187, 14);
		registro.add(lblApellidoBuscado);
		
		textPrimerApellidoC = new JTextField();
		textPrimerApellidoC.setBackground(Color.WHITE);
		textPrimerApellidoC.setColumns(10);
		textPrimerApellidoC.setBounds(58, 456, 562, 20);
		registro.add(textPrimerApellidoC);
		
		lblApellidoBuscado2 = new JLabel("Segundo apellido :");
		lblApellidoBuscado2.setBackground(Color.WHITE);
		lblApellidoBuscado2.setBounds(58, 493, 187, 14);
		registro.add(lblApellidoBuscado2);
		
		textSegundoApellido = new JTextField();
		textSegundoApellido.setBackground(Color.WHITE);
		textSegundoApellido.setColumns(10);
		textSegundoApellido.setBounds(58, 509, 562, 20);
		registro.add(textSegundoApellido);
		
		lblDireccBuscada = new JLabel("Direcci\u00F3n : ");
		lblDireccBuscada.setBackground(Color.WHITE);
		lblDireccBuscada.setBounds(58, 545, 562, 14);
		registro.add(lblDireccBuscada);
		
		textDireccBuscada = new JTextField();
		textDireccBuscada.setColumns(10);
		textDireccBuscada.setBackground(Color.WHITE);
		textDireccBuscada.setBounds(58, 560, 562, 20);
		registro.add(textDireccBuscada);
		
		lblLocalidadB = new JLabel("Localidad :");
		lblLocalidadB.setBackground(Color.WHITE);
		lblLocalidadB.setBounds(58, 594, 562, 14);
		registro.add(lblLocalidadB);
		
		textLocalidadBuscada = new JTextField();
		textLocalidadBuscada.setColumns(10);
		textLocalidadBuscada.setBackground(Color.WHITE);
		textLocalidadBuscada.setBounds(58, 608, 562, 20);
		registro.add(textLocalidadBuscada);
		
		lblTelefonosBuscados = new JLabel("Tel\u00E9fonos :");
		lblTelefonosBuscados.setBackground(Color.WHITE);
		lblTelefonosBuscados.setBounds(58, 639, 562, 14);
		registro.add(lblTelefonosBuscados);
		
		textTelfBusc1 = new JTextField();
		textTelfBusc1.setBackground(Color.WHITE);
		textTelfBusc1.setBounds(58, 655, 239, 20);
		registro.add(textTelfBusc1);
		textTelfBusc1.setColumns(10);
		
		textTelfBusc2 = new JTextField();
		textTelfBusc2.setColumns(10);
		textTelfBusc2.setBackground(Color.WHITE);
		textTelfBusc2.setBounds(381, 655, 239, 20);
		registro.add(textTelfBusc2);
	}
	
	private void crearPanelRegistroMascotas() throws Exception{
		JPanel registroMascotas = new JPanel();
		registroMascotas.setBackground(Color.WHITE);
		panelPestanas.addTab("Registro de mascotas", null, registroMascotas, null);
		registroMascotas.setLayout(null);
		 
		JLabel lblBuscador = new JLabel("BUSCADOR : ");
		lblBuscador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuscador.setBounds(58, 27, 545, 14);
		registroMascotas.add(lblBuscador);
		
		textDniBuscar = new JTextField();
		textDniBuscar.setToolTipText("introduce el DNI o NIE");
		textDniBuscar.setBounds(58, 46, 187, 20);
		registroMascotas.add(textDniBuscar);
		textDniBuscar.setColumns(10);
		
		ImageIcon lupa = new ImageIcon ("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\lupa.png");
		btnBuscar = new JButton("");
		btnBuscar.setBounds(265, 39, 32, 27);
		Icon iconoLupa = new ImageIcon(lupa.getImage().getScaledInstance(btnBuscar.getWidth(), btnBuscar.getHeight(), Image.SCALE_DEFAULT));
		btnBuscar.setIcon(iconoLupa);
		btnBuscar.addActionListener(this);
		registroMascotas.add(btnBuscar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 119, 1315, 160);
		registroMascotas.add(scrollPane);
		
		ArrayList <Mascota> mascotas = manager.getRegistroMascotas();
		
		String titulos[]= {"DNI PROPIETARIO","NOMBRE","ESPECIE","RAZA","SEXO","FECHA DE NACIMIENTO", "CASTRADO"};
		String  fila[] []= new String[mascotas.size()] [titulos.length];
		tablaRegistroMascotas = new JTable(fila, titulos);
		
		for(int i=0;i<mascotas.size();i++) {			
			fila[i][0]= mascotas.get(i).getId();
			fila[i][1]= mascotas.get(i).getNombre();
			fila[i][2]= mascotas.get(i).getEspecie();
			fila[i][3]= mascotas.get(i).getRaza();
			fila[i][4]= mascotas.get(i).getSexo();
			fila[i][5]= mascotas.get(i).formatearFecha();
			fila[i][6]= mascotas.get(i).esCastrado();
		}
		
	//	int filaSeleccionada = tablaRegistroMascotas.rowAtPoint(evt.getPoint());
		tablaRegistroMascotas.setEnabled(false);;
		scrollPane.setViewportView(tablaRegistroMascotas);
		
		lblResultado = new JLabel("RESULTADO DE LA B\u00DASQUEDA :");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResultado.setBounds(58, 362, 767, 14);
		registroMascotas.add(lblResultado);
		
		textResultadoBusquedaMascota = new JTextPane();
		textResultadoBusquedaMascota.setBackground(new Color(255, 255, 255));
		textResultadoBusquedaMascota.setBounds(58, 387, 756, 151);
		registroMascotas.add(textResultadoBusquedaMascota);
		
		btnEditarRegistroMascota = new JButton("EDITAR DATOS");
		btnEditarRegistroMascota.setBackground(new Color(176, 224, 230));
		btnEditarRegistroMascota.setBounds(58, 570, 199, 23);
		registroMascotas.add(btnEditarRegistroMascota);
		
		btnEliminarMascota = new JButton("ELIMINAR MASCOTA");
		btnEliminarMascota.setBackground(new Color(205, 92, 92));
		btnEliminarMascota.setBounds(284, 570, 199, 23);
		registroMascotas.add(btnEliminarMascota);
	}
	
	//----------M�TODOS DEL �REA DE PERSONAL------------------------------------------------------------------------------------------------------//
	
	//m�todo que crea los componentes del alta de mascota
	private void altaMascota(JPanel personal, boolean blnVisible) {
		
		// cabecera ----------------------------------------------------------------------------------
		lblDatosRegistroMascota = new JLabel("ALTA DE MASCOTA");
		lblDatosRegistroMascota.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosRegistroMascota.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosRegistroMascota.setBounds(565, 36, 513, 14);
		lblDatosRegistroMascota.setVisible(blnVisible);
		personal.add(lblDatosRegistroMascota);
		
		separator = new JSeparator();
		separator.setForeground(new Color(176, 224, 230));
		separator.setBounds(334, 62, 1047, 2);
		separator.setVisible(blnVisible);
		personal.add(separator);
		
		// datos a rellenar --------------------------------------------------------------------------- 
		lblDniCliente = new JLabel("DNI del propietario/a :");
		lblDniCliente.setBounds(565, 88, 513, 14);
		lblDniCliente.setVisible(blnVisible);
		personal.add(lblDniCliente);
		 
		textaltaDni = new JTextField();
		textaltaDni.setBackground(Color.WHITE);
		textaltaDni.setBounds(565, 103, 513, 20);
		textaltaDni.setVisible(blnVisible);
		personal.add(textaltaDni);
		textaltaDni.setColumns(10);
		 
		lblNombreAltaMascota = new JLabel("Nombre de la mascota : ");
		lblNombreAltaMascota.setBounds(565, 137, 513, 14);
		lblNombreAltaMascota.setVisible(blnVisible);
		personal.add(lblNombreAltaMascota);
		 
		textAltaNombreMascota = new JTextField();
		textAltaNombreMascota.setBounds(565, 152, 513, 20);
		textAltaNombreMascota.setVisible(blnVisible);
		personal.add(textAltaNombreMascota);
		textAltaNombreMascota.setColumns(10);
		 
		lblEspecieMascota = new JLabel("Especie :");
		lblEspecieMascota.setBounds(565, 193, 513, 14);
		lblEspecieMascota.setVisible(blnVisible);
		personal.add(lblEspecieMascota);
		 
		textEspecieMascota = new JTextField();
		textEspecieMascota.setBounds(565, 209, 513, 20);
		textEspecieMascota.setVisible(blnVisible);
		personal.add(textEspecieMascota);
		textEspecieMascota.setColumns(10);
		
		lblRazaMascota = new JLabel("Raza : ");
		lblRazaMascota.setBounds(565, 250, 513, 14);
		lblRazaMascota.setVisible(blnVisible);
		personal.add(lblRazaMascota);
		
		textRazaMascota = new JTextField();
		textRazaMascota.setBounds(565, 264, 513, 20);
		textRazaMascota.setVisible(blnVisible);
		personal.add(textRazaMascota);
		textRazaMascota.setColumns(10);
		
		lblFechaNacimiento = new JLabel("Fecha de nacimiento (yyyy-mm-dd) :");
		lblFechaNacimiento.setBounds(565, 313, 513, 14);
		lblFechaNacimiento.setVisible(blnVisible);
		personal.add(lblFechaNacimiento);
		 
		textFechaNaciMascota = new JTextField();
		textFechaNaciMascota.setBounds(565, 327, 513, 20);
		textFechaNaciMascota.setVisible(blnVisible);
		personal.add(textFechaNaciMascota);
		textFechaNaciMascota.setColumns(10);
		
		lblSexoMascota = new JLabel("sexo :");
		lblSexoMascota.setBounds(565, 371, 513, 14);
		lblSexoMascota.setVisible(blnVisible);
		personal.add(lblSexoMascota);
		
		textSexoMascota = new JTextField();
		textSexoMascota.setBounds(565, 387, 513, 20);
		textSexoMascota.setVisible(blnVisible);
		personal.add(textSexoMascota);
		textSexoMascota.setColumns(10);
		
		chckbxEsterilizadoAlta = new JCheckBox("\u00BFEst\u00E1 esterilizado/a");
		chckbxEsterilizadoAlta.setBackground(Color.WHITE);
		chckbxEsterilizadoAlta.setBounds(560, 433, 518, 23);
		chckbxEsterilizadoAlta.setVisible(blnVisible);
		personal.add(chckbxEsterilizadoAlta);
		
		// botones------------------------------------------------------------------------------
		btnRegistrarAnimal = new JButton("ACEPTAR");
		btnRegistrarAnimal.setBounds(565, 511, 121, 23);
		btnRegistrarAnimal.setVisible(blnVisible);
		personal.add(btnRegistrarAnimal);
		btnRegistrarAnimal.addActionListener(this);
		 
		btnCancelarMascota = new JButton("CANCELAR");
		btnCancelarMascota.setBounds(957, 511, 121, 23);
		btnCancelarMascota.setVisible(blnVisible);
		personal.add(btnCancelarMascota);
		btnCancelarMascota.addActionListener(this);
		
		limpiarFormularioMascota();
	}

	//m�todo que crea los componentes del alta de mascota
	private void altacliente(JPanel personal, boolean blnVisible) {
		// cabecera-------------------------------------------------------------
		lblDatosRegistro = new JLabel("ALTA DE CLIENTE");
		lblDatosRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosRegistro.setBounds(565, 36, 513, 14);
		lblDatosRegistro.setVisible(blnVisible);
		personal.add(lblDatosRegistro);
		
		separator = new JSeparator();
		separator.setForeground(new Color(176, 224, 230));
		separator.setBounds(334, 62, 1047, 2);
		separator.setVisible(blnVisible);
		personal.add(separator);
		 
		// datos a rellenar ------------------------------------------------------
		lblDniCliente = new JLabel("DNI o NIE:");
		lblDniCliente.setBounds(565, 88, 513, 14);
		lblDniCliente.setVisible(blnVisible);
		personal.add(lblDniCliente);
		 
		textaltaDni = new JTextField();
		textaltaDni.setBackground(Color.WHITE);
		textaltaDni.setBounds(565, 103, 513, 20);
		textaltaDni.setVisible(blnVisible);
		personal.add(textaltaDni);
		textaltaDni.setColumns(10);
		 
		lblNombreCliente = new JLabel("Nombre : ");
		lblNombreCliente.setBounds(565, 137, 513, 14);
		lblNombreCliente.setVisible(blnVisible);
		personal.add(lblNombreCliente);
		 
		textAltaNombre = new JTextField();
		textAltaNombre.setBounds(565, 152, 513, 20);
		textAltaNombre.setVisible(blnVisible);
		personal.add(textAltaNombre);
		textAltaNombre.setColumns(10);
		 
		lblApellCliente1 = new JLabel("Primer apellido  :");
		lblApellCliente1.setBounds(565, 193, 513, 14);
		lblApellCliente1.setVisible(blnVisible);
		personal.add(lblApellCliente1);
		 
		textAltaApell1 = new JTextField();
		textAltaApell1.setBounds(565, 209, 513, 20);
		textAltaApell1.setVisible(blnVisible);
		personal.add(textAltaApell1);
		textAltaApell1.setColumns(10);
		 
		lblApellCliente2 = new JLabel("Segundo apellido : ");
		lblApellCliente2.setBounds(565, 250, 513, 14);
		lblApellCliente2.setVisible(blnVisible);
		personal.add(lblApellCliente2);
		
		textAltaApell2 = new JTextField();
		textAltaApell2.setBounds(565, 264, 513, 20);
		textAltaApell2.setVisible(blnVisible);
		personal.add(textAltaApell2);
		textAltaApell2.setColumns(10);
		 
		lblTelefCliente1 = new JLabel("Tel\u00E9fono :");
		lblTelefCliente1.setBounds(565, 313, 513, 14);
		lblTelefCliente1.setVisible(blnVisible);
		personal.add(lblTelefCliente1);
		 
		textAltaTelef1 = new JTextField();
		textAltaTelef1.setBounds(565, 327, 513, 20);
		textAltaTelef1.setVisible(blnVisible);
		personal.add(textAltaTelef1);
		textAltaTelef1.setColumns(10);
		 
		lblTelefCliente2 = new JLabel("Otro tel\u00E9fono de contacto :");
		lblTelefCliente2.setBounds(565, 371, 513, 14);
		lblTelefCliente2.setVisible(blnVisible);
		personal.add(lblTelefCliente2);
		
		textAltaTelef2 = new JTextField();
		textAltaTelef2.setBounds(565, 387, 513, 20);
		textAltaTelef2.setVisible(blnVisible);
		personal.add(textAltaTelef2);
		textAltaTelef2.setColumns(10);
		 
		lblDirecCliente = new JLabel("Direcci\u00F3n :");
		lblDirecCliente.setBounds(565, 437, 513, 14);
		lblDirecCliente.setVisible(blnVisible);
		personal.add(lblDirecCliente);
		
		textAltaDirec = new JTextField();
		textAltaDirec.setBounds(565, 451, 513, 20);
		textAltaDirec.setVisible(blnVisible);
		personal.add(textAltaDirec);
		textAltaDirec.setColumns(10);
		 
		lblLocalCliente = new JLabel("Localidad :");
		lblLocalCliente.setBounds(565, 498, 513, 14);
		lblLocalCliente.setVisible(blnVisible);
		personal.add(lblLocalCliente);
		
		textAltaLocal = new JTextField();
		textAltaLocal.setBounds(565, 512, 513, 20);
		textAltaLocal.setVisible(blnVisible);
		personal.add(textAltaLocal);
		textAltaLocal.setColumns(10);
		
		// botones------------------------------------------------------------------------
		btnRegistrarCliente = new JButton("ACEPTAR");
		btnRegistrarCliente.setBounds(565, 584, 121, 23);
		btnRegistrarCliente.setVisible(blnVisible);
		personal.add(btnRegistrarCliente);
		btnRegistrarCliente.addActionListener(this);
		 
		btnCrearUsuario = new JButton("GENERAR USUARIO");
		btnCrearUsuario.setBounds(736, 584, 179, 23);
		btnCrearUsuario.setVisible(blnVisible);
		btnCrearUsuario.setEnabled(false);  // hasta que no registre al cliente no se activa la posibilidad de crear usuario
		personal.add(btnCrearUsuario);
		btnCrearUsuario.addActionListener(this);
		 
		btnCancelarCliente = new JButton("CANCELAR");
		btnCancelarCliente.setBounds(957, 584, 121, 23);
		btnCancelarCliente.setVisible(blnVisible);
		personal.add(btnCancelarCliente);
		btnCancelarCliente.addActionListener(this);
		
		btnRegistraMascota = new JButton(" DAR DE ALTA UNA MASCOTA ");
		btnRegistraMascota.setBounds(565, 637, 513, 23);
		btnRegistraMascota.setVisible(blnVisible);
		btnRegistraMascota.setEnabled(false); // hasta que no registre al cliente no se activa la posibilidad de registrar una mascota
		personal.add(btnRegistraMascota);
		btnRegistraMascota.addActionListener(this);
		
		limpiarFormulario();
	}

	// m�todo que habilita o inhabilita los textArea del alta de mascotas
	private void activarTextAreaMascota(boolean b) {
		textAltaNombreMascota.setEditable(b);
		textEspecieMascota.setEditable(b);
		textRazaMascota.setEditable(b);
		textFechaNaciMascota.setEditable(b);
		textSexoMascota.setEditable(b);
		chckbxEsterilizadoAlta.setEnabled(b);
	}
	
	//m�todo que comprueba que todos los campos est�n completados
	
	private boolean comprobarCamposCliente() {
		boolean blnCompletos=false;
		
		if(textaltaDni.getText().length()!=9) {
			String mensaje = "�DNI o NIE incorrecto!";
			JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
		}
		
		else if(textaltaDni.getText().length()==9) {
				if(!textAltaNombre.getText().isBlank()) {
					if(!textAltaApell1.getText().isBlank()) {
						if(!textAltaApell2.getText().isBlank()) {
							if(!textAltaDirec.getText().isBlank()) {
								if(!textAltaLocal.getText().isBlank() ) {
									if(!textAltaTelef1.getText().isBlank()) {
										blnCompletos=true;
									}
								}
							}
						}
					}
				}
		}
		
		return blnCompletos;
	}

	//m�todo que comprueba que todos los campos est�n completados
	
	private boolean comprobarCamposMascota() {
		boolean blnCompletos=false;
		
		if(!textAltaNombreMascota.getText().isBlank()) {
			if(!textEspecieMascota.getText().isBlank()) {
				if(!textRazaMascota.getText().isBlank()) {
					if(!textFechaNaciMascota.getText().isBlank()) {
						if(!textSexoMascota.getText().isBlank()) {
							blnCompletos = true;
						}
					}
				}
			}
		}
		
		return blnCompletos;
	}

	//m�todo que recoge el contenido del textArea del alta de mascota
	
	private void recogerDatosMascota(String text) {
		Mascota nuevaM = new Mascota();
		
		try {
			
			nuevaM.setId(textaltaDni.getText());
			nuevaM.setNombre(textAltaNombreMascota.getText().trim());
			nuevaM.setEspecie(textEspecieMascota.getText().trim());
			nuevaM.setRaza(textRazaMascota.getText());
			
			//recogemos en un string el texto del campo fecha de nacimiento:
			String fecha = textFechaNaciMascota.getText().trim();
			
			//indicamos el formato que acepta MySQL en las variables de tipo date:
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaNac = null;
			
			//convertimos el string en LocalDate: 
			try {
				fechaNac=formatter.parse(fecha);
			}catch (ParseException e1){
				System.out.println(e1);
			}
			
			//instanciamos la fecha:
			nuevaM.setFechaNacimiento(fechaNac);
			nuevaM.setSexo(textSexoMascota.getText().trim());
			boolean blnCastrado;
			
			if(chckbxEsterilizadoAlta.isSelected()) {
				blnCastrado = true;
			}
			else {
				blnCastrado = false;
			}

			nuevaM.setBlnCastrado(blnCastrado);
			
			manager.guardarDatosMascota(nuevaM);
			
		}catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		
	}

	// m�todo que limpia los campos
	
	private void limpiarFormularioMascota() {
		textAltaNombreMascota.setText("");
		textEspecieMascota.setText("");
		textRazaMascota.setText("");
		textFechaNaciMascota.setText("");
		textSexoMascota.setText("");
		chckbxEsterilizadoAlta.setSelected(false);
		
		// no permitimos que le de al bot�n de registrar Mascota
		btnRegistrarAnimal.setEnabled(false);
	}

	// m�todo que limpia los campos
	
	private void limpiarFormulario() {
		
		textaltaDni.setText("");
		textAltaNombre.setText("");
		textAltaApell1.setText("");
		textAltaApell2.setText("");
		textAltaTelef1.setText("");
		textAltaTelef2.setText("");
		textAltaDirec.setText("");
		textAltaLocal.setText("");
		
		//no permitimos que le de al bot�n de crear usuario
		btnCrearUsuario.setEnabled(false);
	}

	// m�todo que crea la clave del cliente
	
	private String crearClaveUsuario() {
		String clave = "";
		try {
			String letras = "";
			
			if(textAltaNombre.getText().length()==3) {
				letras = textAltaNombre.getText();
				letras=letras.toUpperCase();
			}
			else {
			
				letras=textAltaNombre.getText().substring(0, 3);
				letras=letras.toUpperCase();
			}
			
			String numeros = "";
			numeros = textaltaDni.getText().substring(0,3);
			
			clave = letras+numeros;
			
			manager.crearUsuario(textaltaDni.getText(), clave, 3);
			
		}catch (Exception e1) {
			e1.getMessage();
		}
		
		return clave;
	}

	// m�todo que recoge los datos del nuevo cliente
	private void recogerDatosCliente()  {
		Cliente nuevoC = new Cliente();
		
		try {
			
			nuevoC.setDni(textaltaDni.getText());
			nuevoC.setNombre(textAltaNombre.getText());
			nuevoC.setApellido1(textAltaApell1.getText());
			nuevoC.setApellido2(textAltaApell2.getText());
			nuevoC.setDireccion(textAltaDirec.getText());
			nuevoC.setLocalidad(textAltaLocal.getText());
			nuevoC.setTelefono1(textAltaTelef1.getText());
			
			if(textAltaTelef2.getText().trim().length()>0) {
				nuevoC.setTelefono2(textAltaTelef2.getText());
			}
			else {
				nuevoC.setTelefono2(null);
			}
			
			manager.guardarDatos(nuevoC);
		
		}
		catch (Exception e1) {
			e1.getMessage();
		}
		
		
	}

	// m�todo que habilita o inhabilita los textArea del alta de cliente
	private void activarTextArea(boolean b) {
		
		textaltaDni.setEditable(b);
		textAltaNombre.setEditable(b);
		textAltaApell1.setEditable(b);
		textAltaApell2.setEditable(b);
		textAltaDirec.setEditable(b);
		textAltaLocal.setEditable(b);
		textAltaTelef1.setEditable(b);
		textAltaTelef2.setEditable(b);
	}

	// m�todo que muestra el �rea del alta de mascota
	private void mostrarAltaMascota(boolean blnVisible) {
		
		// cabecera-------------------------------------------------
		lblDatosRegistroMascota.setVisible(blnVisible);
		separator.setVisible(blnVisible);
		
		activarTextAreaMascota(true);
		// datos a rellenar ----------------------------------------
		lblDniCliente.setVisible(blnVisible);
		textaltaDni.setVisible(blnVisible);
		lblNombreAltaMascota.setVisible(blnVisible);
		textAltaNombreMascota.setVisible(blnVisible);
		lblEspecieMascota.setVisible(blnVisible);
		textEspecieMascota.setVisible(blnVisible);
		lblRazaMascota.setVisible(blnVisible);
		textRazaMascota.setVisible(blnVisible);
		lblFechaNacimiento.setVisible(blnVisible);
		textFechaNaciMascota.setVisible(blnVisible);
		lblSexoMascota.setVisible(blnVisible);
		textSexoMascota.setVisible(blnVisible);
		chckbxEsterilizadoAlta.setVisible(blnVisible);
		
		// botones--------------------------------------------------
		btnRegistrarAnimal.setVisible(blnVisible);
		btnCancelarMascota.setVisible(blnVisible);
		btnRegistrarAnimal.setEnabled(true);
		
		
		// cambiamos color de fondo del textArea---------------------
		textaltaDni.setBackground(new Color(245,255,250));
		textAltaNombreMascota.setBackground(new Color(245,255,250));
		textEspecieMascota.setBackground(new Color(245,255,250));
		textRazaMascota.setBackground(new Color(245,255,250));
		textFechaNaciMascota.setBackground(new Color(245,255,250));
		textSexoMascota.setBackground(new Color(245,255,250));
		
	}

	// m�todo que muestra el �rea del alta de cliente
	private void mostrarAltacliente(boolean blnVisible) {
		// cabecera-------------------------------------------------
		lblDatosRegistro.setVisible(blnVisible);
		separator.setVisible(blnVisible);
		
		// datos a rellenar ----------------------------------------
		lblDniCliente.setVisible(blnVisible);
		textaltaDni.setVisible(blnVisible);
		lblNombreCliente.setVisible(blnVisible);
		textAltaNombre.setVisible(blnVisible);
		lblApellCliente1.setVisible(blnVisible);
		textAltaApell1.setVisible(blnVisible);
		lblApellCliente2.setVisible(blnVisible);
		textAltaApell2.setVisible(blnVisible);
		lblTelefCliente1.setVisible(blnVisible);
		textAltaTelef1.setVisible(blnVisible);
		lblTelefCliente2.setVisible(blnVisible);
		textAltaTelef2.setVisible(blnVisible);
		lblDirecCliente.setVisible(blnVisible);
		textAltaDirec.setVisible(blnVisible);
		lblLocalCliente.setVisible(blnVisible);
		textAltaLocal.setVisible(blnVisible);
		
		// botones----------------------------------------
		btnRegistrarCliente.setVisible(blnVisible);
		btnCrearUsuario.setVisible(blnVisible);
		btnCancelarCliente.setVisible(blnVisible);
		btnRegistraMascota.setVisible(blnVisible);
		
		// cambiamos color de fondo del textArea-----------
		textaltaDni.setBackground(new Color(245,255,250));
		textAltaNombre.setBackground(new Color(245,255,250));
		textAltaApell1.setBackground(new Color(245,255,250));
		textAltaApell2.setBackground(new Color(245,255,250));
		textAltaTelef1.setBackground(new Color(245,255,250));
		textAltaTelef2.setBackground(new Color(245,255,250));
		textAltaDirec.setBackground(new Color(245,255,250));
		textAltaLocal.setBackground(new Color(245,255,250));
		
	}

	
	//----------M�TODOS DEL �REA DE CLIENTE----------------------------------------------------------------------------------------------------//
	
	//m�todo que crea los componentes de las mascotas en el �rea del cliente
	public void datosMascota(JPanel ficha, boolean blnVisible, String dniCliente) throws Exception {
			
		lblDatosMascota.setVisible(blnVisible);
		separatorMascotas.setVisible(blnVisible);
		
		ImageIcon fotoMascota = new ImageIcon("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\mascotas\\huella.png");
		lblFotoMascota1 = new JLabel("");
		lblFotoMascota1.setBounds(381, 504, 259, 209);
		Icon mascota = new ImageIcon(fotoMascota.getImage().getScaledInstance(lblFotoMascota1.getWidth(), lblFotoMascota1.getHeight(), Image.SCALE_DEFAULT));
		lblFotoMascota1.setIcon(mascota);
		lblFotoMascota1.setVisible(blnVisible);
		ficha.add(lblFotoMascota1);
		   
		   
		lblNombreMascota = new JLabel("Nombre: ");
		lblNombreMascota.setBounds(755, 534, 180, 14);
		lblNombreMascota.setVisible(blnVisible);
		ficha.add(lblNombreMascota);
		
		textNombreMascota = new JTextField();
		textNombreMascota.setBackground(Color.WHITE);
		textNombreMascota.setEditable(false);
		textNombreMascota.setBounds(755, 547, 180, 20);
		textNombreMascota.setColumns(10);
		textNombreMascota.setVisible(blnVisible);
		ficha.add(textNombreMascota);
		
		lblEspecie = new JLabel("Especie: ");
		lblEspecie.setBounds(1061, 534, 180, 14);
		lblEspecie.setVisible(blnVisible);
		ficha.add(lblEspecie);
		
		textEspecie = new JTextField();
		textEspecie.setBackground(Color.WHITE);
		textEspecie.setEditable(false);
		textEspecie.setBounds(1061, 547, 180, 20);
		textEspecie.setColumns(10);
		textEspecie.setVisible(blnVisible);
		ficha.add(textEspecie);
		
		lblRaza = new JLabel("Raza :");
		lblRaza.setBounds(1061, 589, 180, 14);
		lblRaza.setVisible(blnVisible);
		ficha.add(lblRaza);
		
		textRaza = new JTextField();
		textRaza.setBackground(Color.WHITE);
		textRaza.setEditable(false);
		textRaza.setBounds(1061, 604, 180, 20);
		textRaza.setColumns(10);
		textRaza.setVisible(blnVisible);
		ficha.add(textRaza);
		
		lblSexo = new JLabel("Sexo : ");
		lblSexo.setBounds(755, 644, 180, 14);
		lblSexo.setVisible(blnVisible);
		ficha.add(lblSexo);
		
		textSexo = new JTextField();
		textSexo.setBackground(Color.WHITE);
		textSexo.setEditable(false);
		textSexo.setBounds(755, 660, 180, 20);
		textSexo.setColumns(10);
		textSexo.setVisible(blnVisible);
		ficha.add(textSexo);
		
		lblFechaNaci = new JLabel("Fecha de nacimiento : ");
		lblFechaNaci.setBounds(755, 589, 180, 14);
		lblFechaNaci.setVisible(blnVisible);
		ficha.add(lblFechaNaci);
		
		textFechaNaci = new JTextField();
		textFechaNaci.setBackground(Color.WHITE);
		textFechaNaci.setBounds(755, 604, 180, 20);
		textFechaNaci.setColumns(10);
		textFechaNaci.setEditable(false);
		textFechaNaci.setVisible(blnVisible);
		ficha.add(textFechaNaci);
		
		chckbxEsterilizado = new JCheckBox("Esterilizado");
		chckbxEsterilizado.setBackground(Color.WHITE);
		chckbxEsterilizado.setBounds(1061, 658, 97, 23);
		chckbxEsterilizado.setVisible(blnVisible);
		ficha.add(chckbxEsterilizado);
		
		//TABLA DONDE APARECEN LOS NOMBRES DE LAS MASCOTAS QUE TIENE EL CLIENTE
		
		scrollPaneMascotas = new JScrollPane();
		scrollPaneMascotas.setBounds(340, 50, 1033, 372);
		scrollPaneMascotas.setVisible(blnVisible);
		ficha.add(scrollPaneMascotas);
		
		
		ArrayList <Mascota> mascotas = manager.getMascotasCliente(dniCliente);
		
		String titulos[]= {"Nombre","Especie","Raza","Sexo","Fecha de nacimiento","Castrado"};
		String  fila[] []= new String[mascotas.size()] [titulos.length];
		tablaMascotas = new JTable(fila, titulos);
		tablaMascotas.setBackground(Color.WHITE);

		
		for(int i=0;i<mascotas.size();i++) {			
				fila[i][0]= mascotas.get(i).getNombre();
				fila[i][1]= mascotas.get(i).getEspecie();
				fila[i][2]= mascotas.get(i).getRaza();
				fila[i][3]= mascotas.get(i).getSexo();
				fila[i][4]= mascotas.get(i).formatearFecha();
				fila[i][5]= mascotas.get(i).esCastrado();
		}
		
		tablaMascotas.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent e) 
			      {
			         int filaSeleccionada = tablaMascotas.rowAtPoint(e.getPoint());
			         if ((filaSeleccionada > -1)) {
			        	 textNombreMascota.setText(tablaMascotas.getValueAt(filaSeleccionada, 0).toString());
				 		textEspecie.setText(tablaMascotas.getValueAt(filaSeleccionada, 1).toString());
				 		textRaza.setText(tablaMascotas.getValueAt(filaSeleccionada, 2).toString());
				 		textSexo.setText(tablaMascotas.getValueAt(filaSeleccionada, 3).toString());
				 		textFechaNaci.setText(tablaMascotas.getValueAt(filaSeleccionada, 4).toString());
				 		if(tablaMascotas.getValueAt(filaSeleccionada, 5).toString().equalsIgnoreCase("SI")) {
				 			chckbxEsterilizado.setSelected(true);
				 		}
				 		else {
				 			chckbxEsterilizado.setSelected(false);
				 		}
			         
			         }
			   }
		  });
		
		tablaMascotas.setEnabled(false);
		scrollPaneMascotas.setViewportView(tablaMascotas);
		
	}
	
	// m�todo que muestra los datos del cliente
	public void datosCliente(String dniUsuario) {
		
		try {
			 Cliente cliente = manager.getCliente(dniUsuario);
			 textDniUser.setText(cliente.getDni());
			 textNombreUser.setText(cliente.getNombre());
			 textApellUser1.setText(cliente.getApellido1());
			 textApellUser2.setText(cliente.getApellido2());
			 textDireccUser.setText(cliente.getDireccion());
			 textLocalidad.setText(cliente.getLocalidad());
			 textTelefUser.setText(cliente.getTelefono1());
			 textTelefUser2.setText(cliente.getTelefono2());
			 
		 }
		 catch(Exception e1) {
			 e1.getMessage();
		 }
		 
	}
	
	//m�todo que muestra las mascotas de un cliente
	private void mostrarMascota(boolean blnVisible) {
		
		lblFotoMascota1.setVisible(blnVisible);
		lblNombreMascota.setVisible(blnVisible);
		textNombreMascota.setVisible(blnVisible);
		lblEspecie.setVisible(blnVisible);
		textEspecie.setVisible(blnVisible);
		lblRaza.setVisible(blnVisible);
		textRaza.setVisible(blnVisible);
		lblSexo.setVisible(blnVisible);
		textSexo.setVisible(blnVisible);
		lblFechaNaci.setVisible(blnVisible);
		textFechaNaci.setVisible(blnVisible);
		chckbxEsterilizado.setVisible(blnVisible);
		scrollPaneMascotas.setVisible(blnVisible);
		tablaMascotas.setVisible(blnVisible);
		lblDatosMascota.setVisible(blnVisible);
		separatorMascotas.setVisible(blnVisible);
		
	}

	// m�todo que permite editar los datos
	private void mostrarDatosEditar(boolean blnEditable) {
		
		if(blnEditable) {
		// colores------------------------------------------------
		textDireccUser.setBackground(new Color(224,255,255));
		textLocalidad.setBackground(new Color(224,255,255));
		textTelefUser.setBackground(new Color(224,255,255));
		textTelefUser2.setBackground(new Color(224,255,255));
		}
		if(!blnEditable) {
		// colores------------------------------------------------
		textDireccUser.setBackground(Color.WHITE);
		textLocalidad.setBackground(Color.WHITE);
		textTelefUser.setBackground(Color.WHITE);
		textTelefUser2.setBackground(Color.WHITE);
		}
		// editable-----------------------------------------------
		textDireccUser.setEditable(blnEditable);
		textLocalidad.setEditable(blnEditable);
		textTelefUser.setEditable(blnEditable);
		textTelefUser2.setEditable(blnEditable);
		// visible------------------------------------------------
		btnMascotas.setVisible(false);
		btnCitas.setVisible(false);
		btnPedidos.setVisible(false);
		btnAceptarCambios.setVisible(true);
		btnCancelarCambios.setVisible(true);
		
	}
	
	private boolean comprobarCambios() {
		boolean blnCorrectos = false;
		
		if(!textDireccUser.getText().isBlank()) {
			if(!textLocalidad.getText().isBlank()) {
				if(!textTelefUser.getText().isBlank()) {
					blnCorrectos=true;
				}
			}
		}
		
		return blnCorrectos;
	}
	// m�todo que recoge los cambios que ha realizado
	private Cliente cargarCambios() {
		Cliente cambiado = new Cliente();
		
		cambiado.setDni(textDniUser.getText());
		cambiado.setNombre(textNombreUser.getText());
		cambiado.setApellido1(textApellUser1.getText());
		cambiado.setApellido2(textApellUser2.getText());
		cambiado.setDireccion(textDireccUser.getText());
		cambiado.setLocalidad(textLocalidad.getText());
		cambiado.setTelefono1(textTelefUser.getText());
		cambiado.setTelefono2(textTelefUser2.getText());
		
		return cambiado;
	}
	
	//----------M�TODOS DEL PANEL TIENDA----------------------------------------------------------------------------------------------------//
	
	private void crearTablaArticulos(String animal) throws Exception{
		
		JScrollPane scrollPaneTienda = new JScrollPane();
		scrollPaneTienda.setBounds(57, 47, 1253, 666);
		tienda.add(scrollPaneTienda);
		 
		ArrayList <Tienda> articulos = manager.getArticulosTienda(animal);
		String titulos[]= {"PRODUCTO","NOMBRE","DESCRIPCION","PRECIO","STOCK"};
		Object  fila[] []= new String[articulos.size()] [titulos.length];
		
		tablaArticulo = new JTable(fila, titulos);
		tablaArticulo.setBackground(Color.WHITE);
		
		for(int i=0;i<articulos.size();i++) {	
			fila[i][0]= createImage("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\tienda\\Gatos\\Pienso");
			fila[i][1]= articulos.get(i).getNombre();
			fila[i][2]= articulos.get(i).getDescripcion();
			fila[i][3]= Float.toString(articulos.get(i).getPrecio())+" �";
			fila[i][4]= Integer.toString(articulos.get(i).getAlmacenados());
		}
		
		
		scrollPaneTienda.setViewportView(tablaArticulo);
		
	}
	
	public ImageIcon createImage(String path) {
		  URL imgURL = getClass().getResource(path);
		     if (imgURL != null) {
		         return new ImageIcon(imgURL);
		     } else {
		         
		         return null;
		     }
		 }
	
	//------------------ACTION LISTENERS-------------------------------------------------------------------------------------------------//
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		//buttons �rea personal usuario--------------------------------------------------------------------------------------------------
		
		if(e.getSource().equals(btnEditar)) {
			mostrarMascota(false);
			mostrarDatosEditar(true);
		}
		
		//----butons editar--------------------------------------------------------------------------------------------------------------
		
		if(e.getSource().equals(btnAceptarCambios)) {
			
			if(comprobarCambios()) {
					String mensaje = "�Quieres guardar los cambios?";
					int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
					
					if(opc == JOptionPane.YES_OPTION) {
						Cliente cambiado = cargarCambios();
						try {
							manager.cambiarDatosUsuario(cambiado);
							JOptionPane.showMessageDialog(null, "Se han guardado los cambios");
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
					}
					else {
						mostrarDatosEditar(true);
					}
			}
			else {
				String mensaje = "Debes rellenar los campos correctamente";
				JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
			}
			
			mostrarDatosEditar(false);
			btnAceptarCambios.setVisible(false);
			btnCancelarCambios.setVisible(false);
			btnMascotas.setVisible(true);
			btnCitas.setVisible(true);
			btnPedidos.setVisible(true);	
		}
		
		if(e.getSource().equals(btnCancelarCambios)) {
			
			String mensaje = "�Quieres cancelar los cambios?";
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			
			if(opc == JOptionPane.YES_OPTION) {
				datosCliente(textDniUser.getText());
				mostrarDatosEditar(false);
			}
			else {
				mostrarDatosEditar(true);
			}		
		}
		
		if(e.getSource().equals(btnMascotas)) {
			
			mostrarMascota(true);
		}
		
		if(e.getSource().equals(btnCitas)) {
			mostrarMascota(false);
		}
		
		if(e.getSource().equals(btnPedidos)) {
			mostrarMascota(false);
		}
		
		if(e.getSource().equals(btnCerrarSesionCliente)) {
			
			String mensaje = "�Quieres cerrar la sesi�n?";
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			if(opc==JOptionPane.YES_OPTION) {
				dispose();
			}
		
		}
		
		//buttons pesta�a citas----------------------------------------------------------------------------------------------------------------------------
		
		if(e.getSource().equals(btnValidarCita)) {
			
		}
		if(e.getSource().equals(btnCancelarCita)) {
			
		}
		if(e.getSource().equals(btnSalirCita)) {
			dispose();
		}
		
		//butons pesta�a tienda-----------------------------------------------------------------------------------------------------------------------------
		
		if(e.getSource().equals(btnGatos)) {
			
		}
		
		if(e.getSource().equals(btnPerros)){
			
		}
		
		if(e.getSource().equals(btnOtros)) {
			
		}
		
		if(e.getSource().equals(btnCarrito)) {
			
		}
		
		// buttons pesta�a personal--------------------------------------------------------------------------------------------------------------------------
		
		if(e.getSource().equals(btnAltaClientes)) {
			mostrarAltaMascota(false);
			mostrarAltacliente(true);
			activarTextArea(true);
		}
			
		if(e.getSource().equals(btnAltaMascotas)) {
			mostrarAltacliente(false);
			mostrarAltaMascota(true);
			textaltaDni.setEditable(true);
			
		}
		if(e.getSource().equals(btnAsignarCita)) {
			mostrarAltaMascota(false);
			mostrarAltacliente(false);
		}
		
		if(e.getSource().equals(btnCerrarSesionPersonal)) {
			
				String mensaje = "�Quieres cerrar la sesi�n?";
				int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
				if(opc==JOptionPane.YES_OPTION) {
					dispose();
				}
		
		}
		
		//butons alta de cliente-------------------------------------------------------------------------------------------------------------------------------
		
		if(e.getSource().equals(btnRegistrarCliente)) {
			
			//comprobamos que todos los campos est�n completos
			if(comprobarCamposCliente()) {
						
				recogerDatosCliente();
				
				//desactivamos campos para que no haga modificaciones posteriores al alta
				activarTextArea(false);
				
				//mostramos mensaje de registro realizado
				JOptionPane.showMessageDialog(this, "Usuario registrado correctamente", "INFORMACI�N", JOptionPane.INFORMATION_MESSAGE);
				btnCrearUsuario.setEnabled(true);
				btnRegistrarCliente.setEnabled(false);
				btnRegistraMascota.setEnabled(true);
				btnCancelarCliente.setEnabled(false);
			}
			else {
				String mensaje = "�Debes rellenar todos los campos!";
				JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		if(e.getSource().equals(btnCancelarCliente)) {
			
			String mensaje = "�Quieres cancelar el registro?";
			
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			
			if(opc == JOptionPane.YES_OPTION) {
				limpiarFormulario();
			}
		}
		
		if(e.getSource().equals(btnCrearUsuario)) {
			String clave = crearClaveUsuario();
			String mensaje = "Usuario: "+textaltaDni.getText()+
					"\n	"+"Clave: "+clave;
			JOptionPane.showMessageDialog(this, mensaje, "DATOS", JOptionPane.INFORMATION_MESSAGE);	
			
			btnCrearUsuario.setEnabled(false);
		}
		
		if(e.getSource().equals(btnRegistraMascota)) {
			mostrarAltacliente(false);
			mostrarAltaMascota(true);
			btnRegistrarAnimal.setEnabled(true);
			textaltaDni.setText(textaltaDni.getText());
			textaltaDni.setEditable(false);
			activarTextAreaMascota(true);
			
		}
		
		// buttons alta de mascota------------------------------------------------------------------------------------------------------------------------------
		
		if(e.getSource().equals(btnRegistrarAnimal)) {
			
			//comprobamos que todos los campos est�n completos
			if(comprobarCamposMascota()) {
				recogerDatosMascota(textaltaDni.getText());
				
				//desactivamos campos para que no haga modificaciones posteriores al alta
				activarTextAreaMascota(false);
				btnCancelarMascota.setEnabled(false);
				
				//mostramos mensaje de registro realizado
				String mensaje ="Mascota registrada correctamente";
				JOptionPane.showMessageDialog(this, mensaje, "INFORMACI�N", JOptionPane.INFORMATION_MESSAGE);
				
				//desactivamos bot�n de registro de mascota
				btnRegistrarAnimal.setEnabled(false);
			}
			
			else {
				String mensaje = "�Debes rellenar todos los campos!";
				JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		
		if(e.getSource().equals(btnCancelarMascota)) {
			
			String mensaje = "�Quieres cancelar el registro?";
			
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			
			if(opc == JOptionPane.YES_OPTION) {
				limpiarFormularioMascota();
			}
		}
		
		// buttons tienda------------------------------------------------------------------------------------------------------------------------------------------
		
		if(e.getSource().equals(btnGatos)) {
			String animal = "gato";
			try {
				crearTablaArticulos(animal);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		if(e.getSource().equals(btnPerros)) {
			String animal = "perro";
			try {
				crearTablaArticulos(animal);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(btnOtros)) {
			String animal = "otro";
			try {
				crearTablaArticulos(animal);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		// buttons paneles de registro---------------------------------------------------------------------------------------------------------------------------------
		
		if(e.getSource().equals(btnBuscar)) {
			
			String dniBuscado = textDniBuscar.getText();
			
			try {
				Cliente clienteBuscado = manager.getCliente(dniBuscado);
				if(clienteBuscado !=null) {
				//	mostrarResultadoBusqueda(clienteBuscado);
				}
				else {
					String mensaje = "No se ha encontrado ning�n cliente con ese DNI";
					
					JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
					
				}
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
		}
		if(e.getSource().equals(btnEditarRegistro)){
			
		}
		
	}
}

