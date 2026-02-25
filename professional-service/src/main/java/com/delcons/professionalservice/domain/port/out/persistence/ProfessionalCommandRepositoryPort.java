package com.delcons.professionalservice.domain.port.out.persistence;

import com.delcons.professionalservice.domain.model.Professional;

public interface ProfessionalCommandRepositoryPort {
    Professional save(Professional professional);
    boolean deleteById(Long id);
    Professional update(Professional professional);
}
