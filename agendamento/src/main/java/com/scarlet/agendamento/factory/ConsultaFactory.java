package com.scarlet.agendamento.factory;

import com.scarlet.agendamento.entity.Consulta;
import com.scarlet.agendamento.entity.Paciente;
import com.scarlet.agendamento.entity.Profissional;

import java.time.LocalDateTime;

public abstract class ConsultaFactory {
    public abstract Consulta criarConsulta(Paciente paciente, Profissional profissional, LocalDateTime horario);
}