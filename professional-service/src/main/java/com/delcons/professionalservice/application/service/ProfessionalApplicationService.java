package com.delcons.professionalservice.application.service;

import com.delcons.professionalservice.domain.model.Professional;
import com.delcons.professionalservice.domain.port.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProfessionalApplicationService {
    private final CreateProfessionalUseCase createUseCase;
    private final GetProfessionalUseCase getUseCase;
    private final UpdateProfessionalUseCase updateUseCase;
    private final DeleteProfessionalUseCase deleteUseCase;

    public Optional<Professional> getProfessionalById(Long id) {
        return getUseCase.getProfessionalById(id);
    }

    public Optional<Professional> getProfessionalByEmail(String email) {
        return getUseCase.getProfessionalByEmail(email);
    }

    public Optional<Professional> getProfessionalByNickname(String nickname) {
        return getUseCase.getProfessionalByNickname(nickname);
    }

    public List<Professional> getAllProfessionals() {

        return getUseCase.getAllProfessionals();
    }

    public Professional createProfessional(Professional professional) {
        return createUseCase.createProfessional(professional);
    }

    public Professional updateProfessional(Professional professional) {
        return updateUseCase.updateProfessional(professional);
    }

    public boolean deleteProfessional(Long id) {
        return deleteUseCase.deleteProfessional(id);
    }
}
