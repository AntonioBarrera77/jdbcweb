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

import com.dao.ProductoDAO;
import com.dto.DetalleVentaDTO;
import com.dto.ProductoDTO;
import com.dto.ProductosPorClienteDTO;
import com.entity.Productos;
import com.general.Status;
@Path("producto/") //Establece una ruta a nivel de clase de servicio

public class ProductoService {

	Productos prod = null;
	ProductoDAO dao = null;
	
	@Path("mostrar") //endpoint -- PUNTO FINAL DE LA PETICION
	@GET //pedir datos al servidor pero de solo lectura
	@Produces({MediaType.APPLICATION_JSON})//la respuesta se recibe en formato json
	public List<Productos> mostrar() {
		dao = new ProductoDAO();
		return dao.mostrar();
	}
	
	@Path("guardar")
	@POST //ayuda llevarles datos al server y persistirlos(guardarlos)
	@Consumes({MediaType.APPLICATION_JSON})//como recibe la informacion
	@Produces({MediaType.APPLICATION_JSON})//como debe responder los datos del server al cliente
	public Status guardar(Productos item) {

		Status s = new Status();
		s.setOb(item);
		dao = new ProductoDAO();
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
	public Status actualizar(Productos item) {

		Status s = new Status();
		s.setOb(item);
		dao = new ProductoDAO();
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
		dao = new ProductoDAO();
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
	public Productos buscar(@PathParam("id") int id) {
		dao = new ProductoDAO();
		return (Productos) dao.buscar(id);
	}
	
	@Path("producto-caro")//Entre llaves manda a llamara al parametro especifico que es "id"
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public Productos getProductoCaro() {
		dao = new ProductoDAO();
		return dao.getProductoMasCaro();
	}
	
	@Path("sumatoria")//Entre llaves manda a llamara al parametro especifico que es "id"
	@GET 
	@Produces({MediaType.APPLICATION_JSON})
	public double getSum() {
		dao = new ProductoDAO();
		return dao.getSuma();
	}
	
	@Path("consultar") //endpoint -- PUNTO FINAL DE LA PETICION
	@GET //pedir datos al servidor pero de solo lectura
	@Produces({MediaType.APPLICATION_JSON})//la respuesta se recibe en formato json
	public List<ProductoDTO> consulta() {
		dao = new ProductoDAO();
		return dao.productosInvDepto();
	}
	
	@Path("detalle/{nombre}") 
	 @GET  
	 @Produces({MediaType.APPLICATION_JSON})  
	 public ProductosPorClienteDTO detalle(@PathParam("nombre")String nombre) 
	 { 
	  dao=new ProductoDAO(); 
	  return dao.productosPorClienteDTO(nombre); 
	 }
	

}
