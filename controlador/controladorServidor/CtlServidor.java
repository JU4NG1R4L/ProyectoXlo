package controladorServidor;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import cliente.ventRegistroCliente;

public class CtlServidor implements Runnable{
	
	ServerSocket serverSocket;
	Socket cliente;
	ObjectInputStream entradas;
	ObjectOutputStream salida;
	DataInputStream CRUD;
	ventRegistroCliente vRegistro;
	
	public CtlServidor(ventRegistroCliente vRegistro) {
		super();
		this.vRegistro = vRegistro;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			while(true) {
				cliente = serverSocket.accept();
				System.out.println("¡Ha sido aceptada la solicitud del cliente");
				recibir();
			}
		} catch (Exception e) {
			// TODO: handle exception
			//cerrarConexion();
		}
		
	}
	
	public void recibir() {
		try {
			entradas = new ObjectInputStream(cliente.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
