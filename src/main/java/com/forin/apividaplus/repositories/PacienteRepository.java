package com.forin.apividaplus.repositories;

import com.forin.apividaplus.models.pessoas.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, String> {
}
