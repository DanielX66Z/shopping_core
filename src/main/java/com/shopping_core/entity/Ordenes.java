package com.shopping_core.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordenes")
public class Ordenes {
	
	@Id
	private Integer idOrdenes;
	@ManyToOne
	private Productos productos;
	@ManyToOne
	private Clientes clientes;
		
	
	private Integer cantidad;
	private Double total;
	public Integer getIdOrdenes() {
		return idOrdenes;
	}
	public void setIdOrdenes(Integer idOrdenes) {
		this.idOrdenes = idOrdenes;
	}


	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Productos getProductos() {
		return productos;
	}
	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	public Clientes getClientes() {
		return clientes;
	}
	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	
	
	
	
	

}
