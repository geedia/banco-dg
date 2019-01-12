package com.dg.banco.bancodg.entity.tarjeta;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.dg.banco.bancodg.entity.cliente.Cliente;
import com.dg.banco.bancodg.entity.consumo.ConsumoCliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Clase de la Entidad de Tarjetas del Cliente.
 * 
 * @author Diana Catalina
 *
 */
@Entity
@Table(name = "client_cards")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TarjetaCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_card")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "number", length = 16)
	private Long numero;

	@Column(name = "ccv", length = 4)
	private Long codigo;

	@Column(name = "card_type", length = 50)
	private String tipo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Cliente cliente;

	@JsonManagedReference
	@OneToMany(mappedBy = "tarjeta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ConsumoCliente> consumos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ConsumoCliente> getConsumos() {
		return consumos;
	}

	public void setConsumos(List<ConsumoCliente> consumos) {
		this.consumos = consumos;
	}

}
