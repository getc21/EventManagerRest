package com.aplication.eventManager.service;

import com.aplication.eventManager.entities.Invitado;

import java.util.List;
import java.util.Optional;

public interface IInvitadoService {

    List<Invitado> findAll();

    Optional<Invitado> findById(Long id);

    void save(Invitado invitado);

    void deleteById(Long id);

}
