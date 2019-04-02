/**
 * 
 */
package controladorServidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import archivo.ClsArchivo;
import controladorCliente.ConexionCliente;
import mensaje.ClsMensaje;


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
		ClsMensaje mensajes = new ClsMensaje();
		ClsArchivo archivos = new ClsArchivo();

		try {
			// Se crea el serverSocket
			servidor = new ServerSocket(puerto, maximoConexiones);

			// Bucle infinito para esperar conexione
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
