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
	private String nombreProducto;
	private float precioProducto;
	private String descripcionProducto;

	public ClsProducto(int codigoProducto, String nombreProducto, float precioProducto, String descripcionProducto) {
		super();
		this.codigoProducto = codigoProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.descripcionProducto = descripcionProducto;
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

}
