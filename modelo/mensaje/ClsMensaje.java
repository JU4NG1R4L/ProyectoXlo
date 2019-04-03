/**
 * 
 */
package mensaje;

import java.util.Observable;

/**
 * @author (Juan José Giraldo Salazar)
 *
 * juanj8845@gmail.com
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
	this.setChanged();
	this.notifyObservers(this.getMensaje());
}

}
