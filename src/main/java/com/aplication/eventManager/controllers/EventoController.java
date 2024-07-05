package com.aplication.eventManager.controllers;

import com.aplication.eventManager.controllers.dto.EventoDTO;
import com.aplication.eventManager.entities.Evento;
import com.aplication.eventManager.service.IEventoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evento")
public class EventoController {

    @Autowired
    private IEventoService eventoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
       Optional<Evento> eventoOptional = eventoService.findById(id);

       if(eventoOptional.isPresent()){
           Evento evento = eventoOptional.get();

           EventoDTO eventoDTO = EventoDTO.builder()
                   .id(evento.getId())
                   .nombre(evento.getNombre())
                   .descripcion(evento.getDescripcion())
                   .fechaInicio(evento.getFechaInicio())
                   .fechaFin(evento.getFechaFin())
                   .lugar(evento.getLugar())
                   .organizador(evento.getOrganizador())
                   .invitadoList(evento.getInvitadoList())
                   .build();

           return ResponseEntity.ok(eventoDTO);
       }

       return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        List<EventoDTO> eventoList = eventoService.findAll()
                .stream()
                .map(evento -> EventoDTO.builder()
                        .id(evento.getId())
                        .nombre(evento.getNombre())
                        .descripcion(evento.getDescripcion())
                        .fechaInicio(evento.getFechaInicio())
                        .fechaFin(evento.getFechaFin())
                        .lugar(evento.getLugar())
                        .organizador(evento.getOrganizador())
                        .invitadoList(evento.getInvitadoList())
                        .build())
                .toList();
        return ResponseEntity.ok(eventoList);
    }
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody EventoDTO eventoDTO) throws URISyntaxException{

        if(eventoDTO.getNombre().isBlank() ||
                eventoDTO.getDescripcion().isBlank() ||
                eventoDTO.getFechaInicio() == null ||
                eventoDTO.getFechaFin() == null ||
                eventoDTO.getLugar().isBlank() ||
                eventoDTO.getOrganizador().isBlank()){

            return ResponseEntity.badRequest().build();
        }

        eventoService.save(Evento.builder()
                .nombre(eventoDTO.getNombre())
                .descripcion(eventoDTO.getDescripcion())
                .fechaInicio(eventoDTO.getFechaInicio())
                .fechaFin(eventoDTO.getFechaFin())
                .lugar(eventoDTO.getLugar())
                .organizador(eventoDTO.getOrganizador())
                .build());

        return ResponseEntity.created(new URI("/api/evento/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEvento(@PathVariable Long id, @RequestBody EventoDTO eventoDTO){

        Optional<Evento> eventoOptional = eventoService.findById(id);

        if(eventoOptional.isPresent()){
            Evento evento = eventoOptional.get();
            evento.setNombre(eventoDTO.getNombre());
            evento.setDescripcion(eventoDTO.getDescripcion());
            evento.setFechaInicio(eventoDTO.getFechaInicio());
            evento.setFechaFin(eventoDTO.getFechaFin());
            evento.setLugar(eventoDTO.getLugar());
            evento.setOrganizador(eventoDTO.getOrganizador());
            eventoService.save(evento);
            return ResponseEntity.ok("Registro actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if(id != null){
            eventoService.deletedById(id);
            return ResponseEntity.ok("Evento eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
