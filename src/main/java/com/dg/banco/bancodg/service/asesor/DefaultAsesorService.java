package com.dg.banco.bancodg.service.asesor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.banco.bancodg.entity.asesor.Asesor;
import com.dg.banco.bancodg.repository.asesor.AsesorRepository;

/**
 * Servicio para Asesor CRUD
 * @author Diana Catalina
 *
 */
@Service
public class DefaultAsesorService implements AsesorService {

	@Autowired
	private AsesorRepository asesorRepository;
	
	@Override
	public List<Asesor> listarAsesores() {
		// Metodo para retornar el listado de asesores
		return (List<Asesor>) asesorRepository.findAll();
	}

	@Override
	public void guardarAsesor(Asesor asesor) {
		/*Metodo para guardar o actualizar asesor*/
		this.asesorRepository.save(asesor);
		
	}

	@Override
	public void eliminarAsesor(Long id) {
		// Metodo para eliminar asesor
		this.asesorRepository.deleteById(id);
	}

	@Override
	public Optional<Asesor> buscarAsesor(Long id) {
		// Metodo para buscar un asesor
		return this.asesorRepository.findById(id);
	}

}
