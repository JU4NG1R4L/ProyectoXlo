package cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import controladorServidor.ConexionServidor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ventLoginCliente extends JFrame {

	private JPanel contentPane;
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
					ventLoginCliente frame = new ventLoginCliente();
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
	public ventLoginCliente() {
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
		setBounds(100, 100, 529, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbliniciaSesin = new JLabel("\u00A1INICIA SESI\u00D3N!");
		lbliniciaSesin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbliniciaSesin.setBounds(188, 34, 139, 35);
		contentPane.add(lbliniciaSesin);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\juanm\\Desktop\\loginUsuario.png"));
		lblNewLabel.setBounds(380, 111, 89, 106);
		contentPane.add(lblNewLabel);

		JLabel lblCdula = new JLabel("C\u00C9DULA: ");
		lblCdula.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCdula.setBounds(27, 111, 99, 35);
		contentPane.add(lblCdula);

		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A: ");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasea.setBounds(27, 189, 114, 28);
		contentPane.add(lblContrasea);

		JTextField txtCedulaLogin = new JTextField();
		txtCedulaLogin.setBounds(141, 117, 186, 22);
		contentPane.add(txtCedulaLogin);
		txtCedulaLogin.setColumns(10);

		JPasswordField txtPasswordUsuario = new JPasswordField();
		txtPasswordUsuario.setBounds(141, 193, 186, 22);
		contentPane.add(txtPasswordUsuario);

		JButton btnIniciarSesin = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String login;
				String cedula = txtCedulaLogin.getText();
				String contraseña = txtPasswordUsuario.getText();
				login="login-"+cedula+"-"+contraseña;
				new ConexionServidor(socket, login);	
			}
		});
		btnIniciarSesin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIniciarSesin.setBounds(51, 287, 155, 35);
		contentPane.add(btnIniciarSesin);

		JButton btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventRegistroCliente registrarCliente = new ventRegistroCliente();
				registrarCliente.setVisible(true);
				dispose();
			}
		});
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarse.setBounds(306, 287, 139, 35);
		contentPane.add(btnRegistrarse);

		JCheckBox chckbxRecordarme = new JCheckBox("Recordarme");
		chckbxRecordarme.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxRecordarme.setBounds(51, 238, 113, 25);
		contentPane.add(chckbxRecordarme);
		
		
	
	}
	
}
