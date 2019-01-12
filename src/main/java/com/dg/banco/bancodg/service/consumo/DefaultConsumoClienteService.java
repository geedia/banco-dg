package com.dg.banco.bancodg.service.consumo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.banco.bancodg.entity.cliente.Cliente;
import com.dg.banco.bancodg.entity.consumo.ConsumoCliente;
import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;
import com.dg.banco.bancodg.repository.cliente.ClienteRepository;
import com.dg.banco.bancodg.repository.consumo.ConsumoClienteRepository;
import com.dg.banco.bancodg.repository.tarjeta.TarjetaClienteRepository;

/**
 * Servicio para consumo cliente
 * @author Diana Catalina
 *
 */
@Service
public class DefaultConsumoClienteService implements ConsumoClienteService {

	@Autowired
	private ConsumoClienteRepository consumoClienteRepository;
	
	@Autowired
	private TarjetaClienteRepository tarjetaClienteRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<ConsumoCliente> buscarConsumosTarjetaCliente(Long idTarjeta) {
		// Metodo para buscar los consumos por tarjeta
		Optional<TarjetaCliente> tarjeta = this.tarjetaClienteRepository.findById(idTarjeta);
		if(tarjeta.isPresent()) {
			return consumoClienteRepository.findByTarjeta(tarjeta.get());
		}
		return new ArrayList<>();
	}

	@Override
	public void guardarConsumoCliente(ConsumoCliente consumo) {
		// Metodo para guardar o editar consumos
		this.consumoClienteRepository.save(consumo);
		
	}

	@Override
	public List<ConsumoCliente> buscarConsumosCliente(Long idCliente) {
		// Metodo para buscar todos los consumos de un cliente
		List<ConsumoCliente> consumos = new ArrayList<>();
		Optional<Cliente> cliente = this.clienteRepository.findById(idCliente);
		if(cliente.isPresent()) {
			List<TarjetaCliente> tarjetas = this.tarjetaClienteRepository.findByCliente(cliente.get());
			if(!tarjetas.isEmpty()) {
				for(TarjetaCliente tarjeta: tarjetas) {
					List<ConsumoCliente> consumoTarjeta = this.buscarConsumosTarjetaCliente(tarjeta.getId());
					if(!consumoTarjeta.isEmpty()) {
						for(ConsumoCliente consumo:consumoTarjeta) {
							consumos.add(consumo);
						}
					}
				}
			}
		}
		return consumos;
	}

	@Override
	public Optional<ConsumoCliente> buscarConsumoClientePorId(Long id) {
		// Metodo para buscar consumo por ID
		return this.consumoClienteRepository.findById(id);
	}

	@Override
	public void eliminarConsumoCliente(Long id) {
		// Metodo para eliminar un consumo
		this.consumoClienteRepository.deleteById(id);
		
	}

}
