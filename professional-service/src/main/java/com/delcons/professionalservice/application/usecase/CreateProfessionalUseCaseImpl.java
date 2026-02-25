package com.delcons.professionalservice.application.usecase;

import com.delcons.professionalservice.domain.exception.ProfessionalAlreadyExistsException;
import com.delcons.professionalservice.domain.model.Professional;
import com.delcons.professionalservice.domain.port.in.CreateProfessionalUseCase;
import com.delcons.professionalservice.domain.port.out.persistence.ProfessionalCommandRepositoryPort;
import com.delcons.professionalservice.domain.port.out.persistence.ProfessionalQueryRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProfessionalUseCaseImpl implements CreateProfessionalUseCase {

    private final ProfessionalCommandRepositoryPort commandRepositoryPort;
    private final ProfessionalQueryRepositoryPort queryRepositoryPort;

    @Override
    public Professional createProfessional(Professional professional) {
        if (professional == null) {
            throw new IllegalArgumentException("Professional is required");
        }
        if (professional.getEmail() == null || professional.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }
        if (professional.getNickname() == null || professional.getNickname().isBlank()) {
            throw new IllegalArgumentException("Nickname is required");
        }

        if (queryRepositoryPort.existsByEmail(professional.getEmail())) {
            throw ProfessionalAlreadyExistsException.withEmail(professional.getEmail());
        }
        if (queryRepositoryPort.existsByNickname(professional.getNickname())) {
            throw ProfessionalAlreadyExistsException.withNickname(professional.getNickname());
        }
        return commandRepositoryPort.save(professional);
    }
}
