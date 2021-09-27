package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO;

public class Usuario {
	
	private int cedula;
	
	private String email;
	
	private String nombre;
	
	private String contrasena;
	
	private String rol;
	
	

	public Usuario(int cedula,String email, String nombre, String contrasena, String rol) {
		super();
		this.cedula = cedula;
		this.email=email;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.rol = rol;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", email =" + email + ", nombre=" + nombre + ", contrasena=" + contrasena + ", rol=" + rol + "]";
	}

	

}
