package com.forin.apividaplus.repositories;

import com.forin.apividaplus.models.pessoas.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<Administrador, String> {
}
