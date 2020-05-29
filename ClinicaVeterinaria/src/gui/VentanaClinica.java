package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JCalendar;
import clases.Cita;
import clases.Cliente;
import clases.Mascota;
import clases.Personal;
import control.Manager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
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
	
	// atributos del panel de área personal cliente---------------
	private JComboBox <String> listaMascotas;
	private JCalendar calendar;
	private JComboBox<String> cmbHora;
	private JComboBox<String> cmbMinutos;
	private JTextPane textDatosCita;
	private JButton btnValidarCita;
	private JButton btnBorrarDatosCita;
	private JButton btnVerDatos;
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
	
	// atributos trabajadores-------------------------------------
	private JPanel personal;
	private JLabel lblTrabajador;
	private JTextField textCargo;
	private JTextField textEspecialidad;
	private JButton btnAltaMascotas;
	private JButton btnAltaClientes;
	private JButton btnRellenarCita;
	private JButton btnCerrarSesionPersonal;
	private JSeparator separator;
	
	//----------------alta de cliente-------------
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
	
	//----------------alta de mascota-------------
	private JLabel lblDatosRegistroMascota;
	private JLabel lblDniPropietario;
	private JTextField textaltaDniPropietario;
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
	
	//-----panel registro clientes---------------
	private JPanel registro;
	private JTable tablaClientes;
	private JTable tablaRegistroMascotas;
	private JTextField textDniBuscar;
	private JButton btnBuscar;
	private JButton btnBuscarMascota;
	private JLabel lblResultado;
	private JButton btnEliminarCliente;
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
	
	//-----panel registro mascotas-------------------------------------
	private JPanel registroMascotas;
	private JTextField textDniPropietario;
	private JLabel lblNombreMascotaBuscada;
	private JTextField textNombreMascotaB;
	private JLabel lblEspecieBuscada;
	private JTextField textEspecieBuscada;
	private JLabel lblRazaBuscada;
	private JTextField textRazaBuscada;
	private JLabel lblSexoBuscado;
	private JTextField textSexoBuscado;
	private JLabel lblFechaBuscada;
	private JTextField textFechaBuscada;
	private JLabel lblbuscarDni;
	private JLabel lblBuscarNombre;
	private JCheckBox chckbxCastradoBuscado ;
	
	//-------------------------------------------
	private JLabel lblAnotaciones;
	private JButton btnAnotaciones;
	private JButton btnBorrarAnotacion;
	private JScrollPane scrollPane_1;
	private JTable tablaCitas;
	private JTextField textField;
	private JTextField textCodigo;
	private JTextField textMascotaBuscada;
	private JTextField textIdMascota;
	
	
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
				crearPanelCita(dniUsuario);
			break;
		}
		
	}

	//------------MÉTODOS PARA CREAR LOS PANELES--------------------------------------------------------------------------------------------------//
	
	private void crearPanelPersonal(String dniUsuario) {
		/// Panel ficha del personal-------------------------------------------------------------------------------------------------------------------
		 
		 personal = new JPanel();
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
		 btnAltaMascotas.setBackground(new Color(176, 224, 230));
		 btnAltaMascotas.setBounds(23, 483, 225, 44);
		 personal.add(btnAltaMascotas);
		 btnAltaMascotas.addActionListener(this);
		   
		 btnAltaClientes = new JButton("ALTA DE CLIENTE");
		 btnAltaClientes.setBackground(new Color(176, 224, 230));
		 btnAltaClientes.setBounds(23, 407, 225, 44);
		 personal.add(btnAltaClientes);
		 btnAltaClientes.addActionListener(this);
		   
		 btnCerrarSesionPersonal = new JButton("CERRAR SESI\u00D3N");
		 btnCerrarSesionPersonal.setForeground(Color.WHITE);
		 btnCerrarSesionPersonal.setBackground(new Color(205, 92, 92));
		 btnCerrarSesionPersonal.setBounds(23, 641, 225, 44);
		 personal.add(btnCerrarSesionPersonal);
		 btnCerrarSesionPersonal.addActionListener(this);
		 
		 btnRellenarCita = new JButton("RELLENAR CITA");
		 btnRellenarCita.setForeground(Color.BLACK);
		 btnRellenarCita.setBackground(new Color(176, 224, 230));
		 btnRellenarCita.setBounds(23, 563, 225, 44);
		 personal.add(btnRellenarCita);
		 btnRellenarCita.addActionListener(this);
		 	
		 JSeparator separator_1 = new JSeparator();
		 separator_1.setOrientation(SwingConstants.VERTICAL);
		 separator_1.setForeground(new Color(176, 224, 230));
		 separator_1.setBounds(275, 24, 1, 678);
		 personal.add(separator_1);
		 
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
		 
		lblAnotaciones = new JLabel("ANOTACIONES DE LA CONSULTA :");
		lblAnotaciones.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnotaciones.setBounds(357, 404, 240, 14);
		personal.add(lblAnotaciones);
		lblAnotaciones.setVisible(false);
					 
		textField = new JTextField();
		textField.setBounds(357, 429, 1012, 73);
		Border border = BorderFactory.createLineBorder(new Color(176, 224, 230));
		textField.setBorder(BorderFactory.createCompoundBorder(border, 
	               BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		personal.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
				 
		btnAnotaciones = new JButton("GUARDAR ANOTACIONES");
		btnAnotaciones.setForeground(Color.WHITE);
		btnAnotaciones.setBackground(new Color(143, 188, 143));
		btnAnotaciones.setBounds(357, 563, 330, 23);
		personal.add(btnAnotaciones);
		btnAnotaciones.setVisible(false);
		btnAnotaciones.addActionListener(this);
			
		btnBorrarAnotacion = new JButton("BORRAR ANOTACIONES");
		btnBorrarAnotacion.setForeground(Color.WHITE);
		btnBorrarAnotacion.setBackground(new Color(205, 92, 92));
		btnBorrarAnotacion.setBounds(1039, 563, 330, 23);
		personal.add(btnBorrarAnotacion);
		btnBorrarAnotacion.setVisible(false);
		btnBorrarAnotacion.addActionListener(this);
			 
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setBackground(Color.WHITE);
		textCodigo.setBounds(640, 402, 132, 20);
		personal.add(textCodigo);
		textCodigo.setVisible(false);
		textCodigo.setColumns(10);
		 
		
		// hacemos llamada a altaCliente(); y altaMascota(); función que se encarga de crear los diseños
		// le pasamos por parámetro un booleano a false para no mostrar la info si no le da al botón de Alta de cliente o Alta Mascota
		// le pasamos por parámetro el panel en el que ha de crear el diseño 
		crearTablaCitas(personal, false);
		altacliente(personal, false);
		altaMascota(personal, false);
		
	}
	
	private void crearTablaCitas(JPanel personal, boolean blnVisible) {
		
		
		lblAnotaciones.setVisible(blnVisible);
		textField.setVisible(blnVisible);
		btnAnotaciones.setVisible(blnVisible);
		btnBorrarAnotacion.setVisible(blnVisible);
		textCodigo.setVisible(blnVisible);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(357, 133, 1012, 225);
		personal.add(scrollPane_1);
		
		 
		 ArrayList <Cita> citas;
		 
		 try {
			
			citas=manager.getCitas();
			
				if(citas.size()>0) {
				
				String titulos[]= {"CODIGO","ID MASCOTA","NOMBRE","FECHA DE VISITA","HORA DE VISITA","DESCRIPCION"};
				String  fila[] []= new String[citas.size()] [titulos.length];
				tablaCitas = new JTable(fila, titulos);
				tablaCitas.setBackground(Color.WHITE);
				tablaCitas.setVisible(blnVisible);
				
				for(int i=0;i<citas.size();i++) {			
					fila[i][0]= Integer.toString(citas.get(i).getCodigo());
					fila[i][1]= Integer.toString(citas.get(i).getId_pet());
					fila[i][2]= citas.get(i).getNombreMascota();
					fila[i][3]= citas.get(i).getFechaVisita();
					fila[i][4]= citas.get(i).getHora();
					fila[i][5]= citas.get(i).getDescripcion();
				}
			}			
			
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
		
		 
		 tablaCitas.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent e) 
			      {
			         int filaSeleccionada = tablaCitas.rowAtPoint(e.getPoint());
			         if ((filaSeleccionada > -1)) {
			        	 textCodigo.setText(tablaCitas.getValueAt(filaSeleccionada, 0).toString());
			         }
			   }
		  });
		 
		 tablaCitas.setEnabled(false);
		 tablaCitas.setVisible(blnVisible);
		 scrollPane_1.setViewportView(tablaCitas);
		 scrollPane_1.setVisible(blnVisible);
		 
	}

	private void crearPanelAreaCliente(String dniUsuario) throws Exception {
		// Panel Ficha------------------------------------------------------------------------------------------------------------------------------------------------------
		 JPanel ficha = new JPanel();
		 ficha.setBackground(Color.WHITE);
		 panelPestanas.addTab("Área personal", null, ficha, null);
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
		   
		 btnCerrarSesionCliente = new JButton("CERRAR SESI\u00D3N");
		 btnCerrarSesionCliente.setForeground(Color.WHITE);
		 btnCerrarSesionCliente.setBackground(new Color(205, 92, 92));
		 btnCerrarSesionCliente.setBounds(23, 585, 225, 44);
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
		 
		 //método que carga la interfaz de las mascotas
	     datosMascota(ficha, false, dniUsuario);	
	}
	
	private void crearPanelCita(String dniUsuario) throws Exception{
				
		 JPanel Cita = new JPanel();
		 Cita.setBackground(Color.WHITE);
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
		 listaMascotas = new JComboBox<String>();
		 listaMascotas.setForeground(Color.BLACK);
		 listaMascotas.setBackground(Color.WHITE);
		 listaMascotas.setBounds(239, 81, 173, 27);
		 Cita.add(listaMascotas);
		 
		 ArrayList <Mascota> mascotas = manager.getMascotasCliente(dniUsuario);
		 
		 for(int i=0; i< mascotas.size();i++) {
			 listaMascotas.addItem(mascotas.get(i).getNombre());
		 }
		 
		 listaMascotas.setSelectedIndex(-1); //indicamos que no esté marcada ninguna por defecto
		 
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
		 // Color del numero de día 
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
		 cmbHora = new JComboBox<String>();
		 cmbHora.setModel(new DefaultComboBoxModel<String>(new String[] {"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21"}));
		 cmbHora.setBounds(71, 594, 70, 22);
		 Cita.add(cmbHora);
		 
		 //combo para seleccionar los minutos
		 cmbMinutos = new JComboBox<String>();
		 cmbMinutos.setModel(new DefaultComboBoxModel<String>(new String[] {"00", "15", "30", "45"}));
		 cmbMinutos.setBounds(141, 594, 70, 22);
		 Cita.add(cmbMinutos);
		 
		 JLabel lblDatosCita = new JLabel("DATOS DE LA CITA : ");
		 lblDatosCita.setFont(new Font("Tahoma", Font.BOLD, 11));
		 lblDatosCita.setBounds(815, 49, 331, 14);
		 Cita.add(lblDatosCita);
		 
		 textDatosCita = new JTextPane();
		 textDatosCita.setBounds(815, 74, 563, 213);
		 Border border = BorderFactory.createLineBorder(new Color(176, 224, 230));
		 textDatosCita.setBorder(BorderFactory.createCompoundBorder(border, 
	               BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		 Cita.add(textDatosCita);
		 
		 btnValidarCita = new JButton("Validar");
		 btnValidarCita.setForeground(Color.WHITE);
		 btnValidarCita.setBackground(new Color(143, 188, 143));
		 btnValidarCita.setBounds(1039, 298, 113, 35);
		 Cita.add(btnValidarCita);
		 btnValidarCita.addActionListener(this);
		 
		 btnBorrarDatosCita = new JButton("Borrar datos");
		 btnBorrarDatosCita.setForeground(Color.WHITE);
		 btnBorrarDatosCita.setBackground(new Color(205, 92, 92));
		 btnBorrarDatosCita.setBounds(1265, 298, 113, 35);
		 Cita.add(btnBorrarDatosCita);
		 btnBorrarDatosCita.addActionListener(this);
		 
		 btnVerDatos = new JButton("Ver datos");
		 btnVerDatos.setBackground(new Color(176, 224, 230));
		 btnVerDatos.setBounds(815, 298, 113, 35);
		 Cita.add(btnVerDatos);
		 btnVerDatos.addActionListener(this);
	}

	private void crearPanelRegistroClientes() throws Exception{
			
		registro = new JPanel();
		registro.setBackground(Color.WHITE);
		panelPestanas.addTab("Registro de clientes", null, registro, null);
		registro.setLayout(null);
		
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
		
		btnEliminarCliente = new JButton("ELIMINAR CLIENTE");
		btnEliminarCliente.setForeground(Color.WHITE);
		btnEliminarCliente.setBackground(new Color(205, 92, 92));
		btnEliminarCliente.setBounds(693, 400, 199, 23);
		btnEliminarCliente.addActionListener(this);
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
		
		JScrollPane scrollPaneCliente = new JScrollPane();
		scrollPaneCliente.setBounds(58, 119, 1315, 160);
		registro.add(scrollPaneCliente);
		tablaClientes = new JTable();
		datosTablaClientes();
		scrollPaneCliente.setViewportView(tablaClientes);
		
		tablaClientes.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent e) 
			      {
			         int filaSeleccionada = tablaClientes.rowAtPoint(e.getPoint());
			         if ((filaSeleccionada > -1)) {
			        	textDniBuscar.setText(tablaClientes.getValueAt(filaSeleccionada, 0).toString());
			        	textNombreC.setText(tablaClientes.getValueAt(filaSeleccionada, 1).toString());
			        	textPrimerApellidoC.setText(tablaClientes.getValueAt(filaSeleccionada, 2).toString());
			        	textSegundoApellido.setText(tablaClientes.getValueAt(filaSeleccionada, 3).toString());
			        	textDireccBuscada.setText(tablaClientes.getValueAt(filaSeleccionada, 4).toString());
			        	textLocalidadBuscada.setText(tablaClientes.getValueAt(filaSeleccionada, 5).toString());
				 		textTelfBusc1.setText(tablaClientes.getValueAt(filaSeleccionada, 6).toString());
				 		textTelfBusc2.setText(tablaClientes.getValueAt(filaSeleccionada, 7).toString());
			         }
			   }
		  });
				
		limpiarFormularioRegistro();
		
	}
	
	// método que carga los datos de la tabla del registro de clientes
	private void datosTablaClientes() {
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		tablaClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
		try {
			clientes = manager.getClientes();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
				
		String titulos[]= new String[] {"DNI","NOMBRE","PRIMER APELLIDO","SEGUNDO APELLIDO","DIRECCION","LOCALIDAD","TELÉFONO", "TELÉFONO SECUNDARIO"};
		
		DefaultTableModel dtm = new DefaultTableModel(titulos, 0) {
			/**
			 * version serial Para que no se puedan editar las celdas
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (int i = 0; i < clientes.size(); i++) {
			dtm.addRow(new Object[] { clientes.get(i).getDni(),clientes.get(i).getNombre(), clientes.get(i).getApellido1(),
					clientes.get(i).getApellido2(), clientes.get(i).getDireccion(),
					clientes.get(i).getLocalidad(), clientes.get(i).getTelefono1(),clientes.get(i).getTelefono1()
					
			});
		}
	
		tablaClientes.setModel(dtm);
}

	private void crearPanelRegistroMascotas() throws Exception{
		
		registroMascotas = new JPanel();
		registroMascotas.setBackground(Color.WHITE);
		panelPestanas.addTab("Registro de mascotas", null, registroMascotas, null);
		registroMascotas.setLayout(null);
		 
		JLabel lblBuscador = new JLabel("BUSCADOR : ");
		lblBuscador.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBuscador.setBounds(58, 27, 545, 14);
		registroMascotas.add(lblBuscador);
		
		textDniPropietario = new JTextField();
		textDniPropietario.setToolTipText("introduce el DNI o NIE");
		textDniPropietario.setBounds(242, 46, 187, 20);
		registroMascotas.add(textDniPropietario);
		textDniPropietario.setColumns(10);
		textDniPropietario.setText("");
		
		
		lblbuscarDni = new JLabel("DNI del propietario/a :");
		lblbuscarDni.setBounds(58, 52, 181, 14);
		registroMascotas.add(lblbuscarDni);
		
		lblBuscarNombre = new JLabel("Nombre de la mascota :");
		lblBuscarNombre.setBounds(58, 80, 181, 14);
		registroMascotas.add(lblBuscarNombre);
		
		textMascotaBuscada = new JTextField();
		textMascotaBuscada.setBounds(242, 77, 187, 20);
		registroMascotas.add(textMascotaBuscada);
		textMascotaBuscada.setColumns(10);
		
		ImageIcon lupa = new ImageIcon ("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\lupa.png");
		btnBuscarMascota = new JButton("");
		btnBuscarMascota.setBounds(439, 52, 32, 27);
		Icon iconoLupa = new ImageIcon(lupa.getImage().getScaledInstance(btnBuscarMascota.getWidth(), btnBuscarMascota.getHeight(), Image.SCALE_DEFAULT));
		btnBuscarMascota.setIcon(iconoLupa);
		btnBuscarMascota.addActionListener(this);
		registroMascotas.add(btnBuscarMascota);
		
		// resultado de la búsqueda----------------------------------------------
		lblResultado = new JLabel("RESULTADO DE LA B\u00DASQUEDA :");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblResultado.setBounds(58, 362, 767, 14);
		registroMascotas.add(lblResultado);
		
		lblNombreMascotaBuscada = new JLabel("Nombre :");
		lblNombreMascotaBuscada.setBackground(Color.WHITE);
		lblNombreMascotaBuscada.setBounds(58, 387, 114, 14);
		registroMascotas.add(lblNombreMascotaBuscada);
		
		textNombreMascotaB = new JTextField();
		textNombreMascotaB.setBackground(Color.WHITE);
		textNombreMascotaB.setBounds(58, 401, 562, 20);
		registroMascotas.add(textNombreMascotaB);
		textNombreMascotaB.setColumns(10);
		
		lblEspecieBuscada = new JLabel("Especie :");
		lblEspecieBuscada.setBackground(Color.WHITE);
		lblEspecieBuscada.setBounds(58, 440, 187, 14);
		registroMascotas.add(lblEspecieBuscada);
		
		textEspecieBuscada = new JTextField();
		textEspecieBuscada.setBackground(Color.WHITE);
		textEspecieBuscada.setColumns(10);
		textEspecieBuscada.setBounds(58, 456, 562, 20);
		registroMascotas.add(textEspecieBuscada);
		
		lblRazaBuscada = new JLabel("Raza :");
		lblRazaBuscada.setBackground(Color.WHITE);
		lblRazaBuscada.setBounds(58, 493, 187, 14);
		registroMascotas.add(lblRazaBuscada);
			
		textRazaBuscada = new JTextField();
		textRazaBuscada.setBackground(Color.WHITE);
		textRazaBuscada.setColumns(10);
		textRazaBuscada.setBounds(58, 509, 562, 20);
		registroMascotas.add(textRazaBuscada);		
		
		lblSexoBuscado = new JLabel("Sexo :");
		lblSexoBuscado.setBackground(Color.WHITE);
		lblSexoBuscado.setBounds(58, 545, 562, 14);
		registroMascotas.add(lblSexoBuscado);		
		
		textSexoBuscado = new JTextField();
		textSexoBuscado.setColumns(10);
		textSexoBuscado.setBackground(Color.WHITE);
		textSexoBuscado.setBounds(58, 560, 562, 20);
		registroMascotas.add(textSexoBuscado);		
		
		lblFechaBuscada = new JLabel("Fecha de Nacimiento : :");
		lblFechaBuscada.setBackground(Color.WHITE);
		lblFechaBuscada.setBounds(58, 594, 562, 14);
		registroMascotas.add(lblFechaBuscada);	
		
		textFechaBuscada = new JTextField();
		textFechaBuscada.setColumns(10);
		textFechaBuscada.setBackground(Color.WHITE);
		textFechaBuscada.setBounds(58, 608, 562, 20);
		registroMascotas.add(textFechaBuscada);		
		
		chckbxCastradoBuscado = new JCheckBox("Castrado");
		chckbxCastradoBuscado.setBackground(Color.WHITE);
		chckbxCastradoBuscado.setBounds(58, 651, 97, 23);
		registroMascotas.add(chckbxCastradoBuscado);		
		
		btnEditarRegistroMascota = new JButton("EDITAR DATOS");
		btnEditarRegistroMascota.setForeground(Color.WHITE);
		btnEditarRegistroMascota.setBackground(new Color(143, 188, 143));
		btnEditarRegistroMascota.setBounds(675, 400, 199, 23);
		registroMascotas.add(btnEditarRegistroMascota);
		btnEditarRegistroMascota.addActionListener(this);
		
		btnEliminarMascota = new JButton("ELIMINAR MASCOTA");
		btnEliminarMascota.setForeground(Color.WHITE);
		btnEliminarMascota.setBackground(new Color(205, 92, 92));
		btnEliminarMascota.setBounds(675, 455, 199, 23);
		registroMascotas.add(btnEliminarMascota);
		btnEliminarMascota.addActionListener(this);
		
		JLabel lblIdMascota = new JLabel("ID : ");
		lblIdMascota.setBounds(489, 655, 46, 14);
		registroMascotas.add(lblIdMascota);
		
		textIdMascota = new JTextField();
		textIdMascota.setHorizontalAlignment(SwingConstants.CENTER);
		textIdMascota.setBackground(Color.WHITE);
		textIdMascota.setEditable(false);
		textIdMascota.setBounds(534, 652, 86, 20);
		registroMascotas.add(textIdMascota);
		textIdMascota.setColumns(10);
		
		JScrollPane scrollPaneRegistroMascotas = new JScrollPane();
		scrollPaneRegistroMascotas.setBounds(58, 119, 1315, 160);
		registroMascotas.add(scrollPaneRegistroMascotas);
		
		tablaRegistroMascotas = new JTable();
		datosTablasRegistroMascotas();
		tablaRegistroMascotas.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
		tablaRegistroMascotas.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent e) 
			      {
			         int filaSeleccionada = tablaRegistroMascotas.rowAtPoint(e.getPoint());
			         if (filaSeleccionada > -1) {
			        	textIdMascota.setText(tablaRegistroMascotas.getValueAt(filaSeleccionada, 0).toString());
			        	textDniPropietario.setText(tablaRegistroMascotas.getValueAt(filaSeleccionada, 1).toString());
			        	textMascotaBuscada.setText(tablaRegistroMascotas.getValueAt(filaSeleccionada, 2).toString());
			        	textNombreMascotaB.setText(tablaRegistroMascotas.getValueAt(filaSeleccionada, 2).toString());
			        	textEspecieBuscada.setText(tablaRegistroMascotas.getValueAt(filaSeleccionada, 3).toString());
			        	textRazaBuscada.setText(tablaRegistroMascotas.getValueAt(filaSeleccionada, 4).toString());
			        	textSexoBuscado.setText(tablaRegistroMascotas.getValueAt(filaSeleccionada, 5).toString());
			        	textFechaBuscada.setText(tablaRegistroMascotas.getValueAt(filaSeleccionada, 6).toString());
			        	if(tablaRegistroMascotas.getValueAt(filaSeleccionada, 7).toString().equalsIgnoreCase("SI")) {
			        		chckbxCastradoBuscado.setSelected(true);
			        		chckbxCastradoBuscado.setEnabled(false);
				 		}
				 		else {
				 			chckbxCastradoBuscado.setSelected(false);
				 			chckbxCastradoBuscado.setEnabled(true);
				 		}
				 		
			         }
			   }
		  });
		
		scrollPaneRegistroMascotas.setViewportView(tablaRegistroMascotas);
		
		limpiarFormularioRegistroMascotas();		
	}
	
	// método que carga los datos de la tabla del registro de mascotas
	private void datosTablasRegistroMascotas() {
		
		ArrayList<Mascota> mascotas = new ArrayList <Mascota>();
			
		try {
			mascotas = manager.getRegistroMascotas();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		String titulos[]= new String[] {"ID MASCOTA","DNI PROPIETARIO","NOMBRE","ESPECIE","RAZA","SEXO","FECHA DE NACIMIENTO", "CASTRADO"};
		
		DefaultTableModel dtm = new DefaultTableModel(titulos, 0) {
			/**
			 * version serial Para que no se puedan editar las celdas
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (int i = 0; i < mascotas.size(); i++) {
			dtm.addRow(new Object[] { Integer.toString(mascotas.get(i).getId()),mascotas.get(i).getPropietario(), mascotas.get(i).getNombre(),
					mascotas.get(i).getEspecie(), mascotas.get(i).getRaza(),
					mascotas.get(i).getSexo(), mascotas.get(i).getFechaNacimiento(),mascotas.get(i).esCastrado()

			});
		}
		
		tablaRegistroMascotas.setModel(dtm);
	}

	private void limpiarFormularioRegistroMascotas() {
		textIdMascota.setText("");
		textDniPropietario.setText("");
		textMascotaBuscada.setText("");
		textNombreMascotaB.setText("");
		textEspecieBuscada.setText("");
		textRazaBuscada.setText("");
		textSexoBuscado.setText("");
		textFechaBuscada.setText("");
		chckbxCastradoBuscado.setSelected(false);
	}
	
	//----------MÉTODOS DEL ÁREA DE PERSONAL------------------------------------------------------------------------------------------------------//
	
	

	//método que crea los componentes del alta de mascota
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
		lblDniPropietario = new JLabel("DNI del propietario/a :");
		lblDniPropietario.setBounds(565, 88, 513, 14);
		lblDniPropietario.setVisible(blnVisible);
		personal.add(lblDniPropietario);		
		
		textaltaDniPropietario = new JTextField();
		textaltaDniPropietario.setBackground(Color.WHITE);
		textaltaDniPropietario.setBounds(565, 103, 513, 20);
		textaltaDniPropietario.setVisible(blnVisible);
		personal.add(textaltaDniPropietario);
		textaltaDniPropietario.setColumns(10);
		 
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
		btnRegistrarAnimal.setForeground(Color.WHITE);
		btnRegistrarAnimal.setBackground(new Color(143, 188, 143));
		btnRegistrarAnimal.setBounds(565, 511, 121, 23);
		btnRegistrarAnimal.setVisible(blnVisible);
		personal.add(btnRegistrarAnimal);
		btnRegistrarAnimal.addActionListener(this);
		 
		btnCancelarMascota = new JButton("CANCELAR");
		btnCancelarMascota.setForeground(Color.WHITE);
		btnCancelarMascota.setBackground(new Color(205, 92, 92));
		btnCancelarMascota.setBounds(957, 511, 121, 23);
		btnCancelarMascota.setVisible(blnVisible);
		personal.add(btnCancelarMascota);
		btnCancelarMascota.addActionListener(this);
		
		limpiarFormularioMascota();
	}

	//método que crea los componentes del alta de mascota
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
		btnRegistrarCliente.setForeground(Color.WHITE);
		btnRegistrarCliente.setBackground(new Color(143, 188, 143));
		btnRegistrarCliente.setBounds(565, 584, 121, 23);
		btnRegistrarCliente.setVisible(blnVisible);
		personal.add(btnRegistrarCliente);
		btnRegistrarCliente.addActionListener(this);
		 
		btnCrearUsuario = new JButton("GENERAR USUARIO");
		btnCrearUsuario.setBackground(new Color(176, 224, 230));
		btnCrearUsuario.setBounds(736, 584, 179, 23);
		btnCrearUsuario.setVisible(blnVisible);
		btnCrearUsuario.setEnabled(false);  // hasta que no registre al cliente no se activa la posibilidad de crear usuario
		personal.add(btnCrearUsuario);
		btnCrearUsuario.addActionListener(this);
		 
		btnCancelarCliente = new JButton("CANCELAR");
		btnCancelarCliente.setForeground(Color.WHITE);
		btnCancelarCliente.setBackground(new Color(205, 92, 92));
		btnCancelarCliente.setBounds(957, 584, 121, 23);
		btnCancelarCliente.setVisible(blnVisible);
		personal.add(btnCancelarCliente);
		btnCancelarCliente.addActionListener(this);
		
		btnRegistraMascota = new JButton(" DAR DE ALTA UNA MASCOTA ");
		btnRegistraMascota.setBackground(new Color(176, 224, 230));
		btnRegistraMascota.setBounds(565, 637, 513, 23);
		btnRegistraMascota.setVisible(blnVisible);
		btnRegistraMascota.setEnabled(false); // hasta que no registre al cliente no se activa la posibilidad de registrar una mascota
		personal.add(btnRegistraMascota);
		btnRegistraMascota.addActionListener(this);
		
		limpiarFormularioCliente();
	}

	// método que limpia el formulario de la mascota
	private void limpiarFormularioMascota() {
	//	textaltaDni.setText("");
		textAltaNombreMascota.setText("");
		textEspecieMascota.setText("");
		textRazaMascota.setText("");
		textFechaNaciMascota.setText("");
		textSexoMascota.setText("");
		chckbxEsterilizadoAlta.setSelected(false);
		
		// no permitimos que le de al botón de registrar Mascota
		btnRegistrarAnimal.setEnabled(false);
		
	}

	// método que habilita o inhabilita los textArea del alta de mascotas
	private void activarTextAreaMascota(boolean b) {
		textAltaNombreMascota.setEditable(b);
		textEspecieMascota.setEditable(b);
		textRazaMascota.setEditable(b);
		textFechaNaciMascota.setEditable(b);
		textSexoMascota.setEditable(b);
		chckbxEsterilizadoAlta.setEnabled(b);
	}
	
	//método que comprueba que todos los campos estén completados	
	private boolean comprobarCamposCliente() {
		String mensaje = "";
		
		textaltaDni.getText().toUpperCase();
		
		if(Character.isLetter(textaltaDni.getText().charAt(0))) {
			if(!validarNie(textaltaDni.getText()))  {
				mensaje ="¡DNI o NIE incorrecto!";
			} 
		}
		else if (Character.isDigit(textaltaDni.getText().charAt(0))){
			if(!validarDni(textaltaDni.getText()))  {
				mensaje ="¡DNI o NIE incorrecto!";
			} 
		}
		
		if(isNumeric(textAltaNombre.getText())) {
			mensaje= mensaje + "\n"+"El nombre no puede contener números";
		}
		if (textAltaNombre.getText().isBlank()){
			mensaje= mensaje + "\n"+"El nombre no puede estar vacío";
		}
		if(isNumeric(textAltaApell1.getText())) {
			mensaje= mensaje + "\n"+"El primer apellido no puede contener números";
		}
		if(textAltaApell1.getText().isBlank()) {
			mensaje= mensaje + "\n"+"El primer apellido no puede estar vacío";
		}
		if(isNumeric(textAltaApell2.getText())) {
			mensaje= mensaje + "\n"+"El segundo apellido no puede contener números";
		}
		if (textAltaApell2.getText().isBlank()){
			mensaje= mensaje + "\n"+"El segundo apellido no puede estar vacío";
		}
		if(isNumeric(textAltaDirec.getText())) {
			mensaje= mensaje + "\n"+"La dirección no puede contener números";
		}
		if(textAltaDirec.getText().isBlank()) {
			mensaje= mensaje + "\n"+"La dirección no puede estar vacía";
		}
		if(isNumeric(textAltaLocal.getText())){
			mensaje= mensaje + "\n"+"La localidad no puede contener números";
		}	
		if(textAltaLocal.getText().isBlank() ) {
			mensaje= mensaje + "\n"+"La localidad no puede estar vacía";
		}
		if(!isNumeric(textAltaTelef1.getText())) {
			mensaje= mensaje + "\n"+"El teléfono solo debe contener números";
		}
		if(textAltaTelef1.getText().isBlank()) {
			mensaje= mensaje + "\n"+"El teléfono principal no puede estar vacío";
		}
		
		if(!textAltaTelef2.getText().isBlank() && !isNumeric(textAltaTelef2.getText())) {
			mensaje= mensaje + "\n"+"El teléfono secundario solo debe contener números";
		}
		
		if(!mensaje.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			return true;
		}	
		
	}

	// método que valida el DNI
	private boolean validarDni(String dni) {
		
		return dni.matches("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$");
	}

	// método que valida el NIE
	public static boolean validarNie(String nie) {
		
		return nie.matches("^[X|T|Y|Z]{1}[0-9]{7}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]{1}$");
	}
	
	//método que comprueba que todos los campos estén correctos y completos	
	private boolean comprobarCamposMascota() {
		
		String mensaje = "";
		
		if(isNumeric(textAltaNombreMascota.getText())) {
			mensaje= mensaje+"El nombre no puede contener números";
		}
		if(textAltaNombreMascota.getText().isBlank()) {
			mensaje= mensaje + "El nombre no puede estar vacío";
		}
		if(isNumeric(textEspecieMascota.getText())) {
			mensaje= mensaje+"La especie no puede contener números";
		}
		if(textEspecieMascota.getText().isBlank()) {
			mensaje= mensaje + "La especie no puede estar vacía";
		}
		if(isNumeric(textRazaMascota.getText())) {
			mensaje= mensaje+"La raza no puede contener números";
		}
		if(textRazaMascota.getText().isBlank()) {
			mensaje= mensaje + "La raza no puede estar vacía";
		}
		if(!validarFecha(textFechaNaciMascota.getText())) {
			mensaje= mensaje+"La fecha debe tener formato (yyyy-MM-dd) y/o no puede contener letras";
		}
		if(textFechaNaciMascota.getText().isBlank()) {
			mensaje= mensaje + "La fecha no puede estar vacía";
		}
		if(isNumeric(textSexoMascota.getText())) {
			mensaje= mensaje+"El sexo no puede contener números";
		}
		if(textSexoMascota.getText().isBlank()) {
			mensaje= mensaje+"El sexo no puede estar vacío";
		}
		
		if(!mensaje.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			return true;
		}	
	}
	
	// método que valida el formato de la fecha
	private static boolean validarFecha(String fecha) {
		
		return fecha.matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$");
	}

	//método que recoge el contenido del textArea del alta de mascota	
	private void recogerDatosMascota(String dniPropietario) {
		Mascota nuevaM = new Mascota();
		
		try {
			
			nuevaM.setPropietario(dniPropietario);
			nuevaM.setNombre(textAltaNombreMascota.getText().trim());
			nuevaM.setEspecie(textEspecieMascota.getText().trim());
			nuevaM.setRaza(textRazaMascota.getText());
			nuevaM.setFechaNacimiento(textFechaNaciMascota.getText().trim());
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
			datosTablasRegistroMascotas();			
			
		}catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		
	}

	// método que limpia los campos	del formulario del alta de cliente
	private void limpiarFormularioCliente() {
		textaltaDni.setText("");
		textAltaNombre.setText("");
		textAltaApell1.setText("");
		textAltaApell2.setText("");
		textAltaTelef1.setText("");
		textAltaTelef2.setText("");
		textAltaDirec.setText("");
		textAltaLocal.setText("");
		
		//no permitimos que le de al botón de crear usuario
		//btnCrearUsuario.setEnabled(false);
	}
	
	// método que limpia el formulario de la pestaña de registro de clientes 
	private void limpiarFormularioRegistro() {
		
		textNombreC.setText("");
		textPrimerApellidoC.setText("");
		textSegundoApellido.setText("");
		textDireccBuscada.setText("");
		textLocalidadBuscada.setText("");
		textTelfBusc1.setText("");
		textTelfBusc2.setText("");
	}

	// método que crea la clave del cliente	
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

	// método que recoge los datos del nuevo cliente
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
		
			datosTablaClientes();
			
		
		}
		catch (Exception e1) {
			e1.getMessage();
		}
		
	}

	// método que habilita o inhabilita los textArea del alta de cliente
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

	// método que muestra el área del alta de mascota
	private void mostrarAltaMascota(boolean blnVisible) {
		limpiarFormularioMascota();
		// cabecera-------------------------------------------------
		lblDatosRegistroMascota.setVisible(blnVisible);
		separator.setVisible(blnVisible);
		
		activarTextAreaMascota(true);
		// datos a rellenar ----------------------------------------
		lblDniPropietario.setVisible(blnVisible);
		textaltaDniPropietario.setVisible(blnVisible);
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
		textaltaDniPropietario.setBackground(new Color(245,255,250));
		textAltaNombreMascota.setBackground(new Color(245,255,250));
		textEspecieMascota.setBackground(new Color(245,255,250));
		textRazaMascota.setBackground(new Color(245,255,250));
		textFechaNaciMascota.setBackground(new Color(245,255,250));
		textSexoMascota.setBackground(new Color(245,255,250));
		
	}

	// método que muestra el área del alta de cliente
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
	
	// método que recoge los datos de la mascota para poder realizar la insert
	private Mascota guardarDatosMascota() {
		Mascota m = new Mascota();
		m.setId(Integer.parseInt(textIdMascota.getText()));
		m.setPropietario(textDniBuscar.getText());
		m.setNombre(textNombreMascotaB.getText());
		m.setEspecie(textEspecieBuscada.getText());
		m.setRaza(textRazaBuscada.getText());
		m.setSexo(textSexoBuscado.getText());
		m.setFechaNacimiento(textFechaBuscada.getText().trim());
		m.setBlnCastrado(chckbxCastradoBuscado.isSelected());
		
		return m;
	}
	
	// método que muestra los componenes de las citas
	private void mostrarDatosCitas(boolean blnVisible) {
		lblAnotaciones.setVisible(blnVisible);
		textField.setVisible(blnVisible);
		btnAnotaciones.setVisible(blnVisible);
		btnBorrarAnotacion.setVisible(blnVisible);
		textCodigo.setVisible(blnVisible);
		tablaCitas.setVisible(blnVisible);
		scrollPane_1.setVisible(blnVisible);
	}
	
	//----------MÉTODOS DEL ÁREA DE CLIENTE----------------------------------------------------------------------------------------------------//
	
	// método que crea los componentes de las mascotas en el área del cliente
	public void datosMascota(JPanel ficha, boolean blnVisible, String dniCliente) throws Exception {
		 lblDatosMascota = new JLabel("DATOS DE LA MASCOTA");
		 lblDatosMascota.setBackground(Color.WHITE);
		 lblDatosMascota.setHorizontalAlignment(SwingConstants.CENTER);
		 lblDatosMascota.setFont(new Font("Tahoma", Font.BOLD, 14));
		 lblDatosMascota.setBounds(755, 384, 486, 14);
		 lblDatosMascota.setVisible(blnVisible);
		 ficha.add(lblDatosMascota);
		 
		 separatorMascotas = new JSeparator();
		 separatorMascotas.setForeground(new Color(176, 224, 230));
		 separatorMascotas.setBounds(308, 341, 1097, 2);
		 separatorMascotas.setVisible(blnVisible);
		 ficha.add(separatorMascotas);
			
			
		lblDatosMascota.setVisible(blnVisible);
		separatorMascotas.setVisible(blnVisible);
		
		ImageIcon fotoMascota = new ImageIcon("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\mascotas\\huella.png");
		lblFotoMascota1 = new JLabel("");
		lblFotoMascota1.setBounds(379, 402, 259, 209);
		Icon mascota = new ImageIcon(fotoMascota.getImage().getScaledInstance(lblFotoMascota1.getWidth(), lblFotoMascota1.getHeight(), Image.SCALE_DEFAULT));
		lblFotoMascota1.setIcon(mascota);
		lblFotoMascota1.setVisible(blnVisible);
		ficha.add(lblFotoMascota1);
		   
		   
		lblNombreMascota = new JLabel("Nombre: ");
		lblNombreMascota.setBounds(755, 437, 180, 14);
		lblNombreMascota.setVisible(blnVisible);
		ficha.add(lblNombreMascota);
		
		textNombreMascota = new JTextField();
		textNombreMascota.setBackground(Color.WHITE);
		textNombreMascota.setEditable(false);
		textNombreMascota.setBounds(755, 452, 180, 20);
		textNombreMascota.setColumns(10);
		textNombreMascota.setVisible(blnVisible);
		ficha.add(textNombreMascota);
		
		lblEspecie = new JLabel("Especie: ");
		lblEspecie.setBounds(1061, 437, 180, 14);
		lblEspecie.setVisible(blnVisible);
		ficha.add(lblEspecie);
		
		textEspecie = new JTextField();
		textEspecie.setBackground(Color.WHITE);
		textEspecie.setEditable(false);
		textEspecie.setBounds(1061, 452, 180, 20);
		textEspecie.setColumns(10);
		textEspecie.setVisible(blnVisible);
		ficha.add(textEspecie);
		
		lblRaza = new JLabel("Raza :");
		lblRaza.setBounds(1061, 491, 180, 14);
		lblRaza.setVisible(blnVisible);
		ficha.add(lblRaza);
		
		textRaza = new JTextField();
		textRaza.setBackground(Color.WHITE);
		textRaza.setEditable(false);
		textRaza.setBounds(1061, 504, 180, 20);
		textRaza.setColumns(10);
		textRaza.setVisible(blnVisible);
		ficha.add(textRaza);
		
		lblSexo = new JLabel("Sexo : ");
		lblSexo.setBounds(755, 545, 180, 14);
		lblSexo.setVisible(blnVisible);
		ficha.add(lblSexo);
		
		textSexo = new JTextField();
		textSexo.setBackground(Color.WHITE);
		textSexo.setEditable(false);
		textSexo.setBounds(755, 560, 180, 20);
		textSexo.setColumns(10);
		textSexo.setVisible(blnVisible);
		ficha.add(textSexo);
		
		lblFechaNaci = new JLabel("Fecha de nacimiento : ");
		lblFechaNaci.setBounds(755, 491, 180, 14);
		lblFechaNaci.setVisible(blnVisible);
		ficha.add(lblFechaNaci);
		
		textFechaNaci = new JTextField();
		textFechaNaci.setBackground(Color.WHITE);
		textFechaNaci.setBounds(755, 504, 180, 20);
		textFechaNaci.setColumns(10);
		textFechaNaci.setEditable(false);
		textFechaNaci.setVisible(blnVisible);
		ficha.add(textFechaNaci);
		
		chckbxEsterilizado = new JCheckBox("Esterilizado");
		chckbxEsterilizado.setBackground(Color.WHITE);
		chckbxEsterilizado.setBounds(1061, 559, 97, 23);
		chckbxEsterilizado.setVisible(blnVisible);
		ficha.add(chckbxEsterilizado);
		
		//TABLA DONDE APARECEN LOS NOMBRES DE LAS MASCOTAS QUE TIENE EL CLIENTE
		
		scrollPaneMascotas = new JScrollPane();
		scrollPaneMascotas.setBounds(340, 50, 1033, 229);
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
				fila[i][4]= mascotas.get(i).getFechaNacimiento();
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
	
	// método que muestra los datos del cliente
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
	
	// método que muestra las mascotas de un cliente
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

	// método que permite editar los datos
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
		
		btnAceptarCambios.setVisible(true);
		btnCancelarCambios.setVisible(true);
		
	}
	
	// método que comprueba que los cambios introducidos tienen formatos correctos
	private boolean comprobarCambios() {
		String mensaje = "";
		
		if(isNumeric(textDireccUser.getText())) {
			mensaje= mensaje + "\n"+"La dirección no puede contener números";
		}
		if(textDireccUser.getText().isBlank()) {
			mensaje= mensaje + "\n"+"La dirección no puede estar vacía";
		}
		if(isNumeric(textLocalidad.getText())){
			mensaje= mensaje + "\n"+"La localidad no puede contener números";
		}	
		if(textLocalidad.getText().isBlank() ) {
			mensaje= mensaje + "\n"+"La localidad no puede estar vacía";
		}
		if(!isNumeric(textTelefUser.getText())) {
			mensaje= mensaje + "\n"+"El teléfono solo debe contener números";
		}
		if(textTelefUser.getText().isBlank()) {
			mensaje= mensaje + "\n"+"El teléfono principal no puede estar vacío";
		}
		if(!textTelefUser2.getText().isBlank() && !isNumeric(textTelefUser2.getText())) {
			mensaje= mensaje + "\n"+"El teléfono secundario solo debe contener números";
		}
		if(!mensaje.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			return true;
		}	
		
	}
	
	// método para validar teléfonos y texto
	private boolean isNumeric(String cadena) {
		
		try {
			Integer.parseInt(cadena);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
		
		
	}

	// método que recoge los cambios que ha realizado
	
	// método que recoge los cambios que se han realizado
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
	
	// método para guardar los datos de la cita solicitada
	private Cita guardarDatosCita() {
		String nombre = (String)listaMascotas.getSelectedItem();
		String propietario = obtenerDni();
		
		Cita citaNueva= new Cita();
		
		try{
			
			String especie;
			Mascota mascota = manager.getMascota(propietario, nombre);
			if(mascota.getEspecie().equalsIgnoreCase("gato")) {
				 especie = "felina";
			 }
			 else {
				 especie = "canina";
			 }
			Personal veterinario= manager.getVeterinarioAsignado(especie);
			
			citaNueva.setId_pet(mascota.getId());
			citaNueva.setId_vet(veterinario.getId());
			citaNueva.setNombreMascota((String)listaMascotas.getSelectedItem());
			
			Format formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			String fechaCita =  formatter.format(calendar.getDate());
			
			citaNueva.setFechaVisita(fechaCita);
			citaNueva.setHora((String)cmbHora.getSelectedItem()+" "+(String)cmbMinutos.getSelectedItem());
			citaNueva.setDescripcion("");
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
				
		return citaNueva;
	}

	// método para obtener el DNI del usuario
	private String obtenerDni() {
		
		return textDniUser.getText();
	}
	
	
	//------------------ACTION LISTENERS-------------------------------------------------------------------------------------------------//
	
	@Override
	public void actionPerformed(ActionEvent e) {
			
		//buttons área personal usuario--------------------------------------------------------------------------------------------------
		
		// botón que permite editar algunos datos
		if(e.getSource().equals(btnEditar)) {
			mostrarMascota(false);
			mostrarDatosEditar(true);
		}
		
		//----butons editar-----------------------------------------------------------------------------------------
		
		// botón que guarda los cambios realizados
		if(e.getSource().equals(btnAceptarCambios)) {
			
			if(comprobarCambios()) {
					String mensaje = "¿Quieres guardar los cambios?";
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
		}
		
		// botón que recupera los cambios realizados
		if(e.getSource().equals(btnCancelarCambios)) {
			
			String mensaje = "¿Quieres cancelar los cambios?";
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			
			if(opc == JOptionPane.YES_OPTION) {
				datosCliente(textDniUser.getText());
				mostrarDatosEditar(false);
			}
			else {
				mostrarDatosEditar(true);
			}		
		}
		
		//botón que muestra las mascotas del cliente
		if(e.getSource().equals(btnMascotas)) {
			mostrarMascota(true);
		}
		
		// botón de cierre de sesión
		if(e.getSource().equals(btnCerrarSesionCliente)) {
			
			String mensaje = "¿Quieres cerrar la sesión?";
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			if(opc==JOptionPane.YES_OPTION) {
				dispose();
			}
		}
		
		//buttons pestaña citas------------------------------------------------------------------------------------------------------
		
		// botón para ver los datos de la petición de cita
		if(e.getSource().equals(btnVerDatos)) {
			String nombre = (String)listaMascotas.getSelectedItem();
			String dni = obtenerDni();
			SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
			String fecha = formato.format(calendar.getDate());
			
			try {
				String especie = manager.getEspecie(nombre, dni);
				if(especie.equalsIgnoreCase("gato")) {
					especie="felina";
				}
				else {
					especie="canina";
				}
				//obtenemos al vetenerinario correspondiente
				Personal veterinario= manager.getVeterinarioAsignado(especie);
				 String datos = "Nombre: "+nombre+"\n\n"
						 		+"Día de la cita: "+fecha+"\n\n"
						 		+"Hora: "+(String)cmbHora.getSelectedItem()+":"+(String)cmbMinutos.getSelectedItem()+"\n\n\n\n"
						 		+"Veterinario asignado: "+ veterinario.getNombre()+" "+veterinario.getApellido1()+" "+veterinario.getApellido2()+"\n"
						 		+"\nEspecialidad: "+veterinario.getEspecialidad();
				 
				 textDatosCita.setText(datos);
				
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// botón para guardar los datos de la cita
		if(e.getSource().equals(btnValidarCita)) {
			String mensaje = "¿Quieres validar la cita?";
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			
			if(opc == JOptionPane.YES_OPTION) {
			
				Cita cita = guardarDatosCita();
				
				try {
					
					manager.insertarCita(cita);
					JOptionPane.showMessageDialog(this, "Cita registrada correctamente", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
					btnValidarCita.setEnabled(false);
					btnVerDatos.setEnabled(false);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
			}	
		}
		
		// limpia el contenido del Text Area
		if(e.getSource().equals(btnBorrarDatosCita)) {
			
			textDatosCita.setText("");
		}
		
		
		// buttons pestaña personal--------------------------------------------------------------------------------------------------------------------------
		
		// activa los componentes del alta de clientes
		if(e.getSource().equals(btnAltaClientes)) {
			mostrarAltacliente(true);
			mostrarDatosCitas(false);
			mostrarAltaMascota(false);
			
			limpiarFormularioCliente();
			activarTextArea(true);
		}
		
		// activa los componentes del alta de mascotas
		if(e.getSource().equals(btnAltaMascotas)) {
			textaltaDniPropietario.setText("");
			textaltaDniPropietario.setEditable(true);	
			mostrarAltaMascota(true);
			mostrarDatosCitas(false);
			mostrarAltacliente(false);				
		}
		
		// activa los componentes de las citas
		if(e.getSource().equals(btnRellenarCita)) {
			mostrarAltaMascota(false);
			mostrarAltacliente(false);
			crearTablaCitas(personal, true);
		}
		
		// cierre de sesión
		if(e.getSource().equals(btnCerrarSesionPersonal)) {
			
				String mensaje = "¿Quieres cerrar la sesión?";
				int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
				if(opc==JOptionPane.YES_OPTION) {
					dispose();
				}
		}
		
		// buttons rellenar citas------------------------------------------------------------------------------------------------------------------------------
		
		// guarda las anotaciones realizadas
		if(e.getSource().equals(btnAnotaciones)) {
			String descripcion = textField.getText();
			String codigo = textCodigo.getText();
			
			String mensaje = "¿Quieres guardar las anotaciones?";
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			
			if(opc == JOptionPane.YES_OPTION) {
				try {
					manager.updateAnotacion(codigo, descripcion);
					crearTablaCitas(personal, true);
					JOptionPane.showMessageDialog(this, "Anotación guardada correctamente", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e1) {
					String aviso = "¡Error al guardar la anotación!";
					JOptionPane.showMessageDialog(this, aviso, "AVISO", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
		
		// limpia el text Area con las anotaciones
		if(e.getSource().equals(btnBorrarAnotacion)) {
			textField.setText("");
		}
		
		//butons alta de cliente-------------------------------------------------------------------------------------------------------------------------------
		
		// botón para registrar a un nuevo cliente
		if(e.getSource().equals(btnRegistrarCliente)) {
			
			//comprobamos que todos los campos estén completos
			if(comprobarCamposCliente()) {
						
				recogerDatosCliente();
				
				//desactivamos campos para que no haga modificaciones posteriores al alta
				activarTextArea(false);
				
				//mostramos mensaje de registro realizado
				JOptionPane.showMessageDialog(this, "Usuario registrado correctamente", "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
				btnCrearUsuario.setEnabled(true);
				btnRegistrarCliente.setEnabled(false);
				btnRegistraMascota.setEnabled(true);
				btnCancelarCliente.setEnabled(false);	
			}

		}
		
		//botón para limpiar el formulario
		if(e.getSource().equals(btnCancelarCliente)) {
			
			String mensaje = "¿Quieres cancelar el registro?";
			
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			
			if(opc == JOptionPane.YES_OPTION) {
				limpiarFormularioCliente();
			}
		}
		
		// botón para crear clave de usuario
		if(e.getSource().equals(btnCrearUsuario)) {
			String clave = crearClaveUsuario();
			String mensaje = "Usuario: "+textaltaDni.getText()+
					"\n	"+"Clave: "+clave;
			JOptionPane.showMessageDialog(this, mensaje, "DATOS", JOptionPane.INFORMATION_MESSAGE);	

			btnCrearUsuario.setEnabled(false);
		}
		
		// boton que se activa para registra una mascota tras dar de alta al cliente 
		if(e.getSource().equals(btnRegistraMascota)) {
			mostrarDatosCitas(false);
			mostrarAltacliente(false);
			mostrarAltaMascota(true);
			
			btnRegistrarAnimal.setEnabled(true);
			textaltaDniPropietario.setText(textaltaDni.getText());
			textaltaDniPropietario.setEditable(false);
			activarTextAreaMascota(true);
			
		}
		
		// buttons alta de mascota------------------------------------------------------------------------------------------------------------------------------
		
		// botón para registrar la nueva mascota
		if(e.getSource().equals(btnRegistrarAnimal)) {
			
			//comprobamos que todos los campos estén completos
			if(comprobarCamposMascota()) {
				recogerDatosMascota(textaltaDniPropietario.getText());
				
				//desactivamos campos para que no haga modificaciones posteriores al alta
				activarTextAreaMascota(false);
				btnCancelarMascota.setEnabled(false);
				
				//mostramos mensaje de registro realizado
				String mensaje ="Mascota registrada correctamente";
				JOptionPane.showMessageDialog(this, mensaje, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
				
				//desactivamos botón de registro de mascota
				btnRegistrarAnimal.setEnabled(false);
				
			}
			
			else {
				String mensaje = "¡Debes rellenar todos los campos!";
				JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
			}	
		}
		
		// limpia formulario del alta de mascota
		if(e.getSource().equals(btnCancelarMascota)) {
			
			String mensaje = "¿Quieres cancelar el registro?";
			
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			
			if(opc == JOptionPane.YES_OPTION) {
				limpiarFormularioMascota();
			}
		}
		
		
		// buttons paneles de registro---------------------------------------------------------------------------------------------------------------------------------
		
		// botón para realizar la búsqueda de cliente
		if(e.getSource().equals(btnBuscar)) {
			
			String dniBuscado = textDniBuscar.getText();
			
			try {
				Cliente clienteBuscado = manager.getCliente(dniBuscado);
				if(clienteBuscado !=null) {
					
		        	textNombreC.setText(clienteBuscado.getNombre());
		        	textPrimerApellidoC.setText(clienteBuscado.getApellido1());
		        	textSegundoApellido.setText(clienteBuscado.getApellido2());
		        	textDireccBuscada.setText(clienteBuscado.getDireccion());
		        	textLocalidadBuscada.setText(clienteBuscado.getLocalidad());
			 		textTelfBusc1.setText(clienteBuscado.getTelefono1());
			 		if(clienteBuscado.getTelefono2() == null)  {
			 			textTelfBusc2.setText("");
			 		}else {
			 			textTelfBusc2.setText(clienteBuscado.getTelefono2());
			 		}
				}
				else {
					String mensaje = "No se ha encontrado ningún cliente con ese DNI";
					JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
			
		}
		
		// botón para eliminar un cliente
		if(e.getSource().equals(btnEliminarCliente)) {
			
			String dni = textDniBuscar.getText();
			try {
				String mensaje = "¿Quieres eliminar al cliente?"+"\n"
								+"Nota: Se eliminá el registro de sus mascotas y las credenciales de acceso";
				
				int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
				
				if(opc == JOptionPane.YES_OPTION) {
					
					manager.borrarCliente(dni);
					
					String info ="Cliente eliminado correctamente";
					JOptionPane.showMessageDialog(this, info, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
					limpiarFormularioRegistro();
					datosTablasRegistroMascotas();
					datosTablaClientes();
					
				}
						
			}catch (Exception e1) {
				e1.printStackTrace();
			}
			
			
		}
		
		// botón para realizar la búsqueda de mascota
		if(e.getSource().equals(btnBuscarMascota)) {
			String dniPropietario = textDniBuscar.getText();
			String nombre = textNombreMascotaB.getText();
			
			try {
				Mascota mascotaBuscada = manager.getMascota(dniPropietario, nombre);
				if(mascotaBuscada!=null) {
					if(mascotaBuscada.isBlnCastrado()) {
						chckbxCastradoBuscado.setSelected(true);
						chckbxCastradoBuscado.setEnabled(false);
					}
				}
				else {
					String mensaje = "No se ha encontrado ninguna mascota con esos datos";
					JOptionPane.showMessageDialog(this, mensaje, "AVISO", JOptionPane.WARNING_MESSAGE);
				}
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		// botón que guarda los datos editados
		if(e.getSource().equals(btnEditarRegistroMascota)){
			
			String mensaje = "¿Quieres guardar los cambios?";
			
			int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
			
			if(opc == JOptionPane.YES_OPTION) {
				try {
					Mascota m = guardarDatosMascota();
					manager.editarDatosMascota(m);
					datosTablasRegistroMascotas();
					String info ="Nuevos datos guardados correctamente";
					JOptionPane.showMessageDialog(this, info, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		
		// botón que elimina una mascota
		if(e.getSource().equals(btnEliminarMascota)) {
			
			String id = textIdMascota.getText();
			String nombre = textNombreMascotaB.getText();
			
			try {
				String mensaje = "¿Quieres eliminar esta mascota?";
		
				int opc = JOptionPane.showConfirmDialog(this, mensaje, "AVISO", JOptionPane.YES_NO_OPTION);
				
				if(opc == JOptionPane.YES_OPTION) {
			
					manager.borrarMascota(id, nombre);
					String info ="Mascota eliminada correctamente";
					JOptionPane.showMessageDialog(this, info, "INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE);
					datosTablasRegistroMascotas();
					limpiarFormularioRegistroMascotas();
					
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		
	}


}

