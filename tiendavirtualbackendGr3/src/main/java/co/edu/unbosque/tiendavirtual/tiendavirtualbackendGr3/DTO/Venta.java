package co.edu.unbosque.tiendavirtual.tiendavirtualbackendGr3.DTO;

public class Venta {
	
	private Long codigo_detalle_venta;
	private int cantidad_producto;
	private int  codigo_producto;
	private int codigo_venta;
	private Double valor_total;
	private Double valor_venta;
	private Double valoriva;
	
	
	
	public Venta(Long codigo_detalle_venta, int cantidad_producto, int codigo_producto, int codigo_venta,
			Double valor_total, Double valor_venta, Double valoriva) {
		super();
		this.codigo_detalle_venta = codigo_detalle_venta;
		this.cantidad_producto = cantidad_producto;
		this.codigo_producto = codigo_producto;
		this.codigo_venta = codigo_venta;
		this.valor_total = valor_total;
		this.valor_venta = valor_venta;
		this.valoriva = valoriva;
	}
	
	public Long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}
	public void setCodigo_detalle_venta(Long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}
	public int getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public int getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public int getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(int codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Double getValor_total() {
		return valor_total;
	}
	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
	public Double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public Double getValoriva() {
		return valoriva;
	}
	public void setValoriva(Double valoriva) {
		this.valoriva = valoriva;
	}

	@Override
	public String toString() {
		return "Venta [codigo_detalle_venta=" + codigo_detalle_venta + ", cantidad_producto=" + cantidad_producto
				+ ", codigo_producto=" + codigo_producto + ", codigo_venta=" + codigo_venta + ", valor_total="
				+ valor_total + ", valor_venta=" + valor_venta + ", valoriva=" + valoriva + "]";
	}
	
	
	
}
