/**
 * 
 */
package mensaje;

import java.util.Observable;

/**
 * @author (Juan José Giraldo Salazar)
 *
 *         juanj8845@gmail.com
 */
public class ClsMensaje extends Observable {
	private String mensaje;

	public ClsMensaje() {
		super();
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
		// Indica que el mensaje ha cambiado
		this.setChanged();
		// Notifica a los observadores que el mensaje ha cambiado y se lo pasa
		// (Internamente notifyObservers llama al metodo update del observador)
		this.notifyObservers(this.getMensaje());
	}

}
