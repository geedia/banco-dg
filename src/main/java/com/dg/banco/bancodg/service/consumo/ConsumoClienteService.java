package com.dg.banco.bancodg.service.consumo;

import java.util.List;
import java.util.Optional;

import com.dg.banco.bancodg.entity.consumo.ConsumoCliente;

/**
 * Interfaz para servicio ConsumoCliente
 * @author Diana Catalina
 *
 */
public interface ConsumoClienteService {
	public List<ConsumoCliente> buscarConsumosTarjetaCliente(Long idTarjeta);
	
	public void guardarConsumoCliente(ConsumoCliente consumo);

	public List<ConsumoCliente> buscarConsumosCliente(Long idCliente);

	public Optional<ConsumoCliente> buscarConsumoClientePorId(Long id);

	public void eliminarConsumoCliente(Long id);
}
