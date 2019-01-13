package com.dg.banco.bancodg.controller.tarjeta;

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

import com.dg.banco.bancodg.dto.tarjeta.TarjetaClienteDto;
import com.dg.banco.bancodg.entity.tarjeta.TarjetaCliente;
import com.dg.banco.bancodg.service.tarjeta.TarjetaClienteService;

/**
 * Clase Controladora de tarjetaCliente
 * @author Diana Catalina
 *
 */
@CrossOrigin(origins= {"http://10.10.10.100:80"})
@RestController
@RequestMapping("/tarjeta")
public class TarjetaClienteController {
	
	@Autowired
	private TarjetaClienteService tarjetaClienteService;
	
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * MEtodo para buscar tarjeta por ID
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public TarjetaClienteDto buscarTarjeta(@PathVariable Long id) {
		Optional<TarjetaCliente> tarjeta = this.tarjetaClienteService.buscarTarjeta(id);
		if(tarjeta.isPresent()) {
			return this.convertToDto(tarjeta.get());
		}
		return null;
		
	}
	
	/**
	 * MEtodo para buscar tarjeta por IDCliente
	 * @param id
	 * @return
	 */
	@GetMapping("/cliente/{id}")
	public List<TarjetaClienteDto> buscarTarjetasCliente(@PathVariable Long id) {
		List<TarjetaCliente> tarjetas = this.tarjetaClienteService.buscarTarjetasPorCliente(id);
		return tarjetas.stream().map(tarjeta -> convertToDto(tarjeta)).collect(Collectors.toList());
		
	}
	
	/**
	 * Metodo para crear una tarjeta - recibe el id del cliente
	 * @param tarjetaClienteDto
	 * @param id
	 * @return
	 */
	@PostMapping("/")
	public TarjetaClienteDto agregarTarjeta(@RequestBody TarjetaClienteDto tarjetaClienteDto) {
		TarjetaCliente tarjeta = this.convertToEntity(tarjetaClienteDto);
			this.tarjetaClienteService.guardarTarjeta(tarjeta);
			return this.convertToDto(tarjeta);
	}
	
	/**
	 * Metodo para actualizar una tarjeta
	 * @param tarjetaClienteDto
	 * @return
	 */
	@PutMapping("/")
	public TarjetaClienteDto editarTarjeta(@RequestBody TarjetaClienteDto tarjetaClienteDto) {
		return this.agregarTarjeta(tarjetaClienteDto);
	}
	
	/**
	 * Metodo para borrar una tarjeta
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void eliminarAsesor(@PathVariable Long id) {
		this.tarjetaClienteService.eliminarTarjeta(id);
	}
	
	
	/**
	 * Convertir entidad a DTO
	 * @param tarjetaCliente
	 * @return
	 */
	private TarjetaClienteDto convertToDto(TarjetaCliente tarjetaCliente) {
		return modelMapper.map(tarjetaCliente, TarjetaClienteDto.class);
	}

	/**
	 * Convertir DTO a entidad
	 * @param tarjetaClienteDto
	 * @return
	 */
	private TarjetaCliente convertToEntity(TarjetaClienteDto tarjetaClienteDto) {
		return modelMapper.map(tarjetaClienteDto, TarjetaCliente.class);
	}
	
}
