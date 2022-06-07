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

import com.shopping_core.dao.OrdenesDao;

import com.shopping_core.entity.Ordenes;

import com.shopping_core.request.OrdenesRequest;
import com.shopping_core.response.Repuesta;

@RestController
public class OrdenesDataBaseController {

	
	@Autowired
	private OrdenesDao ordenDaoService;
	
	@PostMapping("/ingresar-orden")
	public ResponseEntity<Repuesta> guardarClientes(@RequestBody OrdenesRequest request) {
		Repuesta repuesta;
		try {
			System.out.println("entro a core");
			repuesta = ordenDaoService.registrarOrdenes(request);

			return new ResponseEntity<>(repuesta, HttpStatus.OK);

		} catch (Exception e) {
			repuesta = new Repuesta();
			repuesta.setTitle("Error en el servidor");
			repuesta.setDescripcion("Error " + e.getMessage());
			return new ResponseEntity<>(repuesta, HttpStatus.OK);

		}
	}
	
	@GetMapping("/list-ordenes")
	public ResponseEntity<List<Ordenes>> listarClientes() {
		try {

			return new ResponseEntity<>(ordenDaoService.listarOdenes(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

		}
	}
}
