package com.dto;

import java.sql.Date;

public class ProductoDTO {
	String depto, producto;
	int precioCompra;
	char refigerado;
	int stock;
	Date fecha;
	
	public ProductoDTO() {

	}

	public ProductoDTO(String depto, String producto, int precioCompra, char refigerado, int stock, Date fecha) {
		super();
		this.depto = depto;
		this.producto = producto;
		this.precioCompra = precioCompra;
		this.refigerado = refigerado;
		this.stock = stock;
		this.fecha = fecha;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(int precioCompra) {
		this.precioCompra = precioCompra;
	}

	public char getRefigerado() {
		return refigerado;
	}

	public void setRefigerado(char refigerado) {
		this.refigerado = refigerado;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "ProductoDTO [depto=" + depto + ", producto=" + producto + ", precioCompra=" + precioCompra
				+ ", refigerado=" + refigerado + ", stock=" + stock + ", fecha=" + fecha + "]";
	}
}
