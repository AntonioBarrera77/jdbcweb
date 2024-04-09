package com.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductosPorClienteDTO {
	String nombre;
	List<DetalleVentaDTO>  detalles = new ArrayList<DetalleVentaDTO>();
	
	public ProductosPorClienteDTO() {
		super();
	}

	public ProductosPorClienteDTO(String nombre, List<DetalleVentaDTO> detalles) {
		super();
		this.nombre = nombre;
		this.detalles = detalles;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<DetalleVentaDTO> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVentaDTO> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "ProductosPorClienteDTO [nombre=" + nombre + ", detalles=" + detalles + "]";
	}
	
	
	
	
	
}
