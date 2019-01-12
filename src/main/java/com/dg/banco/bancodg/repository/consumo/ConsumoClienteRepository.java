package com.dg.banco.bancodg.repository.consumo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dg.banco.bancodg.entity.consumo.ConsumoCliente;
import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;

@Repository
public interface ConsumoClienteRepository extends CrudRepository<ConsumoCliente, Long> {
	
	public List<ConsumoCliente> findByTarjeta(TarjetaCliente tarjeta);

}
