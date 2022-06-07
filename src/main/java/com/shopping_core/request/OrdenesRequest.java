package com.shopping_core.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shopping_core.entity.Productos;

public class OrdenesRequest {
	
	private Integer idCliente;
	private Double total;
	private Integer cantidad;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private List<ProductosRequest> productos;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public List<ProductosRequest> getProductos() {
		return productos;
	}
	public void setProductos(List<ProductosRequest> productos) {
		this.productos = productos;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	
	
	
	
	
}
