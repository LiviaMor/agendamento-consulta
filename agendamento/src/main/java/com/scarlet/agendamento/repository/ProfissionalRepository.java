package com.scarlet.agendamento.repository;

import com.scarlet.agendamento.entity.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfissionalRepository extends JpaRepository<Profissional, UUID> {
}