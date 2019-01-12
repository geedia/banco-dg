package com.dg.banco.bancodg.entity.cliente;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "clients")
/**
 * Clase para manejar la entidad Clientes
 * 
 * @author Diana Catalina
 *
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_client")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name", length=50, nullable=false)
	private String nombre;

	@Column(name="address", length=100, nullable=false)
	private String direccion;

	@Column (name="city", length=30, nullable=false)
	private String ciudad;

	@Column(name="phone")
	private Long telefono;
	
	@JsonManagedReference
	@OneToMany(mappedBy="cliente",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<TarjetaCliente> tarjetas;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<TarjetaCliente> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<TarjetaCliente> tarjetas) {
		this.tarjetas = tarjetas;
	}

}
