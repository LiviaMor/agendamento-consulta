package com.scarlet.agendamento.service;

import com.scarlet.agendamento.entity.*;
import com.scarlet.agendamento.enums.TipoAgendamento;
import com.scarlet.agendamento.strategy.AgendamentoStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final Map<String, AgendamentoStrategy> estrategias;

    public Consulta agendar(TipoAgendamento tipo, Paciente paciente, Profissional profissional, LocalDateTime horario) {
        AgendamentoStrategy estrategia = estrategias.get(tipo.getChave());

        if (estrategia == null) {
            throw new IllegalArgumentException("Tipo de agendamento inválido: " + tipo);
        }

        return estrategia.agendar(paciente, profissional, horario);
    }
}