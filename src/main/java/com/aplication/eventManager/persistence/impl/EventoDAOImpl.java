package com.aplication.eventManager.persistence.impl;

import com.aplication.eventManager.entities.Evento;
import com.aplication.eventManager.persistence.IEventoDAO;
import com.aplication.eventManager.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EventoDAOImpl implements IEventoDAO {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> findAll() {
        return (List<Evento>) eventoRepository.findAll();
    }

    @Override
    public Optional<Evento> findById(Long id) {
        return eventoRepository.findById(id);
    }

    @Override
    public void save(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void deletedById(Long id) {
        eventoRepository.deleteById(id);
    }
}
