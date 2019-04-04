/**
 * 
 */
package DAO;

import conexion.ClsConexion;
import usuario.ClsUsuario;

/**
 * @author (Juan José Giraldo Salazar)
 *
 *         juanj8845@gmail.com
 */
public class UsuarioDAO extends ClsConexion {

	ClsUsuario dao = new ClsUsuario();

	public boolean guardarUsuario(ClsUsuario usuario) {
		String consulta = "insert into usuario "
				+ "(cedulaUsuario, nombreUsuario, telefonoUsuario, emailUsuario, contraseñaUsuario, login) " + "values "
				+ "('" + usuario.getCedulaUsuario() + "', '" + usuario.getNombreUsuario() + "', '"
				+ usuario.getTelefonoUsuario() + "', '" + usuario.getEmailUsuario() + "', '"
				+ usuario.getContrasenaUsuario() + "', " + usuario.isLogin() + ")";
		return super.ejecutar(consulta);
	}
	
	public ClsUsuario buscarUsuario(String cedula) {
	String consulta = "select cedulaUsuario where cedulaUsuario ="+cedula;
	super.ejecutarRetorno(consulta);
	try {
		if(resultadoDB.next()) {
			dao.setCedulaUsuario(resultadoDB.getString("cedulaUsuario"));	
		}
	}catch (Exception e) {
		System.out.println("FALLO EN LA BUSQUEDA DAO");
	}
	return dao;
	}
	
	public ClsUsuario login(String cedula, String password) {
		String consulta = "select nombreUsuario, telefonoUsuario from usuario where cedulaUsuario="+cedula+" and contraseñaUsuario="+password;
	super.ejecutarRetorno(consulta);
	try {
		if(resultadoDB.next()) {
			dao.setNombreUsuario(resultadoDB.getString("nombreUsuario"));
			dao.setContrasenaUsuario(resultadoDB.getString("contraseñaUsuario"));
		}
	}catch (Exception e) {
		System.out.println("FALLO EN LA BUSQUEDA DAO LOGIN");
	}
	return dao;
	}
}
