package com.forin.apividaplus.repository;

import com.forin.apividaplus.models.pessoa.ProfissionalSaude;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaude, UUID> {

    Optional<ProfissionalSaude> findByIdentificadorProfissionalSaude(String identificadorProfissionalSaude);

}
