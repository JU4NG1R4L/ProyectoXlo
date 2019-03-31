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
		String consulta = "insert into producto"
				+ "(imagenProducto, nombreProducto, precioProducto, descripcionProducto, ubicacion_idUbicacion) "
				+ "values " + "('" + producto.getImagenProducto() + "', '" + producto.getNombreProducto() + "', "
				+ producto.getPrecioProducto() + ", '" + producto.getDescripcionProducto() + "', "
				+ producto.getUbicacion_idUbicacion() + ")";
		return super.ejecutar(consulta);
	}

	public boolean modificarProducto(ClsProducto producto) {
		String consulta = "update producto set imagenProducto='" + producto.getImagenProducto() + "',"
				+ "nombreProducto='" + producto.getNombreProducto() + "', precioProducto="
				+ producto.getPrecioProducto() + ", descripcionProducto='" + producto.getDescripcionProducto()
				+ "', ubicacion_idUbicacion=" + producto.getUbicacion_idUbicacion() + " where codigoProducto="
				+ producto.getCodigoProducto();
		return super.ejecutar(consulta);
	}

	public boolean eliminarProducto(int codigoProducto) {
		String consulta = "delete from producto where codigoProducto=" + codigoProducto;
		return super.ejecutar(consulta);
	}

}
