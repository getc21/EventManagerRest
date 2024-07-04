package com.aplication.eventManager.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "invitado")
public class Invitado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "nombre")
    private String nombre;

    @Column(name = "cedula")
    private String ci;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "sector")
    private String sector;

    @Column(name = "sucursal")
    private String sucursal;

    @Column(name = "centro_costo")
    private String centro_costo;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "foto")
    private String foto;

    @Column(name = "asistencia")
    private Boolean asistencia;

    @ManyToOne
    @JoinColumn(name = "id_evento", nullable = false)
    private Evento evento;
}
