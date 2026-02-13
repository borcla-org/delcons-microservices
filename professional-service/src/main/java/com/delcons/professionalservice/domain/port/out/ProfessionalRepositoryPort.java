package com.delcons.professionalservice.domain.port.out;

import com.delcons.professionalservice.domain.model.Professional;
import java.util.List;
import java.util.Optional;

public interface ProfessionalRepositoryPort {
    Professional save(Professional professional);
    void deleteById(Long id);

    Optional<Professional> findById(Long id);
    List<Professional> findAll();
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
}