package com.backendparcial.parcial_back_ger.repositorios;

import org.springframework.data.jpa.repository.*;
import java.util.Optional;
import com.backendparcial.parcial_back_ger.modelos.Contrato;

public interface RepositorioContrato extends JpaRepository<Contrato, Long> {
    Optional<Contrato> findById(Long id);
}
