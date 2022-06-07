package com.shopping_core.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopping_core.entity.Productos;


@Repository
public interface ProductosRepository extends CrudRepository<Productos, Integer> {

	Productos findByIdProducto(Integer idProducto);
	@Query("SELECT MAX(idProducto) FROM Productos")
	public Integer getCorrelativoProductos();
}
