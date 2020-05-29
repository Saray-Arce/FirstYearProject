package gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Usuario;
import control.Manager;

public class Login extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Manager manager = new Manager();
	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textPasswd;
	private JLabel lblImagen;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	

	/**
	 * Create the frame.
	 */
	public Login() {
		
		setTitle("CLINICA VETERINARIA");
		setIconImage(Toolkit.getDefaultToolkit().getImage("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\vet_verde.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(376, 202, 107, 26);
		contentPane.add(lblUsuario);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(467, 204, 311, 26);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		textUsuario.setText("");
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(376, 293, 140, 26);
		contentPane.add(lblPassword);
		
		textPasswd = new JPasswordField();
		textPasswd.setColumns(10);
		textPasswd.setBounds(467, 298, 311, 26);
		textPasswd.setText("");
		contentPane.add(textPasswd);
		
		//logo adaptado
		lblImagen = new JLabel("New label");
		lblImagen.setBounds(549, 40, 140, 140);
		ImageIcon imagen = new ImageIcon("H:\\1DAMi\\PRG\\WindowsBuilder\\ClinicaVeterinaria\\Img\\vet_verde.png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
		lblImagen.setIcon(icono);
		this.repaint();
		contentPane.add(lblImagen);
		
		//buttons
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(706, 407, 140, 32);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(386, 407, 140, 32);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);
			
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnAceptar)) {
			
			String wUsuario = textUsuario.getText().toString().trim();
			String clave = new String (textPasswd.getPassword()).trim();
			try {
				Usuario usuario = manager.getUsuario(wUsuario, clave);
				
				 if(usuario.getUsuario().equalsIgnoreCase(wUsuario) && usuario.getPassword().equalsIgnoreCase(clave)) {
					
					VentanaClinica clinica = new VentanaClinica(this, wUsuario, usuario.getTipo());
					clinica.setVisible(true);
				}
				
				
			} catch (Exception e1) {
				String mensaje = "Usuario o contraseña incorrectos";
				JOptionPane.showMessageDialog(this, mensaje,"ERROR", JOptionPane.ERROR_MESSAGE);

			}
			
		}
	
		if(e.getSource().equals(btnCancelar)) {
			dispose();
		}
	}
}


