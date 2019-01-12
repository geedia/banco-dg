package com.dg.banco.bancodg.service.cliente;

import java.util.List;

import java.util.Optional;

import com.dg.banco.bancodg.entity.cliente.Cliente;

/**
 * Interfaz para el servicio cliente
 * 
 * @author Diana Catalina
 *
 */
public interface ClienteService {
	public void guardarCliente(Cliente cliente);

	public List<Cliente> listarClientes();

	public Optional<Cliente> buscarClientePorId(Long id);

	public void eliminarCliente(Long id);
}
