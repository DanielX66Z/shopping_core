package com.shopping_core.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clientes")
public class Clientes {
	@Id
	private Integer idCliente;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "direccion")
	private String direccion;
	@JsonIgnore
	@OneToMany(mappedBy = "clientes")
	private List<Ordenes> ordenes;
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Ordenes> getOrdenes() {
		return ordenes;
	}
	public void setOrdenes(List<Ordenes> ordenes) {
		this.ordenes = ordenes;
	}

	
	

}
