package com.dg.banco.bancodg.service.tarjeta;

import java.util.List;
import java.util.Optional;

import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;

/**
 * Interfaz para el servicio TarjetaCliente
 * 
 * @author Diana Catalina
 *
 */
public interface TarjetaClienteService {
	public List<TarjetaCliente> buscarTarjetasPorCliente(Long idCliente);

	public Optional<TarjetaCliente> buscarTarjeta(Long id);

	public void guardarTarjeta(TarjetaCliente tarjeta);

	public void eliminarTarjeta(Long id);

}
