package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo;

public class ProveedorVO {
	private int nit;
	
	private String ciudad;
	
	private String direccion;
	
	private String nombre;
	
	private String telefono;
	
	
	public ProveedorVO() {
		
	}
	

	public ProveedorVO(int nit, String ciudad, String direccion, String nombre, String telefono) {
		super();
		this.nit = nit;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Proveedor [nit=" + nit + ", ciudad=" + ciudad + ", direccion=" + direccion + ", nombre=" + nombre
				+ ", telefono=" + telefono + "]";
	}
}
