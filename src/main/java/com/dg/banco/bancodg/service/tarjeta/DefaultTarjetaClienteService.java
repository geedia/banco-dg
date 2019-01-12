package com.dg.banco.bancodg.service.tarjeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.banco.bancodg.entity.cliente.Cliente;
import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;
import com.dg.banco.bancodg.repository.cliente.ClienteRepository;
import com.dg.banco.bancodg.repository.tarjeta.TarjetaClienteRepository;

/**
 * Clase servicio de TarjetaCliente
 * @author Diana Catalina
 *
 */
@Service
public class DefaultTarjetaClienteService implements TarjetaClienteService {

	@Autowired
	private TarjetaClienteRepository tarjetaClienteRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<TarjetaCliente> buscarTarjetasPorCliente(Long idCliente) {
		//Metodo para buscar las tarjetas de un Cliente
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		if(cliente.isPresent()) {
			return tarjetaClienteRepository.findByCliente(cliente.get());
		}
		return new ArrayList<>();
	}

	@Override
	public Optional<TarjetaCliente> buscarTarjeta(Long id) {
		//Metodo para buscar una tajeta por id
		return this.tarjetaClienteRepository.findById(id);
	}

	@Override
	public void guardarTarjeta(TarjetaCliente tarjeta) {
		//Metodo para guardar o editar una tarjeta
		this.tarjetaClienteRepository.save(tarjeta);
		
	}

	@Override
	public void eliminarTarjeta(Long id) {
		// Metodo para eliminar una tarjeta
		this.tarjetaClienteRepository.deleteById(id);
		
	}
	
}
