package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo;

public class VentaListaVO {	

	long cedula_cliente;
	String nombre_cliente;
	long ventas_totales;
	
	public VentaListaVO(){
		
	}
	
	public VentaListaVO(long cedula_cliente, String nombre_cliente, long ventas_totales) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.nombre_cliente = nombre_cliente;
		this.ventas_totales = ventas_totales;
	}
	public long getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public String getNombre_cliente() {
		return nombre_cliente;
	}
	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}
	public long getVentas_totales() {
		return ventas_totales;
	}
	public void setVentas_totales(long ventas_totales) {
		this.ventas_totales = ventas_totales;
	}

	@Override
	public String toString() {
		return "VentaLista [cedula_cliente=" + cedula_cliente + ", nombre_cliente=" + nombre_cliente
				+ ", ventas_totales=" + ventas_totales + "]";
	}
	
	
	
}
