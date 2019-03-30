package cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ventRegistroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventRegistroCliente frame = new ventRegistroCliente();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblregistrateEsGratis = new JLabel("\u00A1REGISTRATE ES GRATIS!");
		lblregistrateEsGratis.setBounds(157, 34, 166, 16);
		contentPane.add(lblregistrateEsGratis);
		
		JLabel lblNombre = new JLabel("NOMBRE:");
		lblNombre.setBounds(30, 96, 56, 16);
		contentPane.add(lblNombre);
		
		JLabel lblCdula = new JLabel("C\u00C9DULA: ");
		lblCdula.setBounds(30, 138, 56, 16);
		contentPane.add(lblCdula);
		
		JLabel lblTelfono = new JLabel("TEL\u00C9FONO: ");
		lblTelfono.setBounds(30, 185, 96, 16);
		contentPane.add(lblTelfono);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setBounds(30, 225, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A: ");
		lblContrasea.setBounds(30, 273, 89, 16);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(157, 93, 208, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 135, 208, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(157, 182, 208, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(157, 222, 208, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(157, 270, 208, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnIniciarSesin = new JButton("INICIAR SESI\u00D3N");
		btnIniciarSesin.setBounds(30, 335, 143, 25);
		contentPane.add(btnIniciarSesin);
		
		JButton btnRegistro = new JButton("REGISTRO");
		btnRegistro.setBounds(371, 335, 97, 25);
		contentPane.add(btnRegistro);
	}

}
