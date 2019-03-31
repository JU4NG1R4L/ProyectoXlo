package producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ventPublicarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreProducto;
	private JTextField txtPrecioProducto;
	private JTextField txtDescripcionProducto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventPublicarProducto frame = new ventPublicarProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*
	 * 
	 * 
	 * jgjkglkjhkjjhkjhlkjhklhlkjh
	 * 
	 */

	/**
	 * Create the frame.
	 */
	public ventPublicarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPublicarUnProducto = new JLabel("PUBLICAR UN PRODUCTO");
		lblPublicarUnProducto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPublicarUnProducto.setBounds(170, 31, 219, 31);
		contentPane.add(lblPublicarUnProducto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(29, 108, 509, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(29, 138, 145, 195);
		contentPane.add(lblNewLabel);
		
		JLabel lblProducto = new JLabel("PRODUCTO: ");
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblProducto.setBounds(241, 157, 107, 16);
		contentPane.add(lblProducto);
		
		JLabel lblPrecio = new JLabel("PRECIO: ");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(241, 204, 56, 16);
		contentPane.add(lblPrecio);
		
		JLabel lblDescripcin = new JLabel("DESCRIPCI\u00D3N: ");
		lblDescripcin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescripcin.setBounds(241, 265, 107, 16);
		contentPane.add(lblDescripcin);
		
		JLabel lblUbicacin = new JLabel("UBICACI\u00D3N: ");
		lblUbicacin.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUbicacin.setBounds(241, 317, 107, 16);
		contentPane.add(lblUbicacin);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setBounds(375, 154, 163, 22);
		contentPane.add(txtNombreProducto);
		txtNombreProducto.setColumns(10);
		
		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setBounds(375, 201, 163, 22);
		contentPane.add(txtPrecioProducto);
		txtPrecioProducto.setColumns(10);
		
		txtDescripcionProducto = new JTextField();
		txtDescripcionProducto.setBounds(375, 262, 163, 22);
		contentPane.add(txtDescripcionProducto);
		txtDescripcionProducto.setColumns(10);
		
		JComboBox cboxUbicacionProducto = new JComboBox();
		cboxUbicacionProducto.setBounds(375, 314, 163, 22);
		contentPane.add(cboxUbicacionProducto);
		
		JButton btnPublicar = new JButton("PUBLICAR");
		btnPublicar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPublicar.setBounds(323, 381, 159, 31);
		contentPane.add(btnPublicar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\juanm\\Desktop\\producto.png"));
		lblNewLabel_1.setBounds(44, 31, 56, 56);
		contentPane.add(lblNewLabel_1);
		
		JButton btnSubirImagen = new JButton("SUBIR IMAGEN");
		btnSubirImagen.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubirImagen.setBounds(27, 384, 147, 25);
		contentPane.add(btnSubirImagen);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(241, 381, 56, 16);
		contentPane.add(lblNewLabel_2);
	}

}
