package com.shopping_core.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping_core.entity.Clientes;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Integer> {
	
	Clientes findByIdCliente(Integer idCliente);
	@Query("SELECT MAX(idCliente) FROM Clientes")
	public Integer getCorrelativo();
}
