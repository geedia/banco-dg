package com.dg.banco.bancodg.dto.cliente;

import java.util.List;

import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;

/**
 * Clase DTO para la entidad clientes
 * @author Diana Catalina
 *
 */
public class ClienteDto {

	private Long id;
	
	private String nombre;

	private String direccion;

	private String ciudad;

	private Long telefono;
	
	private List<TarjetaCliente> tarjetas;
	
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

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<TarjetaCliente> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<TarjetaCliente> tarjetas) {
		this.tarjetas = tarjetas;
	}


}
