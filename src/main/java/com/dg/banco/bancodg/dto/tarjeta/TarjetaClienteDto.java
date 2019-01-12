package com.dg.banco.bancodg.dto.tarjeta;

import java.util.List;

import com.dg.banco.bancodg.entity.cliente.Cliente;
import com.dg.banco.bancodg.entity.consumo.ConsumoCliente;

public class TarjetaClienteDto {
	private Long id;

	private Long numero;

	private Long codigo;

	private String tipo;

	private Cliente cliente;
	
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
