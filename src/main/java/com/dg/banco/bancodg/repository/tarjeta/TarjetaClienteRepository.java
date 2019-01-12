package com.dg.banco.bancodg.repository.tarjeta;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dg.banco.bancodg.entity.cliente.Cliente;
import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;

@Repository
public interface TarjetaClienteRepository extends CrudRepository<TarjetaCliente, Long> {
	
	public List<TarjetaCliente> findByCliente(Cliente cliente);

}
