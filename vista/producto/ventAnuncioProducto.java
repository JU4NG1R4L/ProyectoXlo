package producto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ventAnuncioProducto extends JFrame {

	private JPanel contentPane;
	private JTextField txtMensaje;

	private Socket socket;
	private DataOutputStream salidaDatos;

	private int puerto;
	private String host;

	private JTextArea mensajesChat;

	private JTextArea textAreaChat;
	
	static ventAnuncioProducto frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ventAnuncioProducto();
					frame.setVisible(true);
					frame.recibirMensajesServidor();
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

		textAreaChat = new JTextArea();
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

		// Se crea el socket para conectar con el Sevidor del Chat
		try {
			socket = new Socket(host, puerto);
			this.salidaDatos = new DataOutputStream(socket.getOutputStream());
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
			System.out.println("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
		}

		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setBounds(453, 591, 97, 25);
		contentPane.add(btnEnviar);

	}

	/**
	 * Recibe los mensajes del chat reenviados por el servidor
	 */
	public void recibirMensajesServidor() {
		// Obtiene el flujo de entrada del socket
		mensajesChat = textAreaChat;
		DataInputStream entradaDatos = null;
		String mensaje;
		try {
			entradaDatos = new DataInputStream(socket.getInputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Error al crear el stream de entrada: " + ex.getMessage());
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			System.out.println("El socket no se creo correctamente. ");
		}

		// Bucle infinito que recibe mensajes del servidor
		boolean conectado = true;
		while (conectado) {
			try {
				mensaje = entradaDatos.readUTF();

				if (mensaje.equals("ConnectiviyFile")) {
					byte[] receivedData = new byte[256 * 1024];
					BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
					DataInputStream dis = new DataInputStream(socket.getInputStream());
					// Recibimos el nombre del fichero
					String file = dis.readUTF();
					System.out.println(file);
					file = file.substring(file.indexOf('\\') + 1, file.length());
					System.out.println(file);
					// Para guardar fichero recibido
					BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
					int in = bis.read(receivedData);
					bos.write(receivedData, 0, in);

				}

				mensajesChat.append(mensaje + System.lineSeparator());

			} catch (IOException ex) {
				ex.printStackTrace();
				System.out.println("Error al leer del stream de entrada: " + ex.getMessage());
				conectado = false;
			} catch (NullPointerException ex) {
				ex.printStackTrace();
				System.out.println("El socket no se creo correctamente. ");
				conectado = false;
			}
		}
	}

}
