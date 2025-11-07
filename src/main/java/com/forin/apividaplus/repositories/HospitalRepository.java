package com.forin.apividaplus.repositories;

import com.forin.apividaplus.models.infraestrutura.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, String> {

}
