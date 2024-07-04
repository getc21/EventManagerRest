package com.aplication.eventManager.repository;

import com.aplication.eventManager.entities.Invitado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitadoRepository extends CrudRepository<Invitado, Long> {


}
