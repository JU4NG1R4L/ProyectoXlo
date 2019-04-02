/**
 * 
 */
package controladorServidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;

/**
 * @author (Juan Jos� Giraldo Salazar)
 *
 * juanj8845@gmail.com
 */
public class ConexionServidor implements ActionListener {

	private Socket socket;
	private JTextField tfMensaje;
	private String usuario;
	private DataOutputStream salidaDatos;



	public ConexionServidor(Socket socket, JTextField tfMensaje, String usuario) {
		this.socket = socket;
		this.tfMensaje = tfMensaje;
		this.usuario = usuario;
		try {
			this.salidaDatos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Error al crear el stream de salida : " + ex.getMessage());
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			System.out.println("El socket no se creo correctamente. ");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			salidaDatos.writeUTF(usuario +": "+ tfMensaje.getText());
			tfMensaje.setText("");
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Error al intentar enviar un mensaje: " + ex.getMessage());
		}
	}
}
