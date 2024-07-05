package com.aplication.eventManager.controllers;

import com.aplication.eventManager.controllers.dto.EventoDTO;
import com.aplication.eventManager.controllers.dto.InvitadoDTO;
import com.aplication.eventManager.entities.Evento;
import com.aplication.eventManager.entities.Invitado;
import com.aplication.eventManager.service.IInvitadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invitado")
public class InvitadoController {
    @Autowired
    private IInvitadoService invitadoService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Invitado> invitadoOptional = invitadoService.findById(id);

        if (invitadoOptional.isPresent()) {
            Invitado invitado = invitadoOptional.get();

            InvitadoDTO invitadoDTO = InvitadoDTO.builder()
                    .id(invitado.getId())
                    .nombre(invitado.getNombre())
                    .ci(invitado.getCi())
                    .codigo(invitado.getCodigo())
                    .sector(invitado.getSector())
                    .sucursal(invitado.getSucursal())
                    .centro_costo(invitado.getCentro_costo())
                    .fecha(invitado.getFecha())
                    .foto(invitado.getFoto())
                    .asistencia(invitado.getAsistencia())
                    .evento(invitado.getEvento())
                    .build();

            return ResponseEntity.ok(invitadoDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<InvitadoDTO> invitadoList = invitadoService.findAll()
                .stream()
                .map(invitado -> InvitadoDTO.builder()
                        .id(invitado.getId())
                        .nombre(invitado.getNombre())
                        .ci(invitado.getCi())
                        .codigo(invitado.getCodigo())
                        .sector(invitado.getSector())
                        .sucursal(invitado.getSucursal())
                        .centro_costo(invitado.getCentro_costo())
                        .fecha(invitado.getFecha())
                        .foto(invitado.getFoto())
                        .asistencia(invitado.getAsistencia())
                        .evento(invitado.getEvento())
                        .build())
                .toList();
        return ResponseEntity.ok(invitadoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody InvitadoDTO invitadoDTO) throws URISyntaxException {

        if (invitadoDTO.getNombre().isBlank() ||
                invitadoDTO.getCi().isBlank() ||
                invitadoDTO.getCodigo().isBlank() ||
                invitadoDTO.getSector().isBlank() ||
                invitadoDTO.getSucursal().isBlank() ||
                invitadoDTO.getCentro_costo().isBlank() ||
                invitadoDTO.getFecha() == null ||
                invitadoDTO.getFoto().isBlank() ||
                invitadoDTO.getAsistencia() ||
                invitadoDTO.getEvento() == null) {

            return ResponseEntity.badRequest().build();
        }

        Invitado invitado = Invitado.builder()
                .nombre(invitadoDTO.getNombre())
                .ci(invitadoDTO.getCi())
                .codigo(invitadoDTO.getCodigo())
                .sector(invitadoDTO.getSector())
                .sucursal(invitadoDTO.getSucursal())
                .centro_costo(invitadoDTO.getCentro_costo())
                .fecha(invitadoDTO.getFecha())
                .foto(invitadoDTO.getFoto())
                .asistencia(invitadoDTO.getAsistencia())
                .evento(invitadoDTO.getEvento())
                .build();

        invitadoService.save(invitado);
        return ResponseEntity.created(new URI("/api/invitado/save")).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){

        if(id != null){
            invitadoService.deleteById(id);
            return ResponseEntity.ok("Invitado eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
