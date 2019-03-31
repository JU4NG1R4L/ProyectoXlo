/**
 * 
 */
package producto;

/**
 * @author (Juan José Giraldo Salazar)
 *
 *         juanj8845@gmail.com
 */
public class ClsProducto {
	private int codigoProducto;
	private String imagenProducto;
	private String nombreProducto;
	private float precioProducto;
	private String descripcionProducto;
	private int ubicacion_idUbicacion;

	public ClsProducto(int codigoProducto,String imagenProducto, String nombreProducto, float precioProducto, String descripcionProducto, int ubicacion_idUbicacion) {
		super();
		this.codigoProducto = codigoProducto;
		this.imagenProducto = imagenProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.descripcionProducto = descripcionProducto;
		this.ubicacion_idUbicacion = ubicacion_idUbicacion;
	}

	public ClsProducto() {
		super();
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public float getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public String getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	public int getUbicacion_idUbicacion() {
		return ubicacion_idUbicacion;
	}

	public void setUbicacion_idUbicacion(int ubicacion_idUbicacion) {
		this.ubicacion_idUbicacion = ubicacion_idUbicacion;
	}

}
