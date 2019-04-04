/**
 * 
 */
package controladorUsuario;

import DAO.UsuarioDAO;
import conexion.ClsConexion;
import usuario.ClsUsuario;

/**
 * @author (Juan José Giraldo Salazar)
 *
 *         juanj8845@gmail.com
 */
public class CtlUsuario {

	ClsConexion conexion = new ClsConexion();

	public CtlUsuario() {
		super();
	}

	public boolean SolicitudGuardar(String cedulaUsuario, String nombreUsuario, String telefonoUsuario,
			String emailUsuario, String contrasenaUsuario) {
		ClsUsuario usuario = new ClsUsuario(cedulaUsuario, nombreUsuario, telefonoUsuario, emailUsuario,
				contrasenaUsuario);
		UsuarioDAO usuDAO = new UsuarioDAO();
		return usuDAO.guardarUsuario(usuario);
	}

	public ClsUsuario SolicitudBuscar(String cedula) {
		UsuarioDAO usuDAO = new UsuarioDAO();
		return usuDAO.buscarUsuario(cedula);
	}
	
	public ClsUsuario SolicitudLogin(String cedula, String contraseña) {
		UsuarioDAO usuDAO = new UsuarioDAO();
		return usuDAO.login(cedula, contraseña);
	}
}
