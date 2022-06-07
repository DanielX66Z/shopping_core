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

import com.shopping_core.dao.ClientesDao;
import com.shopping_core.entity.Clientes;
import com.shopping_core.request.ClientesRequest;
import com.shopping_core.response.Repuesta;

@RestController
public class ClientesDataBaseController {

	@Autowired
	ClientesDao clientesService;

	@PostMapping("ingresar-cliente")
	public ResponseEntity<Repuesta> guardarClientes(@RequestBody ClientesRequest request) {
		Repuesta repuesta;
		try {

			repuesta = clientesService.guardarCliente(request);

			return new ResponseEntity<>(repuesta, HttpStatus.OK);

		} catch (Exception e) {
			repuesta = new Repuesta();
			repuesta.setTitle("Error en el servidor");
			repuesta.setDescripcion("Error " + e.getMessage());
			return new ResponseEntity<>(repuesta, HttpStatus.OK);

		}
	}

	@GetMapping("list-clientes")
	public ResponseEntity<List<Clientes>> listarClientes() {
		try {

			return new ResponseEntity<>(clientesService.listarClientes(), HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

		}
	}
	
	
	

}
