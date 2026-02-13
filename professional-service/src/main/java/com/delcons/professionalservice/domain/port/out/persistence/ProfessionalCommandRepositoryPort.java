package com.delcons.professionalservice.domain.port.out.persistence;

import com.delcons.professionalservice.domain.model.Professional;

public interface ProfessionalCommandRepositoryPort {
    Professional save(Professional professional);
    void deleteById(Long id);
}
