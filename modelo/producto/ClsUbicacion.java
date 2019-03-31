/**
 * 
 */
package producto;

/**
 * @author (Juan José Giraldo Salazar)
 *
 *         juanj8845@gmail.com
 */
public class ClsUbicacion {
	private int idUbicacion;
	private String ciudad;

	public ClsUbicacion() {
		super();
	}

	public ClsUbicacion(int idUbicacion, String ciudad) {
		super();
		this.idUbicacion = idUbicacion;
		this.ciudad = ciudad;
	}

	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

}
