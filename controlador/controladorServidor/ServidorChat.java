/**
 * 
 */
package controladorServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import hilos.servidor.ClsArchivo;
import hilos.servidor.ConexionCliente;
import hilos.servidor.MensajesChat;

/**
 * @author (Juan José Giraldo Salazar)
 *
 * juanj8845@gmail.com
 */
public class ServidorChat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int puerto = 1234;
		int maximoConexiones = 10; // Maximo de conexiones simultaneas
		ServerSocket servidor = null;
		Socket socket = null;
		MensajesChat mensajes = new MensajesChat();
		ClsArchivo archivos = new ClsArchivo();

		try {
			// Se crea el serverSocket
			servidor = new ServerSocket(puerto, maximoConexiones);

			// Bucle infinito para esperar conexiones
			while (true) {
				System.out.println("Servidor a la espera de conexiones.");
				socket = servidor.accept();
				System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");

				ConexionCliente cc = new ConexionCliente(socket, mensajes, archivos);
				cc.start();

			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();

		} finally {
			try {
				socket.close();
				servidor.close();
			} catch (IOException ex) {
				System.out.println("Error al cerrar el servidor: " + ex.getMessage());
			}
		}
	}
}
