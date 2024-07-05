package com.aplication.eventManager.controllers.dto;

import com.aplication.eventManager.entities.Invitado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventoDTO {

    private Long id;

    private String nombre;

    private String descripcion;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    private String lugar;

    private String organizador;

    private List<Invitado> invitadoList = new ArrayList<>();
}
