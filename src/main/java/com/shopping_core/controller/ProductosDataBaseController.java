package com.shopping_core.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping_core.dao.ProductosDao;
import com.shopping_core.entity.Productos;
import com.shopping_core.request.ClientesRequest;
import com.shopping_core.request.ProductosRequest;
import com.shopping_core.response.Repuesta;

@RestController
public class ProductosDataBaseController {
	
		
	@Autowired
	private ProductosDao productosDao;
	
	@GetMapping("list-productos")
	public ResponseEntity<List<Productos>> listarProductos(){
		try {
			
			return new ResponseEntity<List<Productos>>(productosDao.listarProductos(), HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<List<Productos>>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

		}
	}
	
	@PostMapping("ingresar-producto")
	public ResponseEntity<Repuesta> guardarClientes(@RequestBody ProductosRequest request) {
		Repuesta repuesta;
		try {

			repuesta = productosDao.registrarProducto(request);

			return new ResponseEntity<>(repuesta, HttpStatus.OK);

		} catch (Exception e) {
			repuesta = new Repuesta();
			repuesta.setTitle("Error en el servidor");
			repuesta.setDescripcion("Error " + e.getMessage());
			return new ResponseEntity<>(repuesta, HttpStatus.OK);

		}
	}
	

}
