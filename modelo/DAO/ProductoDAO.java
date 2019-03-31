/**
 * 
 */
package DAO;

import conexion.ClsConexion;
import producto.ClsProducto;

/**
 * @author (Juan José Giraldo Salazar)
 *
 * juanj8845@gmail.com
 */
public class ProductoDAO extends ClsConexion{
ClsProducto dao = new ClsProducto();
public boolean guardarProducto(String nombreProducto, float precioProducto, String descripcionProducto) {
	return false;
	
}
}
