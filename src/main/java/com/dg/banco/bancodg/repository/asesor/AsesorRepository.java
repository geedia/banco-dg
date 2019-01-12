package com.dg.banco.bancodg.repository.asesor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dg.banco.bancodg.entity.asesor.Asesor;

@Repository
public interface AsesorRepository extends CrudRepository<Asesor, Long> {

}
