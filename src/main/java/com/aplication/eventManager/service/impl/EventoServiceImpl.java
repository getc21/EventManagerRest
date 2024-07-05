package com.aplication.eventManager.service.impl;

import com.aplication.eventManager.entities.Evento;
import com.aplication.eventManager.persistence.IEventoDAO;
import com.aplication.eventManager.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements IEventoService {

    @Autowired
    private IEventoDAO eventoDAO;

    @Override
    public List<Evento> findAll() {
        return eventoDAO.findAll();
    }

    @Override
    public Optional<Evento> findById(Long id) {
        return eventoDAO.findById(id);
    }

    @Override
    public void save(Evento evento) {
        eventoDAO.save(evento);
    }

    @Override
    public void deletedById(Long id) {
        eventoDAO.deletedById(id);
    }
}
