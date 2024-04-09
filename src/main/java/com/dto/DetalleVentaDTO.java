package com.dto;

import java.sql.Date;

public class DetalleVentaDTO {
	Date fecha;
	int cantidad;
	String productos;
	
	public DetalleVentaDTO() {
		super();
	}

	public DetalleVentaDTO(Date fecha, int cantidad, String productos) {
		super();
		this.fecha = fecha;
		this.cantidad = cantidad;
		this.productos = productos;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getProductos() {
		return productos;
	}

	public void setProductos(String productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "DetalleVentaDTO [fecha=" + fecha + ", cantidad=" + cantidad + ", productos=" + productos + "]";
	}
	
	
	
}
