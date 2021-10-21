package co.edu.unbosque.tiendavirtualGr3.tiendavirtualfrontendGr3.vo;

public class ProductoVO {
	
	private Long codigo_producto;
	private Double ivacompra;
	private int  nitproveedor;
	private String nombre_producto;
	private Double precio_compra;
	private Double precio_venta;
	
	public ProductoVO() {
	}
	
	public ProductoVO(Long codigo_producto, Double ivacompra, int nitproveedor, String nombre_producto,
			Double precio_compra, Double precio_venta) {
		super();
		this.codigo_producto = codigo_producto;
		this.ivacompra = ivacompra;
		this.nitproveedor = nitproveedor;
		this.nombre_producto = nombre_producto;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
	}

	public Long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Double getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(Double ivacompra) {
		this.ivacompra = ivacompra;
	}

	public int getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(int nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(Double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public Double getPrecio_venta() {
		return precio_venta;
	}

	
	public void setPrecio_venta(Double precio_venta) {
		this.precio_venta = precio_venta;
	}

	@Override
	public String toString() {
		return "ProductoVO [codigo_producto=" + codigo_producto + ", ivacompra=" + ivacompra + ", nitproveedor="
				+ nitproveedor + ", nombre_producto=" + nombre_producto + ", precio_compra=" + precio_compra
				+ ", precio_venta=" + precio_venta + "]";
	}
	
	
    
}
