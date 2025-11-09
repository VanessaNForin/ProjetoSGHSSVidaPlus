package com.forin.apividaplus.repositories;

import com.forin.apividaplus.models.atendimento.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternacaoRepository extends JpaRepository<Internacao, String> {
}
