package com.forin.apividaplus.repository;

import com.forin.apividaplus.models.pessoa.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {

    Optional<Paciente> findByIdentificadorPaciente(String identificadorPaciente);

}
