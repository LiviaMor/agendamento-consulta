package com.scarlet.agendamento.strategy;

import com.scarlet.agendamento.entity.*;
import com.scarlet.agendamento.factory.ConsultaPresencialFactory;
import com.scarlet.agendamento.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("profissional")
@RequiredArgsConstructor
public class AgendamentoPorProfissional implements AgendamentoStrategy {

    private final ConsultaRepository consultaRepository;

    @Override
    public Consulta agendar(Paciente paciente, Profissional profissional, LocalDateTime horario) {
        Consulta consulta = new ConsultaPresencialFactory()
                .criarConsulta(paciente, profissional, horario);
        return consultaRepository.save(consulta);
    }
}