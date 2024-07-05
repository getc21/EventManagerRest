package com.aplication.eventManager.service;

import com.aplication.eventManager.entities.Evento;

import java.util.List;
import java.util.Optional;

public interface IEventoService {

    List<Evento> findAll();

    Optional<Evento> findById(Long id);

    void save(Evento evento);

    void deletedById(Long id);

}
