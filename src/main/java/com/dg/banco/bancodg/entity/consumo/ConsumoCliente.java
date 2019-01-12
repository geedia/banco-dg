package com.dg.banco.bancodg.entity.consumo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "consumption_client")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ConsumoCliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_consumption")
	private Long id;
	
	@Column(name="description", length=100)
	private String descripcion;
	
	@Column(name="amount", length=12)
	private Long monto;
	
	@Column(name="create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private TarjetaCliente tarjeta;
	
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
