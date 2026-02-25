package com.delcons.professionalservice.domain.port.in;

import com.delcons.professionalservice.domain.model.Professional;

import java.util.List;
import java.util.Optional;

public interface GetProfessionalUseCase {
    Optional<Professional> getProfessionalById(Long id);
    Optional<Professional> getProfessionalByEmail(String email);
    Optional<Professional> getProfessionalByNickname(String nickname);
    List<Professional> getAllProfessionals();
}
