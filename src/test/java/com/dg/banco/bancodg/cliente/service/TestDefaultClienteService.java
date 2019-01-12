package com.dg.banco.bancodg.cliente.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.dg.banco.bancodg.entity.cliente.Cliente;
import com.dg.banco.bancodg.repository.cliente.ClienteRepository;

@RunWith(MockitoJUnitRunner.class)
public class TestDefaultClienteService {
	@Mock
	public ClienteRepository clienteRepository;
	
	@Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }
	 
		
	@Test
	public void guardarCliente() {
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNombre("Diana");
		cliente.setCiudad("Bogota");
		cliente.setDireccion("Alamos");
		cliente.setTelefono(52136L);
		Mockito.when(clienteRepository.save(cliente)).thenReturn(cliente);
		
	}
}
