package com.dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.DetalleVentaDTO;
import com.dto.ProductoDTO;
import com.dto.ProductosPorClienteDTO;
import com.entity.Productos;
import com.general.Database;
import com.general.Metodos;
import com.dto.ProductoDTO;

public class ProductoDAO implements Metodos{
	
	Connection con = null;//Abre la conexión
	PreparedStatement ps = null;//Lleva las instrucciones o setencias a la base 
	ResultSet rs = null;// Trae los datos de la db
	
	Productos prod = null; // comodin para manipular las respuestas cada operacion
	Database db = new Database();
	
	String respuesta;
	@Override
	public String guardar(Object obj) {
		prod = (Productos) obj;
		
		String query ="INSERT INTO PRODUCTOS (DEPTO_ID, NOMBRE, FECHA_CAD, PRECIO_COMPRA,PRECIO_VENTA,REFRIGERADO) VALUES(?,?,?,?,?,?)";
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(query);
			
			ps.setInt(1, prod.getDeptoId());
			ps.setString(2, prod.getNombre());
			ps.setDate(3, prod.getFechaCaducidad());
			ps.setDouble(4, prod.getPrecioCompra());
			ps.setDouble(5, prod.getPrecioVenta());
			ps.setString(6, Character.toString(prod.getRefrigerado()));
			
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Insercion OK");
				respuesta = "1";
			}else {
				System.out.println("Error");
				respuesta="0";
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			respuesta=ex.getMessage();
			
		}
		return respuesta;
	}

	@Override
	public String actualizar(Object obj) {
		prod = (Productos) obj;
		String query ="UPDATE PRODUCTOS SET DEPTO_ID = ?, NOMBRE = ?, FECHA_CAD = ?, PRECIO_COMPRA = ?,PRECIO_VENTA = ? ,REFRIGERADO = ?"
				+  "WHERE PRODUCTO_id = ?";
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(query);
			
			ps.setInt(1, prod.getDeptoId());
			ps.setString(2, prod.getNombre());
			ps.setDate(3, prod.getFechaCaducidad());
			ps.setDouble(4, prod.getPrecioCompra());
			ps.setDouble(5, prod.getPrecioVenta());
			ps.setString(6, Character.toString(prod.getRefrigerado()));
			ps.setInt(7, prod.getProductoId());
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Actualizacion OK");
				respuesta = "1";
			}else {
				System.out.println("Error");
				respuesta="0";
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			respuesta=ex.getMessage();
			
		}
		return respuesta;
	}

	@Override
	public Object buscar(int id) {
		String query = "SELECT *  FROM PRODUCTOS WHERE PRODUCTO_ID="+id;
		try {
		
		Class.forName(db.getDriver());
		con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			prod = new Productos(rs.getInt("PRODUCTO_ID"), rs.getInt("DEPTO_ID"), rs.getString("NOMBRE"), rs.getDate("FECHA_CAD"), 
								rs.getDouble("PRECIO_COMPRA"), rs.getDouble("PRECIO_VENTA"),rs.getString("REFRIGERADO").charAt(0));
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return prod;
	}

	@Override
	public String eliminar(int id) {
		String query = "DELETE PRODUCTOS WHERE PRODUCTO_ID ="+id;
		
		try {
			Class.forName(db.getDriver());
			con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
			ps = con.prepareStatement(query);
			int x = ps.executeUpdate();
			
			if(x>0) {
				System.out.println("Eliminacion OK");
				respuesta = "1";
			}else {
				System.out.println("Error");
				respuesta="0";
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			respuesta=ex.getMessage();
			
		}
	
		return respuesta;
	}

	@Override
	public List mostrar() {
		String query = "SELECT *  FROM PRODUCTOS";
		List<Productos> productos = new ArrayList<Productos>();
		try {
		
		Class.forName(db.getDriver());
		con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			prod = new Productos(rs.getInt("PRODUCTO_ID"), rs.getInt("DEPTO_ID"), rs.getString("NOMBRE"), rs.getDate("FECHA_CAD"), 
								rs.getDouble("PRECIO_COMPRA"), rs.getDouble("PRECIO_VENTA"),rs.getString("REFRIGERADO").charAt(0));
			productos.add(prod);
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return productos;
	}
	
	
	public Productos getProductoMasCaro() {
		String query = "SELECT * FROM PRODUCTOS WHERE PRECIO_ = (SELECT MAX(PRECIO_COMPRA) FROM PRODUCTOS)";
		try {
		
		Class.forName(db.getDriver());
		con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			prod = new Productos(rs.getInt("PRODUCTO_ID"), rs.getInt("DEPTO_ID"), rs.getString("NOMBRE"), rs.getDate("FECHA_CAD"), 
								rs.getDouble("PRECIO_COMPRA"), rs.getDouble("PRECIO_VENTA"),rs.getString("REFRIGERADO").charAt(0));
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return prod;
		
	}
	
	
	public Double getSuma() {
		double suma = 0;
		String query = "SELECT SUM (PRECIO_COMPRA) AS SUMATORIA FROM PRODUCTOS";
		try {
		Class.forName(db.getDriver());
		con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			suma = rs.getDouble("SUMATORIA");
		}
		
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return suma;
		
	}
	
	public List<ProductoDTO> productosInvDepto(){
		ProductoDTO dto = null;
		String query = "SELECT D.NOMBRE AS DEPTO, P.NOMBRE AS PRODUCTO, P.PRECIO_COMPRA, P.REFRIGERADO, I.STOCK, I.FECHA "
				+ "FROM PRODUCTOS P INNER JOIN INVENTARIO I "
				+ "ON P.PRODUCTO_ID = I.PRODUCTO_ID "
				+ "INNER JOIN DEPARTAMENTO D "
				+ "ON D.DEPTO_ID = P.DEPTO_ID WHERE REFRIGERADO = 'Y'";
	
		List<ProductoDTO> detalles = new ArrayList<ProductoDTO>();
		try {
		
		Class.forName(db.getDriver());
		con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			dto = new ProductoDTO(rs.getString("DEPTO"), rs.getString("PRODUCTO"),rs.getInt("PRECIO_COMPRA"), rs.getString("REFRIGERADO").charAt(0), 
								rs.getInt("STOCK"), rs.getDate("FECHA"));
			detalles.add(dto);
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}	
		return detalles;
	}
	
	public ProductosPorClienteDTO productosPorClienteDTO(String nombre){
		String cliente = "";
		ProductosPorClienteDTO pcl = null;
		DetalleVentaDTO dtv = null;
		String query = "SELECT C.NOMBRE AS CUSTOMER, V.FECHA_VENTA, DT.CANTIDAD, P.NOMBRE AS PRODUCTO  "
				+ "FROM CUSTOMERS C INNER JOIN VENTAS V "
				+ "ON C.CLIENTE_ID = V.CLIENTE_ID "
				+ "INNER JOIN DET_VENTA DT "
				+ "ON V.VENTA_ID = DT.VENTA_ID "
				+ "INNER JOIN PRODUCTOS P "
				+ "ON P.PRODUCTO_ID = DT.PRODUCTO_ID WHERE C.NOMBRE = '"+nombre+"'";
	
		List<DetalleVentaDTO> detalles = new ArrayList<DetalleVentaDTO>();
		try {
		
		Class.forName(db.getDriver());
		con = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			dtv = new DetalleVentaDTO(rs.getDate("FECHA_VENTA"),rs.getInt("CANTIDAD"),rs.getString("PRODUCTO"));
			detalles.add(dtv);
			cliente = rs.getString("CUSTOMER");
		}
			pcl = new ProductosPorClienteDTO(cliente, detalles);		
			}catch(Exception ex){
				ex.printStackTrace();
			}	
		return pcl;
	}
}
