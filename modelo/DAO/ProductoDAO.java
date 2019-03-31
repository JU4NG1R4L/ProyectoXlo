/**
 * 
 */
package DAO;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import conexion.ClsConexion;
import producto.ClsProducto;
import producto.ClsUbicacion;

/**
 * @author (Juan José Giraldo Salazar)
 *
 *         juanj8845@gmail.com
 */

public class ProductoDAO extends ClsConexion {
	ClsProducto dao = new ClsProducto();
	ArrayList<ClsProducto> producto;

	public boolean guardarProducto(ClsProducto producto) {
		String consulta = "insert into producto"
				+ "(imagenProducto, nombreProducto, precioProducto, descripcionProducto, ubicacion_idUbicacion) "
				+ "values " + "('" + producto.getImagenProducto() + "', '" + producto.getNombreProducto() + "', "
				+ producto.getPrecioProducto() + ", '" + producto.getDescripcionProducto() + "', "
				+ producto.getUbicacion_idUbicacion() + ")";
		return super.ejecutar(consulta);
	}
//public ArrayList<ClsProducto> buscarProducto(int ubicacion) {
//	producto = new ArrayList<>();
//	String consulta = "select codigoProducto from producto where ubicacion_idUbicacion="+ubicacion;
//	super.ejecutarRetorno(consulta);
//	try {
//		if(resultadoDB.next()) {
//			producto.add(e)
//		}
//	} catch (Exception e) {
//		System.out.println("Error en productoDAO Buscar");
//	}
//	return producto;
//}
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
	public DefaultComboBoxModel cargarUbicacion() {
		DefaultComboBoxModel combo = new DefaultComboBoxModel<>();
		String consulta = "select * from ubicacion";
		super.ejecutarRetorno(consulta);
		try {
			combo.addElement("Selecciona la ubicación");
			while(resultadoDB.next()) {
				combo.addElement(new ClsUbicacion(resultadoDB.getInt("idUbiciacion"), resultadoDB.getString("ciudad")));
			}
		} catch (Exception e) {
			System.out.println("Error al cargar la ciudad productoDAO");
		}
		return combo;
	}

}
