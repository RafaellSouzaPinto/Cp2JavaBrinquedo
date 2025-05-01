package com.fiap.brinquedo.repositories;

import com.fiap.brinquedo.entities.Brinquedo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrinquedoRepository extends JpaRepository<Brinquedo, Long> {

}
