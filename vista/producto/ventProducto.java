package producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;

public class ventProducto extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventProducto frame = new ventProducto();
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
	public ventProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProductosOnline = new JLabel("PRODUCTOS ONLINE");
		lblProductosOnline.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblProductosOnline.setBounds(188, 28, 175, 24);
		contentPane.add(lblProductosOnline);
		
		JComboBox cboxCiudades = new JComboBox();
		cboxCiudades.setFont(new Font("Tahoma", Font.BOLD, 14));
		cboxCiudades.setBounds(367, 164, 134, 22);
		contentPane.add(cboxCiudades);
		
		JButton btnFiltrar = new JButton("FILTRAR");
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFiltrar.setBounds(38, 163, 97, 25);
		contentPane.add(btnFiltrar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(38, 310, 85, 86);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(174, 310, 85, 86);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(304, 310, 85, 86);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(426, 310, 85, 86);
		contentPane.add(lblNewLabel_3);
		
		JButton btnPublicar = new JButton("PUBLICAR");
		btnPublicar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPublicar.setBounds(201, 452, 127, 33);
		contentPane.add(btnPublicar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 89, 506, 2);
		contentPane.add(separator);
		
		JLabel lblBsqueda = new JLabel("B\u00DASQUEDA");
		lblBsqueda.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBsqueda.setBounds(38, 104, 97, 33);
		contentPane.add(lblBsqueda);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(26, 234, 506, 2);
		contentPane.add(separator_1);
		
		JLabel lblProductos = new JLabel("PRODUCTOS");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductos.setBounds(38, 262, 97, 35);
		contentPane.add(lblProductos);
	}
}
