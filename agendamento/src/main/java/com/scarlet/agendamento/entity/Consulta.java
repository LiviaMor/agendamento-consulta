package com.scarlet.agendamento.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Profissional profissional;

    private LocalDateTime horario;

    @Enumerated(EnumType.STRING)
    private TipoConsulta tipo;
}