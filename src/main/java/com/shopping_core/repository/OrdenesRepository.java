package com.shopping_core.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping_core.entity.Clientes;
import com.shopping_core.entity.Ordenes;

@Repository
public interface OrdenesRepository extends CrudRepository<Ordenes, Integer> {

	public List<Ordenes> findByClientes(Clientes cliente);
	@Query("SELECT MAX(idOrdenes) FROM Ordenes")
	public Integer getCorrelativoOrdenes();
}
