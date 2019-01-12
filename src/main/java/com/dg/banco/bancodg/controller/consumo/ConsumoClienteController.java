package com.dg.banco.bancodg.controller.consumo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.banco.bancodg.dto.consumo.ConsumoClienteDto;
import com.dg.banco.bancodg.entity.consumo.ConsumoCliente;
import com.dg.banco.bancodg.service.consumo.ConsumoClienteService;

/**
 * Controlador para Consumo Cliente
 * 
 * @author Diana Catalina
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/consumo")
public class ConsumoClienteController {

	@Autowired
	private ConsumoClienteService consumoClienteService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Metodo para listar todos los consumos de una tarjeta
	 * 
	 * @return
	 */
	@GetMapping("/listar/tarjeta/{idTarjeta}")
	public List<ConsumoClienteDto> listarConsumosTarjeta(@PathVariable Long idTarjeta) {
		List<ConsumoCliente> consumos = consumoClienteService.buscarConsumosTarjetaCliente(idTarjeta);

		return consumos.stream().map(consumo -> convertToDto(consumo)).collect(Collectors.toList());
	}

	/**
	 * Metodo para buscar un consumos por idCliente
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/listar/cliente/{id}")
	public List<ConsumoClienteDto> buscarConsumosCliente(@PathVariable Long id) {
		List<ConsumoCliente> consumos = this.consumoClienteService.buscarConsumosCliente(id);
		return consumos.stream().map(consumo -> convertToDto(consumo)).collect(Collectors.toList());
	}

	/**
	 * Metodo para buscar un consumos por id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ConsumoClienteDto buscarConsumo(@PathVariable Long id) {
		Optional<ConsumoCliente> consumo = consumoClienteService.buscarConsumoClientePorId(id);
		if (consumo.isPresent()) {
			return this.convertToDto(consumo.get());
		}
		return null;

	}

	/**
	 * Metodo para crear un consumo- recibe el id de la tarjeta
	 * 
	 * @param consumoClienteDto
	 * @return
	 */
	@PostMapping("/")
	public ConsumoClienteDto agregarConsumo(@RequestBody ConsumoClienteDto consumoClienteDto) {
		ConsumoCliente consumo = this.convertToEntity(consumoClienteDto);
		this.consumoClienteService.guardarConsumoCliente(consumo);
		return this.convertToDto(consumo);
		
	}

	/**
	 * Metodo para actualizar un consumo
	 * 
	 * @param consumoClienteDTO
	 * @return
	 */
	@PutMapping("/")
	public ConsumoClienteDto editarConsumo(@RequestBody ConsumoClienteDto consumoClienteDto) {
		return this.agregarConsumo(consumoClienteDto);
	}

	/**
	 * Metodo para borrar un consumo
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void eliminarConsumo(@PathVariable Long id) {
		this.consumoClienteService.eliminarConsumoCliente(id);
	}

	/**
	 * Metodo que transforma la entidad Consumo Cliente al DTO
	 * 
	 * @param consumoCliente
	 * @return
	 */
	private ConsumoClienteDto convertToDto(ConsumoCliente consumoCliente) {
		return modelMapper.map(consumoCliente, ConsumoClienteDto.class);
	}

	/**
	 * MEtodo para transformar un DTO a la entidad
	 * 
	 * @param consumoClienteDto
	 * @return
	 */
	private ConsumoCliente convertToEntity(ConsumoClienteDto consumoClienteDto) {
		return modelMapper.map(consumoClienteDto, ConsumoCliente.class);
	}

}
