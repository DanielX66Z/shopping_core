package com.shopping_core.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping_core.entity.Clientes;
import com.shopping_core.entity.Ordenes;
import com.shopping_core.entity.Productos;
import com.shopping_core.repository.ClientesRepository;
import com.shopping_core.repository.OrdenesRepository;
import com.shopping_core.repository.ProductosRepository;
import com.shopping_core.request.OrdenesRequest;
import com.shopping_core.request.ProductosRequest;
import com.shopping_core.response.Repuesta;

@Service
public class OrdenesDao {

	@Autowired
	private OrdenesRepository ordenesRepository;

	@Autowired
	private ClientesRepository clientesRepository;
	@Autowired
	private ProductosRepository productosRepository;

	/**
	 * Obtiene todas las ordenes
	 * 
	 * @param idCliente
	 * @return
	 */
	public List<Ordenes> buscarOrdenesByCliente(Integer idCliente) {

		try {
			Clientes clientes = clientesRepository.findByIdCliente(idCliente);

			return ordenesRepository.findByClientes(clientes);

		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public List<Ordenes> listarOdenes() {

		try {
		

			List<Ordenes> ordenesList= new ArrayList<>();
		    ordenesRepository.findAll().forEach(ordenesList::add);
			return ordenesList;

		} catch (Exception e) {
			return new ArrayList<>();
		}
	}

	public Repuesta registrarOrdenes(OrdenesRequest request) {
		try {
			// validar cliente
			Clientes cliente = clientesRepository.findByIdCliente(request.getIdCliente());
			if (cliente != null) {
				for (ProductosRequest producto : request.getProductos()) {
					Ordenes ordenes = new Ordenes();
					System.out.println("orden id "+ordenesRepository.getCorrelativoOrdenes());
					ordenes.setIdOrdenes(ordenesRepository.getCorrelativoOrdenes()+1);
					Productos productoDb = new Productos();
					productoDb = productosRepository.findByIdProducto(producto.getIdProducto());
					ordenes.setClientes(cliente);
					ordenes.setProductos(productoDb);
					ordenes.setTotal(request.getTotal());
					ordenes.setCantidad(request.getCantidad());

					ordenesRepository.save(ordenes);
				}
				Repuesta repuesta = new Repuesta();
				repuesta.setDescripcion("Orden registrada");
				repuesta.setTitle("Exitoso");
				return repuesta;

			} else {
				return null;
			}

		} catch (Exception e) {
			// error registrando orden
			return null;
		}
	}
}
