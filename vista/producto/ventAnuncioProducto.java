package producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ventAnuncioProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventAnuncioProducto frame = new ventAnuncioProducto();
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
	public ventAnuncioProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImagenProducto = new JLabel("New label");
		lblImagenProducto.setBounds(27, 67, 125, 163);
		contentPane.add(lblImagenProducto);
		
		JLabel lblTituloProducto = new JLabel("Producto: ");
		lblTituloProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloProducto.setBounds(176, 67, 104, 23);
		contentPane.add(lblTituloProducto);
		
		JLabel lblTituloPrecio = new JLabel("Precio: ");
		lblTituloPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTituloPrecio.setBounds(177, 114, 56, 23);
		contentPane.add(lblTituloPrecio);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n: ");
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescripcion.setBounds(176, 170, 98, 23);
		contentPane.add(lblDescripcion);
		
		JLabel lblAnuncioDelProducto = new JLabel("ANUNCIO DEL PRODUCTO");
		lblAnuncioDelProducto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAnuncioDelProducto.setBounds(166, 13, 214, 33);
		contentPane.add(lblAnuncioDelProducto);
		
		JLabel lblNombreProducto = new JLabel("New label");
		lblNombreProducto.setForeground(Color.RED);
		lblNombreProducto.setBounds(327, 71, 223, 16);
		contentPane.add(lblNombreProducto);
		
		JLabel lblPrecioProducto = new JLabel("New label");
		lblPrecioProducto.setForeground(Color.RED);
		lblPrecioProducto.setBounds(327, 118, 223, 16);
		contentPane.add(lblPrecioProducto);
		
		JLabel lblDescripcionProducto = new JLabel("New label");
		lblDescripcionProducto.setForeground(Color.RED);
		lblDescripcionProducto.setBounds(176, 214, 374, 55);
		contentPane.add(lblDescripcionProducto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 282, 524, 8);
		contentPane.add(separator);
		
		JTextArea textAreaChat = new JTextArea();
		textAreaChat.setBounds(27, 332, 523, 247);
		contentPane.add(textAreaChat);
		
		JLabel lblForo = new JLabel("FORO:");
		lblForo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblForo.setBounds(37, 303, 56, 16);
		contentPane.add(lblForo);
		
		txtMensaje = new JTextField();
		txtMensaje.setBounds(27, 592, 395, 22);
		contentPane.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(453, 591, 97, 25);
		contentPane.add(btnEnviar);
	}
}
