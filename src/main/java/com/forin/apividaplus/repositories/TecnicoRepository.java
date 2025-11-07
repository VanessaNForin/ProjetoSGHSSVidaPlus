package com.forin.apividaplus.repositories;

import com.forin.apividaplus.models.pessoas.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, String> {
}
