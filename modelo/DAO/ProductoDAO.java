/**
 * 
 */
package DAO;

import conexion.ClsConexion;
import producto.ClsProducto;

/**
 * @author (Juan José Giraldo Salazar)
 *
 *         juanj8845@gmail.com
 */
public class ProductoDAO extends ClsConexion {
	ClsProducto dao = new ClsProducto();

	public boolean guardarProducto(ClsProducto producto) {
		String consulta = "insert into producto" + "(nombreProducto, precioProducto, descripcionProducto) " + "values "
				+ "('" + producto.getNombreProducto() + "', " + producto.getPrecioProducto() + ", '"
				+ producto.getDescripcionProducto() + ")";
		return super.ejecutar(consulta);
	}
	
}
