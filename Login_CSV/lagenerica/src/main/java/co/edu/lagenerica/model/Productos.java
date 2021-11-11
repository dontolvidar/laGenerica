package co.edu.lagenerica.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "productos")
public class Productos {
	@Id
	private long codigo;
	private String nombre;
	private long nit_proveedor;
	private double precio_compra,iva,precio_venta;
	
	
	
	public Productos(long codigo, String nombre, long nit_proveedor, double precio_compra, double iva,double precio_venta) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.nit_proveedor = nit_proveedor;
		this.precio_compra = precio_compra;
		this.iva = iva;
		this.precio_venta = precio_venta;
	}
	public long getCodigo() {
		return codigo;
	}
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public long getNit_proveedor() {
		return nit_proveedor;
	}
	public void setNit_proveedor(long nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}
	public double getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", nombre=" + nombre + ", nit_proveedor=" + nit_proveedor
				+ ", precio_compra=" + precio_compra + ", iva=" + iva + ", precio_venta=" + precio_venta + "]";
	}
	
	
}
