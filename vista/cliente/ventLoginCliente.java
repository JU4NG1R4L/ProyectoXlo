package cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ventLoginCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtLoginCliente;
	private JTextField txtContraseñaCliente;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 627, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombreDeUsuario = new JLabel("NOMBRE DE USUARIO: ");
		lblNombreDeUsuario.setBounds(43, 124, 134, 28);
		contentPane.add(lblNombreDeUsuario);
		
		txtLoginCliente = new JTextField();
		txtLoginCliente.setBounds(212, 127, 230, 22);
		contentPane.add(txtLoginCliente);
		txtLoginCliente.setColumns(10);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A: ");
		lblContrasea.setBounds(43, 219, 134, 16);
		contentPane.add(lblContrasea);
		
		txtContraseñaCliente = new JTextField();
		txtContraseñaCliente.setBounds(212, 216, 230, 22);
		contentPane.add(txtContraseñaCliente);
		txtContraseñaCliente.setColumns(10);
		
		JButton btnIniciarSesin = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesin.setBounds(43, 335, 134, 28);
		contentPane.add(btnIniciarSesin);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.setBounds(420, 335, 118, 27);
		contentPane.add(btnRegistro);
		
		JLabel lblIniciaSesin = new JLabel("INICIA SESI\u00D3N");
		lblIniciaSesin.setBounds(212, 33, 106, 22);
		contentPane.add(lblIniciaSesin);
	}
}
