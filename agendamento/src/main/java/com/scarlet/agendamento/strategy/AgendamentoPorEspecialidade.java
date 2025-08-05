package com.scarlet.agendamento.strategy;

import com.scarlet.agendamento.entity.*;
import com.scarlet.agendamento.factory.ConsultaTelemedicinaFactory;
import com.scarlet.agendamento.repository.ConsultaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("especialidade")
@RequiredArgsConstructor
public class AgendamentoPorEspecialidade implements AgendamentoStrategy {

    private final ConsultaRepository consultaRepository;

    @Override
    public Consulta agendar(Paciente paciente, Profissional profissional, LocalDateTime horario) {
        Consulta consulta = new ConsultaTelemedicinaFactory()
                .criarConsulta(paciente, profissional, horario);
        return consultaRepository.save(consulta);
    }
}