/**
 * 
 */
package controladorProducto;

import javax.swing.DefaultComboBoxModel;

import DAO.ProductoDAO;
import conexion.ClsConexion;
import producto.ClsProducto;

/**
 * @author (Juan José Giraldo Salazar)
 *
 *         juanj8845@gmail.com
 */
public class CtlProducto {
	ClsConexion conexion = new ClsConexion();

	public CtlProducto() {
		super();
	}

	public boolean SolicitudGuardar(String imagenProducto, String nombreProducto, float precioProducto,
			String descripcionProducto, int ubicacion_idUbicacion) {
		ClsProducto producto = new ClsProducto(imagenProducto, nombreProducto, precioProducto, descripcionProducto,
				ubicacion_idUbicacion);
		ProductoDAO proDAO = new ProductoDAO();
		return proDAO.guardarProducto(producto);
	}
//	public ClsProducto SolicitudBuscar() {
//		PERROR HIPETAJASHDAHISD
//	}
	public boolean SolicitudModificar(int codigoProducto, String imagenProducto, String nombreProducto, float precioProducto, String descripcionProducto, int ubicacion_idUbicacion) {
		ClsProducto producto = new ClsProducto(codigoProducto, imagenProducto, nombreProducto, precioProducto, descripcionProducto, ubicacion_idUbicacion);
		ProductoDAO proDAO = new ProductoDAO();
		return proDAO.modificarProducto(producto);
	}
	public boolean SolicitudEliminar(int codigoProducto) {
		ProductoDAO proDAO = new ProductoDAO();
		return proDAO.eliminarProducto(codigoProducto);
	}
	public DefaultComboBoxModel solicitudProducto() {
		ProductoDAO proDAO = new ProductoDAO();
        return proDAO.cargarUbicacion();
    }

	
}
