package com.dg.banco.bancodg.controller.asesor;

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

import com.dg.banco.bancodg.dto.asesor.AsesorDto;
import com.dg.banco.bancodg.entity.asesor.Asesor;
import com.dg.banco.bancodg.service.asesor.AsesorService;

/**
 * Clase Controladora para asesores
 * @author Diana Catalina
 *
 */
@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/asesor")
public class AsesorController {

	@Autowired
	private AsesorService asesorService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Metodo para listar todos los asesores
	 * @return
	 */
	@GetMapping("/")
	public List<AsesorDto> buscarAsesores() {
		List<Asesor> asesores = asesorService.listarAsesores();
		return asesores.stream().map(asesor -> convertToDto(asesor)).collect(Collectors.toList());

	}
	
	/**
	 * Metodo para buscar un asesor
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public AsesorDto buscarAsesor(@PathVariable Long id) {
		Optional<Asesor> asesor = asesorService.buscarAsesor(id);
		if(asesor.isPresent()) {
			return this.convertToDto(asesor.get());
		}
		return null;

	}
	
	/**
	 * Metodo para crear un asesor
	 * @param asesorDto
	 * @return
	 */
	@PostMapping("/")
	public AsesorDto agregarAsesor(@RequestBody AsesorDto asesorDto) {
		Asesor asesor = this.convertToEntity(asesorDto);
		this.asesorService.guardarAsesor(asesor);
		return this.convertToDto(asesor);
	}
	
	/**
	 * Metodo para actualizar un asesor
	 * @param asesorDto
	 * @return
	 */
	@PutMapping("/")
	public AsesorDto editarAsesor(@RequestBody AsesorDto asesorDto) {
		return this.agregarAsesor(asesorDto);
	}
	
	/**
	 * Metodo para borrar un asesor
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void eliminarAsesor(@PathVariable Long id) {
		this.asesorService.eliminarAsesor(id);
	}

	/**
	 * Convertir entidad a DTO
	 * 
	 * @param asesor
	 * @return
	 */
	private AsesorDto convertToDto(Asesor asesor) {
		return modelMapper.map(asesor, AsesorDto.class);
	}
	
	/**
	 * Metodo que transforma el DTO a la entidad Asesor
	 * 
	 * @param asesorDto
	 * @return
	 * @throws ParseException
	 */

	private Asesor convertToEntity(AsesorDto asesorDto) {
		return modelMapper.map(asesorDto, Asesor.class);
	}
	
}
