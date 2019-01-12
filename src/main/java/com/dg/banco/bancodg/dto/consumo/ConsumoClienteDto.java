package com.dg.banco.bancodg.dto.consumo;

import java.util.Date;

import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;

public class ConsumoClienteDto {
	private Long id;
	private String descripcion;
	private Long monto;
	private TarjetaCliente tarjeta;
	private Date fecha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getMonto() {
		return monto;
	}

	public void setMonto(Long monto) {
		this.monto = monto;
	}

	public TarjetaCliente getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(TarjetaCliente tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
