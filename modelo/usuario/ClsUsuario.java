/**
 * 
 */
package usuario;

/**
 * @author (Juan José Giraldo Salazar)
 *
 *         juanj8845@gmail.com
 */
public class ClsUsuario {
	private String cedulaUsuario, nombreUsuario, telefonoUsuario, emailUsuario, contrasenaUsuario;

	public ClsUsuario() {
		super();
	}

	public ClsUsuario(String cedulaUsuario, String nombreUsuario, String telefonoUsuario, String emailUsuario,
			String contrasenaUsuario) {
		super();
		this.cedulaUsuario = cedulaUsuario;
		this.nombreUsuario = nombreUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.emailUsuario = emailUsuario;
		this.contrasenaUsuario = contrasenaUsuario;
	}

	public String getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(String cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}

	public String getContrasenaUsuario() {
		return contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}

}
