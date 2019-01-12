package com.dg.banco.bancodg.cliente.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.dg.banco.bancodg.dto.cliente.ClienteDto;
import com.dg.banco.bancodg.entity.cliente.Cliente;

/**
 * Test para verificar que la transformacion de la entidad al DTO y visceversa se realice correctamente
 * @author Diana Catalina
 *
 */
public class ClienteDtoTest {

	private ModelMapper modelMapper = new ModelMapper();

	@Test
	public void convertirClienteAClienteDto_ok() {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNombre("Diana");
		cliente.setDireccion("Portales");
		cliente.setCiudad("Cartagena");
		cliente.setTelefono(652314L);

		ClienteDto clienteDto = modelMapper.map(cliente, ClienteDto.class);
		assertEquals(cliente.getId(), clienteDto.getId());
		assertEquals(cliente.getNombre(), clienteDto.getNombre());
		assertEquals(cliente.getDireccion(), clienteDto.getDireccion());
		assertEquals(cliente.getCiudad(), clienteDto.getCiudad());
	}

	@Test
	public void convertirClienteDtoACliente_ok() {
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setNombre("Julian");
		clienteDto.setDireccion("Caracoles");
		clienteDto.setCiudad("Bogota");
		clienteDto.setTelefono(121215L);

		Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
		assertEquals(clienteDto.getNombre(), cliente.getNombre());
		assertEquals(clienteDto.getDireccion(), cliente.getDireccion());
		assertEquals(clienteDto.getCiudad(), cliente.getCiudad());
		assertEquals(clienteDto.getTelefono(), cliente.getTelefono());
	}
}
