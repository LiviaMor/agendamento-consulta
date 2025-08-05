package com.scarlet.agendamento.controller;

import com.scarlet.agendamento.dto.AgendamentoRequest;
import com.scarlet.agendamento.entity.Consulta;
import com.scarlet.agendamento.entity.Paciente;
import com.scarlet.agendamento.entity.Profissional;
import com.scarlet.agendamento.repository.PacienteRepository;
import com.scarlet.agendamento.repository.ProfissionalRepository;
import com.scarlet.agendamento.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {
    private final AgendamentoService agendamentoService;
    private final PacienteRepository pacienteRepository;
    private final ProfissionalRepository profissionalRepository;

    @PostMapping
    public ResponseEntity<?> agendar(@RequestBody AgendamentoRequest request){
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(request.getPacienteId());
        Optional<Profissional> profissionalOptional = profissionalRepository.findById(request.getProfissionalId());
        if(pacienteOptional.isPresent() && profissionalOptional.isPresent()){
            return ResponseEntity.badRequest().body("Não encontrado");
        }
        Consulta consulta = agendamentoService.agendar(
                request.getTipoAgendamento(),
                pacienteOptional.get(),
                profissionalOptional.get(),
                request.getHorario()
        );
        return ResponseEntity.ok(consulta);
    };

}
