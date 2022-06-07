package com.shopping_core.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping_core.entity.Clientes;
import com.shopping_core.repository.ClientesRepository;
import com.shopping_core.request.ClientesRequest;
import com.shopping_core.response.Repuesta;

@Service
public class ClientesDao {

	@Autowired
	private ClientesRepository clientesRepository;

	public Clientes findClientesById(Integer id) {
		try {
			return clientesRepository.findByIdCliente(id);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Guardar cliente se asignara del request a un objecto de la base
	 * 
	 * @param clienteRequest
	 * @return
	 */
	public Repuesta guardarCliente(ClientesRequest clienteRequest) {
		Repuesta repuesta;
		try {
			Clientes clientes = new Clientes();
			clientes.setIdCliente(clientesRepository.getCorrelativo()+1);
			clientes.setDireccion(clienteRequest.getDireccion());
			clientes.setNombre(clienteRequest.getNombre());

			clientesRepository.save(clientes);
			repuesta = new Repuesta();
			repuesta.setTitle("Exitoso");
			repuesta.setDescripcion("Registro correctamente");
			
			return repuesta;
		} catch (Exception e) {
			repuesta = new Repuesta();
			repuesta.setTitle("Error en registro");
			repuesta.setDescripcion("Error "+e.getMessage());
			return repuesta;
		}
	}

	/**
	 * actualizar cliente se asignara del request a un objecto de la base
	 * 
	 * @param clienteRequest
	 * @return
	 */
	public Clientes actualizarrCliente(ClientesRequest clienteRequest, Integer id) {
		try {

			Clientes clientes = clientesRepository.findByIdCliente(id);
			if (clientes != null) {
				clientes.setDireccion(clienteRequest.getDireccion());
				clientes.setNombre(clienteRequest.getNombre());

				return clientesRepository.save(clientes);

			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Listar todo los clientes
	 * @return listClientes o null
	 */
	public List<Clientes> listarClientes(){
		try {
			List<Clientes> listClientes= new ArrayList<>();
			 clientesRepository.findAll().forEach(listClientes::add);
			return listClientes;
			
		}catch(Exception e) {
			return new ArrayList<>();
		}
	}

}
