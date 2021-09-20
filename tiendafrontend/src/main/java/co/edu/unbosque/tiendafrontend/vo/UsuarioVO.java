package co.edu.unbosque.tiendafrontend.vo;

public class UsuarioVO {

	private int cedula_usuario;
	private String email_usuario;
	private String nombre_usuario;
	private String password_usuario;
	private String usuario;
	
	
	
	/*public UsuarioVO(int cedula_usuario, String email_usuario, String nombre_usuario, String password_usuario,
			String usuario) {
		super();
		this.cedula_usuario = cedula_usuario;
		this.email_usuario = email_usuario;
		this.nombre_usuario = nombre_usuario;
		this.password_usuario = password_usuario;
		this.usuario = usuario;
	}*/
	public int getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(int cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPassword_usuario() {
		return password_usuario;
	}
	public void setPassword_usuario(String password_usuario) {
		this.password_usuario = password_usuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "UsuarioVO [cedula_usuario=" + cedula_usuario + ", email_usuario=" + email_usuario + ", nombre_usuario="
				+ nombre_usuario + ", password_usuario=" + password_usuario + ", usuario=" + usuario + "]";
	}
	

	
	
}


