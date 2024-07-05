package com.aplication.eventManager.controllers.dto;

import com.aplication.eventManager.entities.Evento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvitadoDTO {

    private Long id;

    private String nombre;

    private String ci;

    private String codigo;

    private String sector;

    private String sucursal;

    private String centro_costo;

    private LocalDateTime fecha;

    private String foto;

    private Boolean asistencia;

    private Evento evento;
}
