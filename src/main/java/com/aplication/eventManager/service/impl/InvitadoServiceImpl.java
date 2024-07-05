package com.aplication.eventManager.service.impl;

import com.aplication.eventManager.entities.Invitado;
import com.aplication.eventManager.persistence.IInvitadoDAO;
import com.aplication.eventManager.service.IInvitadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvitadoServiceImpl implements IInvitadoService {

    @Autowired
    private IInvitadoDAO invitadoDAO;

    @Override
    public List<Invitado> findAll() {
        return invitadoDAO.findAll();
    }

    @Override
    public Optional<Invitado> findById(Long id) {
        return invitadoDAO.findById(id);
    }

    @Override
    public void save(Invitado invitado) {
        invitadoDAO.save(invitado);
    }

    @Override
    public void deleteById(Long id) {
        invitadoDAO.deleteById(id);
    }
}
