package com.shopping_core.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping_core.entity.Productos;
import com.shopping_core.repository.ProductosRepository;
import com.shopping_core.request.ProductosRequest;
import com.shopping_core.response.Repuesta;

@Service
public class ProductosDao {

	@Autowired
	private ProductosRepository productosRepository;
	
	/**
	 * Registra producto 
	 * @param request
	 * @return Repuesta
	 */
	public Repuesta registrarProducto(ProductosRequest request) {
		Repuesta repuesta;
		try {
			Productos productos = new Productos();
			productos.setIdProducto(productosRepository.getCorrelativoProductos()+1);
			productos.setDescripcion(request.getDescripcion());
			productos.setExistencia(request.getExistencia());
			productos.setPrecio(request.getPrecio());
			productos.setNombre(request.getNombre());
			
			productosRepository.save(productos);
			
			repuesta = new Repuesta();
			repuesta.setTitle("Exitoso");
			repuesta.setDescripcion("Guardado existoso");
			
			return repuesta;
		}catch(Exception e) {
			repuesta = new Repuesta();
			repuesta.setTitle("Error en registrar el dato");
			repuesta.setDescripcion("Error "+e.getMessage());
			return repuesta;
		}
	
		
	}
	
	
	public List<Productos> listarProductos(){
		try {
			
			List<Productos> listProductos= new ArrayList<>();
			 productosRepository.findAll().forEach(listProductos::add);
			 
			 return listProductos;
		}catch(Exception e) {
			return new ArrayList<>();
		}
	}
	
	
}
