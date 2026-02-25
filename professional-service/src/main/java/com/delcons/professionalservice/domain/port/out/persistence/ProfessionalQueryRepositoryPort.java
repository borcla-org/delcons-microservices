package com.delcons.professionalservice.domain.port.out.persistence;

import com.delcons.professionalservice.domain.model.Professional;

import java.util.List;
import java.util.Optional;

public interface ProfessionalQueryRepositoryPort {
    Optional<Professional> findById(Long id);
    Optional<Professional> findByEmail(String email);
    Optional<Professional> findByNickname(String nickname);

    List<Professional> findAll();
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsById(Long id);
}
