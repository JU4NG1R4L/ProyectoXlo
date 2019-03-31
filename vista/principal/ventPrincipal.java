package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventPrincipal frame = new ventPrincipal();
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
	public ventPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidosAMi = new JLabel("BIENVENIDOS A MI TIENDA ONLINE - XLO");
		lblBienvenidosAMi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBienvenidosAMi.setBounds(96, 52, 407, 52);
		contentPane.add(lblBienvenidosAMi);
		
		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCliente.setBounds(39, 203, 124, 83);
		contentPane.add(btnCliente);
		
		JButton btnVendedor = new JButton("PRODUCTO");
		btnVendedor.setBounds(372, 203, 124, 83);
		contentPane.add(btnVendedor);
	}
}
