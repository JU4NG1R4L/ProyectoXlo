/**
 * 
 */
package controladorServidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JTextField;

/**
 * @author (Juan José Giraldo Salazar)
 *
 *         juanj8845@gmail.com
 */
public class ConexionServidor implements ActionListener {

	private Socket socket;
	private String datos;
	private DataOutputStream salidaDatos;
	public ConexionServidor(Socket socket, String datos) {
		this.socket = socket;
		this.datos = datos;
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
			salidaDatos.writeUTF(datos);
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("Error al intentar enviar un mensaje: " + ex.getMessage());
		}
	}
}
