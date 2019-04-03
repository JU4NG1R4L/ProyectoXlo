/**
 * 
 */
package controladorCliente;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import hilos.servidor.ClsArchivo;
import hilos.servidor.MensajesChat;

/**
 * @author (Juan José Giraldo Salazar)
 *
 * juanj8845@gmail.com
 */
public class ConexionCliente extends Thread implements Observer {

	private Socket socket;
	private MensajesChat mensajes;
	private ClsArchivo archivos;
	private DataInputStream entradaDatos;
	private DataOutputStream salidaDatos;

	BufferedInputStream bufferedIS; // Su método read devuelve un byte de a cada vez pero mantiene un buffer donde
									// va acumulando los bytes internamente.
	BufferedOutputStream bufferedOS;

	byte[] datosRecibidos;
	int entrada;
	String archivo, ruta;

	public ConexionCliente(Socket socket, MensajesChat mensajes, ClsArchivo archivos) {
		this.socket = socket;
		this.mensajes = mensajes;
		this.archivos = archivos;

		try {
			entradaDatos = new DataInputStream(socket.getInputStream());
			salidaDatos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			System.out.println("Error al crear los stream de entrada y salida : " + ex.getMessage());
		}
	}

	@Override
	public void run() {
		String mensajeRecibido;
		boolean conectado = true;
		// Se apunta a la lista de observadores de mensajes y archivo
		mensajes.addObserver(this);
		archivos.addObserver(this);

		while (conectado) {
			try {
				mensajeRecibido = entradaDatos.readUTF();
				System.out.println(mensajeRecibido);
				switch (mensajeRecibido) {
				case "archivoConexion":
					datosRecibidos = new byte[256*1024];// Dato recibido, peso de archivo 262000
					bufferedIS = new BufferedInputStream(socket.getInputStream());
					
					archivo = entradaDatos.readUTF();// Nombre del archivo
					System.out.println(archivo+"Estoy en conexion");
					archivo = archivo.substring(archivo.indexOf('\\') + 1, archivo.length());// Substring extrae una
					// parte de una cadena, por parametro se le pasa el indice inicial y el final de
					// la cadena
					bufferedOS = new BufferedOutputStream(new FileOutputStream(archivo));
					entrada = bufferedIS.read(datosRecibidos);
					System.out.println(entrada+" Esta es la entrada chat");
					//bufferedOS.write(datosRecibidos, 0, entrada);// (Byte archivo origen, offset vaciar buffet, bytes
																	// para escribir en el flujo)
					mensajeRecibido = archivo;
					archivos.setArchivo(mensajeRecibido);
					System.out.println("Entré al archivoConexion - conexion cliente");
					bufferedIS.close();
					break;

				default:
					mensajes.setMensaje(mensajeRecibido);
					break;
				}

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
			archivo = ((String) arg).split(":")[0];
			if (archivo.equals("Archivo")) {
				try {
					salidaDatos = new DataOutputStream(socket.getOutputStream());
					salidaDatos.writeUTF("archivoConexion");
					File archivoLocal = new File(arg.toString().split(":")[1]);
					bufferedIS = new BufferedInputStream(new FileInputStream(archivoLocal));
					bufferedOS = new BufferedOutputStream(socket.getOutputStream());
					
					salidaDatos.writeUTF(archivoLocal.getName());// Obtenemos el nombre del archivo
					System.out.println(arg.toString());

					byte[] byteArray;
					byteArray = new byte[256*1024];
					System.out.println("Asi es la entrada en el update "+ entrada);
					while ((entrada) != -1) {
						bufferedOS.write(byteArray, 0, entrada);
					}
					bufferedIS.close();
					bufferedOS.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			} else {
				// Envia el mensaje al cliente
				salidaDatos.writeUTF(arg.toString());
			}
		} catch (IOException ex) {
			System.out.println("Error al enviar mensaje al cliente (" + ex.getMessage() + ").");
			ex.printStackTrace();
		}
	}
}
