package com.aplication.eventManager.persistence.impl;

import com.aplication.eventManager.entities.Invitado;
import com.aplication.eventManager.persistence.IInvitadoDAO;
import com.aplication.eventManager.repository.InvitadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InvitadoDAOImpl implements IInvitadoDAO {

    @Autowired
    private InvitadoRepository invitadoRepository;

    @Override
    public List<Invitado> findAll() {
        return (List<Invitado>) invitadoRepository.findAll();
    }

    @Override
    public Optional<Invitado> findById(Long id) {
        return invitadoRepository.findById(id);
    }

    @Override
    public void save(Invitado invitado) {
        invitadoRepository.save(invitado);
    }

    @Override
    public void deleteById(Long id) {
        invitadoRepository.deleteById(id);
    }
}
