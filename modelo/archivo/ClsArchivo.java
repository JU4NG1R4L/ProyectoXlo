/**
 * 
 */
package archivo;

import java.util.Observable;

/**
 * @author (Juan José Giraldo Salazar)
 *
 * juanj8845@gmail.com
 */
public class ClsArchivo extends Observable{
	String archivo;

    public ClsArchivo() {

    }

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
        this.setChanged();
        this.notifyObservers("Archivo:" +archivo);
	}
}
