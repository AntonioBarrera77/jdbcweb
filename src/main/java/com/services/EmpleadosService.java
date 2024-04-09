package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.EmpleadosDAO;
import com.entity.Empleados;
import com.general.Status;

@Path("empleado/")

public class EmpleadosService {

	Empleados emp = null;
	EmpleadosDAO dao = null;
	
	@Path("mostrar") //endpoint -- PUNTO FINAL DE LA PETICION
	@GET //pedir datos al servidor pero de solo lectura
	@Produces({MediaType.APPLICATION_JSON})//la respuesta se recibe en formato json
	public List<Empleados> mostrar() {
		dao = new EmpleadosDAO();
		return dao.mostrar();
	}
	
	@Path("guardar")
	@POST //ayuda llevarles datos al server y persistirlos(guardarlos)
	@Consumes({MediaType.APPLICATION_JSON})//como recibe la informacion
	@Produces({MediaType.APPLICATION_JSON})//como debe responder los datos del server al cliente
	public Status guardar(Empleados item) {

		Status s = new Status();
		s.setOb(item);
		dao = new EmpleadosDAO();
		String response = dao.guardar(item);

		if (response.equals("1")) {
			s.setMensaje("Guardado exitosamente");
			s.setRespuesta(response);
		} else {
			s.setMensaje("Error al guardar");
			s.setRespuesta(response);
		}
		return s;
	}
	
	@Path("actualizar")
	@PUT //
	@Consumes({MediaType.APPLICATION_JSON})//como recibe la informacion
	@Produces({MediaType.APPLICATION_JSON})
	public Status actualizar(Empleados item) {

		Status s = new Status();
		s.setOb(item);
		dao = new EmpleadosDAO();
		String response = dao.actualizar(item);

		if (response.equals("1")) {
			s.setMensaje("Actualizar exitosamente");
			s.setRespuesta(response);
		} else {
			s.setMensaje("Error al actualizar");
			s.setRespuesta(response);
		}
		return s;
	}
	
	@Path("eliminar/{id}")//Entre llaves manda a llmara al parametro especifico que es "id"
	@DELETE 
	@Produces({MediaType.APPLICATION_JSON})
	public Status eliminar(@PathParam ("id")int id) {

		Status s = new Status();
		dao = new EmpleadosDAO();
		String response = dao.eliminar(id);

		if (response.equals("1")) {
			s.setMensaje("Eliminado exitosamente");
			s.setRespuesta(response);
		} else {
			s.setMensaje("Error al eliminar");
			s.setRespuesta(response);
		}
		return s;
	}
	
	@Path("buscar/{id}")//Entre llaves manda a llmara al parametro especifico que es "id"
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public Empleados buscar(@PathParam("id") int id) {
		dao = new EmpleadosDAO();
		return (Empleados) dao.buscar(id);
	}
}
