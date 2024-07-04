package com.aplication.eventManager.repository;

import com.aplication.eventManager.entities.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Long> {
}
