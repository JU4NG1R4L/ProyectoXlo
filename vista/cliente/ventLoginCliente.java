package cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class ventLoginCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedulaLogin;
	private JPasswordField txtPasswordUsuario;

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
		
		txtCedulaLogin = new JTextField();
		txtCedulaLogin.setBounds(141, 117, 186, 22);
		contentPane.add(txtCedulaLogin);
		txtCedulaLogin.setColumns(10);
		
		txtPasswordUsuario = new JPasswordField();
		txtPasswordUsuario.setBounds(141, 193, 186, 22);
		contentPane.add(txtPasswordUsuario);
		
		JButton btnIniciarSesin = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIniciarSesin.setBounds(51, 287, 155, 35);
		contentPane.add(btnIniciarSesin);
		
		JButton btnRegistrarse = new JButton("REGISTRARSE");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrarse.setBounds(306, 287, 139, 35);
		contentPane.add(btnRegistrarse);
		
		JCheckBox chckbxRecordarme = new JCheckBox("Recordarme");
		chckbxRecordarme.setFont(new Font("Tahoma", Font.BOLD, 13));
		chckbxRecordarme.setBounds(51, 238, 113, 25);
		contentPane.add(chckbxRecordarme);
	}
}
