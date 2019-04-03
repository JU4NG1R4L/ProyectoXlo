/**
 * 
 */
package controladorCliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import hilos.servidor.MensajesChat;

/**
 * @author (Juan José Giraldo Salazar)
 *
 * juanj8845@gmail.com
 */
public class ConexionCliente extends Thread implements Observer {

	private Socket socket;
	private MensajesChat mensajes;
	private DataInputStream entradaDatos;
	private DataOutputStream salidaDatos;
	ArrayList<String> usuariosConectados = new ArrayList<String>();
	
	public ConexionCliente(Socket socket, MensajesChat mensajes) {
		this.socket = socket;
		this.mensajes = mensajes;

		try {
			entradaDatos = new DataInputStream(socket.getInputStream());
			salidaDatos = new DataOutputStream(socket.getOutputStream());

		} catch (IOException ex) {
			System.out.println("Error al crear los stream de entrada y salida : " + ex.getMessage());
		}
	}

	@Override
	public void run() {
		String mensaje;
		boolean conectado = true;
		// Se apunta a la lista de observadores de mensajes
		mensajes.addObserver(this);
		while (conectado) {
			try {
				// Lee un mensaje enviado por el cliente
				mensaje = entradaDatos.readUTF();
				
				
				mensajes.setMensaje(mensaje);
			} catch (IOException ex) {
				System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " desconectado.");
				conectado = false;
				// Si se ha producido un error al recibir datos del cliente se cierra la
				// conexion con el.
				try {
					entradaDatos.close();
					salidaDatos.close();

				} catch (IOException ex2) {
					ex2.printStackTrace();
					System.out.println("Error al cerrar los stream de entrada y salida :" + ex2.getMessage());
				}
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			// Envia el mensaje al cliente
			salidaDatos.writeUTF(arg.toString());
		} catch (IOException ex) {
			System.out.println("Error al enviar mensaje al cliente (" + ex.getMessage() + ").");
			ex.printStackTrace();
		}
	}
}
