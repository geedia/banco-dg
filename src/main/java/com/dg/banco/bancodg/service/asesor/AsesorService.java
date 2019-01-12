package com.dg.banco.bancodg.service.asesor;

import java.util.List;
import java.util.Optional;

import com.dg.banco.bancodg.entity.asesor.Asesor;

/*
 * Interfaz para el servicio de asesor
 */
public interface AsesorService {
	public List<Asesor> listarAsesores();
	public void guardarAsesor(Asesor asesor);
	public void eliminarAsesor(Long id);
	public Optional<Asesor> buscarAsesor(Long id);
	
}
