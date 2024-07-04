package com.aplication.eventManager.persistence;

import com.aplication.eventManager.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface IEventoDAO {

    List<Evento> findAll();

    Optional<Evento> findById(Long id);

    void save(Evento evento);

    void deletedById(Long id);
}
