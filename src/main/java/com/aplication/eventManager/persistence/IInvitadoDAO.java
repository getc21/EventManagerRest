package com.aplication.eventManager.persistence;

import com.aplication.eventManager.entities.Invitado;

import java.util.List;
import java.util.Optional;

public interface IInvitadoDAO {

    List<Invitado> findAll();

    Optional<Invitado> findById(Long id);

    void save(Invitado invitado);

    void deleteById(Long id);
}
