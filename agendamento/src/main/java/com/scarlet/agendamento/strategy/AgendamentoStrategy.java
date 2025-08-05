package com.scarlet.agendamento.strategy;

import com.scarlet.agendamento.entity.Consulta;
import com.scarlet.agendamento.entity.Paciente;
import com.scarlet.agendamento.entity.Profissional;

import java.time.LocalDateTime;

public interface AgendamentoStrategy {
    Consulta agendar(Paciente paciente, Profissional profissional, LocalDateTime horario);
}