package com.entity;

import java.sql.Date;

public class Productos {
	int productoId;
	int deptoId;
	String nombre;
	Date fechaCaducidad;
	double precioCompra;
	double precioVenta;
	char refrigerado;
	
	public Productos() {
		
	}

	public Productos(int productoId, int deptoId, String nombre, Date fechaCaducidad, double precioCompra, double precioVenta,
			char refrigerado) {
		super();
		this.productoId = productoId;
		this.deptoId = deptoId;
		this.nombre = nombre;
		this.fechaCaducidad = fechaCaducidad;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.refrigerado = refrigerado;
	}

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public int getDeptoId() {
		return deptoId;
	}

	public void setDeptoId(int deptoId) {
		this.deptoId = deptoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(int precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	public char getRefrigerado() {
		return refrigerado;
	}

	public void setRefrigerado(char refrigerado) {
		this.refrigerado = refrigerado;
	}

	@Override
	public String toString() {
		return "Productos [productoId=" + productoId + ", deptoId=" + deptoId + ", nombre=" + nombre
				+ ", fechaCaducidad=" + fechaCaducidad + ", precioCompra=" + precioCompra + ", precioVenta="
				+ precioVenta + ", refrigerado=" + refrigerado + "]";
	}
	
	
	
	
	
	
	
}
