package com.delcons.professionalservice.domain.port.in;

import com.delcons.professionalservice.domain.model.Professional;
import java.util.List;
import java.util.Optional;

public interface ProfessionalService {
    Professional createProfessional(Professional professional);
    Optional<Professional> getProfessionalById(Long id);
    List<Professional> getAllProfessionals();
    Professional updateProfessional(Professional professional);
    void deleteProfessional(Long id);
}
