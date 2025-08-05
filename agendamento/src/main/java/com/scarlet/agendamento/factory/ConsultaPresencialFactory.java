package com.scarlet.agendamento.factory;

import com.scarlet.agendamento.entity.*;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class ConsultaPresencialFactory extends ConsultaFactory {

    @Override
    public Consulta criarConsulta(Paciente paciente, Profissional profissional, LocalDateTime horario) {
        return Consulta.builder()
                .paciente(paciente)
                .profissional(profissional)
                .horario(horario)
                .tipo(TipoConsulta.PRESENCIAL)
                .build();
    }
}