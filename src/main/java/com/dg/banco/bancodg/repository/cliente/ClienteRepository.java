/**
 * 
 */
package com.dg.banco.bancodg.repository.cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dg.banco.bancodg.entity.cliente.Cliente;

/**
 * Interfaz para el acceso a la base de datos
 * @author Diana Catalina
 *
 */

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
