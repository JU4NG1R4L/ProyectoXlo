package cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladorServidor.ConexionServidor;
import controladorUsuario.CtlUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ventRegistroCliente extends JFrame {

	private JPanel contentPane;
	static ventRegistroCliente frame;
	private Socket socket;
	private DataOutputStream salidaDatos;
	String host;
	int puerto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ventRegistroCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public ventRegistroCliente() {
		try {
			host = "localhost";
			puerto = 1234;
			socket = new Socket(host, puerto);
			this.salidaDatos = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
			System.out.println("No se ha podido conectar con el servidor - ventLoginCliente (" + ex.getMessage() + ").");
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("No se ha podido conectar con el servidor - ventLoginCliente (" + ex.getMessage() + ").");
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblregistrateEsGratis = new JLabel("\u00A1REGISTRATE ES GRATIS Y SIEMPRE LO SER\u00C1!");
		lblregistrateEsGratis.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblregistrateEsGratis.setBounds(33, 13, 359, 32);
		contentPane.add(lblregistrateEsGratis);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\juanm\\Desktop\\imagenUsuario.jpg"));
		label.setBounds(18, 103, 97, 131);
		contentPane.add(label);
		
		JLabel lblNombre = new JLabel("NOMBRE: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(33, 315, 82, 25);
		contentPane.add(lblNombre);
		
		JLabel lblCdula = new JLabel("C\u00C9DULA: ");
		lblCdula.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCdula.setBounds(158, 133, 68, 16);
		contentPane.add(lblCdula);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(18, 245, 480, 16);
		contentPane.add(separator);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A: ");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBounds(158, 192, 97, 16);
		contentPane.add(lblContrasea);
		
		JLabel lblDatosUsuario = new JLabel("DATOS USUARIO: ");
		lblDatosUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosUsuario.setBounds(33, 58, 131, 32);
		contentPane.add(lblDatosUsuario);
		
		JLabel lblDatosPersonales = new JLabel("DATOS PERSONALES: ");
		lblDatosPersonales.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDatosPersonales.setBounds(33, 274, 169, 28);
		contentPane.add(lblDatosPersonales);
		
		JLabel lblTelfono = new JLabel("TEL\u00C9FONO: ");
		lblTelfono.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelfono.setBounds(33, 356, 82, 16);
		contentPane.add(lblTelfono);
		
		JLabel lblEmail = new JLabel("EMAIL: ");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(33, 399, 56, 16);
		contentPane.add(lblEmail);
		
		JTextField txtCedulaUsuario = new JTextField();
		txtCedulaUsuario.setBounds(276, 130, 176, 22);
		contentPane.add(txtCedulaUsuario);
		txtCedulaUsuario.setColumns(10);
		
		JTextField txtContrasenaUsuario = new JTextField();
		txtContrasenaUsuario.setBounds(276, 189, 176, 22);
		contentPane.add(txtContrasenaUsuario);
		txtContrasenaUsuario.setColumns(10);
		
		JTextField txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(276, 316, 176, 22);
		contentPane.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		JTextField txtTelefonoUsuario = new JTextField();
		txtTelefonoUsuario.setBounds(276, 353, 176, 22);
		contentPane.add(txtTelefonoUsuario);
		txtTelefonoUsuario.setColumns(10);
		
		JTextField txtEmailUsuario = new JTextField();
		txtEmailUsuario.setBounds(276, 396, 176, 22);
		contentPane.add(txtEmailUsuario);
		txtEmailUsuario.setColumns(10);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cedulaUsuario = txtCedulaUsuario.getText();	
				String nombreUsuario = txtNombreUsuario.getText();
				String telefonoUsuario = txtTelefonoUsuario.getText();
				String emailUsuario = txtEmailUsuario.getText();
				String contrasenaUsuario = txtContrasenaUsuario.getText();
				String registrar ="registrar-"+cedulaUsuario+"-"+nombreUsuario+"-"+telefonoUsuario+"-"+emailUsuario+"-"+contrasenaUsuario;
				new ConexionServidor(socket, registrar);
			}
		});
		
		btnRegistro.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistro.setBounds(71, 464, 131, 32);
		contentPane.add(btnRegistro);
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancelar.setBounds(341, 464, 111, 30);
		contentPane.add(btnCancelar);
	}
}
