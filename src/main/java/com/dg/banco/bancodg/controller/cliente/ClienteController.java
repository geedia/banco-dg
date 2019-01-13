package com.dg.banco.bancodg.controller.cliente;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.banco.bancodg.dto.cliente.ClienteDto;
import com.dg.banco.bancodg.entity.cliente.Cliente;
import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;
import com.dg.banco.bancodg.service.cliente.ClienteService;
import com.dg.banco.bancodg.service.tarjeta.TarjetaClienteService;

/**
 * Clase Controladora para clientes
 * 
 * @author Diana Catalina
 *
 */
@CrossOrigin(origins= {"http://10.10.10.100:80"})
@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TarjetaClienteService tarjetaClienteService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Metodo para crear un cliente.
	 * 
	 * @param cliente
	 */

	@PostMapping("/")
	public ClienteDto crearCliente(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = convertToEntity(clienteDto);
		clienteService.guardarCliente(cliente);
		return this.convertToDto(cliente);
	}

	/**
	 * Metodo para listar todos los clientes
	 * 
	 * @return
	 */
	@GetMapping("/listar")
	public List<ClienteDto> listarClientes() {
		List<Cliente> clientes = clienteService.listarClientes();
		for (Cliente c:clientes) {
			c.setTarjetas(this.buscarTarjetasCliente(c));
		}
		return clientes.stream().map(cliente -> convertToDto(cliente)).collect(Collectors.toList());
	}

	/**
	 * Metodo para listar la informacion de un cliente
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ClienteDto buscarCliente(@PathVariable Long id) {
		ClienteDto clienteDto = null;
		Optional<Cliente> cliente = clienteService.buscarClientePorId(id);
		if (cliente.isPresent()) {
			clienteDto = convertToDto(cliente.get());
		}
		return clienteDto;
	}
	

	/**
	 * Metodo para actualizar un cliente
	 * @param clienteDto
	 * @return
	 */
	@PutMapping("/")
	public ClienteDto editarAsesor(@RequestBody ClienteDto clienteDto) {
		Cliente cliente = this.convertToEntity(clienteDto);
		this.clienteService.guardarCliente(cliente);
		return this.convertToDto(cliente);
	}
	
	/**
	 * Metodo para borrar un cliente
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void eliminarCliente(@PathVariable Long id) {
		this.clienteService.eliminarCliente(id);
	}
	
	/**
	 * Metodo que transforma la entidad Cliente al DTO
	 * 
	 * @param cliente
	 * @return
	 */
	private ClienteDto convertToDto(Cliente cliente) {
		return modelMapper.map(cliente, ClienteDto.class);
	}

	/**
	 * Metodo que transforma el DTO a la entidad Cliente
	 * 
	 * @param clienteDto
	 * @return
	 * @throws ParseException
	 */

	private Cliente convertToEntity(ClienteDto clienteDto) {
		return modelMapper.map(clienteDto, Cliente.class);
	}
	
	/**
	 * Metodo para consultar las tarjetas de un cliente
	 */
	private List<TarjetaCliente> buscarTarjetasCliente(Cliente cliente){
		return tarjetaClienteService.buscarTarjetasPorCliente(cliente.getId());
	}

}
