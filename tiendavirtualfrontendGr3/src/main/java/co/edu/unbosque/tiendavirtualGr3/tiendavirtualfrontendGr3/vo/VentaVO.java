package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo;

public class VentaVO {	
	long cedula_cliente;
	long cedula_usuario;
	long ivaventa;
	long total_venta;
	long valor_venta;
	
	public VentaVO() {
		
	}
	
	public VentaVO(long cedula_cliente, long cedula_usuario, long ivaventa, long total_venta, long valor_venta) {
		super();
		this.cedula_cliente = cedula_cliente;
		this.cedula_usuario = cedula_usuario;
		this.ivaventa = ivaventa;
		this.total_venta = total_venta;
		this.valor_venta = valor_venta;
	}
	public long getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public long getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(long cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public long getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(long ivaventa) {
		this.ivaventa = ivaventa;
	}
	public long getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(long total_venta) {
		this.total_venta = total_venta;
	}
	public long getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(long valor_venta) {
		this.valor_venta = valor_venta;
	}

	@Override
	public String toString() {
		return "Venta [cedula_cliente=" + cedula_cliente + ", cedula_usuario=" + cedula_usuario + ", ivaventa="
				+ ivaventa + ", total_venta=" + total_venta + ", valor_venta=" + valor_venta + "]";
	}
	
	
}
