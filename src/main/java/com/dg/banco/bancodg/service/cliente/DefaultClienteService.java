package com.dg.banco.bancodg.service.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.banco.bancodg.entity.cliente.Cliente;
import com.dg.banco.bancodg.repository.cliente.ClienteRepository;

/**
 * Clase servicio del Cliente
 * @author Diana Catalina
 *
 */
@Service
public class DefaultClienteService implements ClienteService {

	@Autowired
	public ClienteRepository clienteRepository;
	
	@Override
	public void guardarCliente(Cliente cliente) {
		// Metodo para guardar/editar cliente
		clienteRepository.save(cliente);

	}

	@Override
	public List<Cliente> listarClientes() {
		// Metodo para listar todos los clientes
		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Optional<Cliente> buscarClientePorId(Long id) {
		// Metod para buscar un cliente
		return clienteRepository.findById(id);
	}

	@Override
	public void eliminarCliente(Long id) {
		// Metodo para eliminar un cliente
		clienteRepository.deleteById(id);
	}


}
