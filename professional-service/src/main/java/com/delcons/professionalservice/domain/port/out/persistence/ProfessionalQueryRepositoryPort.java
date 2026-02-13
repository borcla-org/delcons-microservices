package com.delcons.professionalservice.domain.port.out.persistence;

import com.delcons.professionalservice.domain.model.Professional;

import java.util.List;
import java.util.Optional;

public interface ProfessionalQueryRepositoryPort {
    Optional<Professional> findById(Long id);
    List<Professional> findAll();
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}
