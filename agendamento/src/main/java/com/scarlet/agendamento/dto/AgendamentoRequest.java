package com.scarlet.agendamento.dto;

import com.scarlet.agendamento.enums.TipoAgendamento;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class AgendamentoRequest {
    private UUID pacienteId;
    private UUID profissionalId;
    private LocalDateTime horario;
    private TipoAgendamento tipoAgendamento;
}
