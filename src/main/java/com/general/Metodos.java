package com.general;

import java.util.List;

import com.entity.Productos;

public interface Metodos {
	
	String guardar(Object obj); ///MOSTRAR
	String actualizar(Object obj);///ACTUALIZAR
	Object buscar(int id);///BUSCAR/ID
	String eliminar(int id);///ELIMINAR/ID
	List mostrar();///MOSTRAR
}
