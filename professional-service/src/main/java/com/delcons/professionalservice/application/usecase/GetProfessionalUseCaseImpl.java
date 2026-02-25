package com.delcons.professionalservice.application.usecase;

import com.delcons.professionalservice.domain.model.Professional;
import com.delcons.professionalservice.domain.port.in.GetProfessionalUseCase;
import com.delcons.professionalservice.domain.port.out.persistence.ProfessionalQueryRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetProfessionalUseCaseImpl implements GetProfessionalUseCase {
    private final ProfessionalQueryRepositoryPort queryRepositoryPort;

    @Override
    public Optional<Professional> getProfessionalById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return queryRepositoryPort.findById(id);
    }

    @Override
    public Optional<Professional> getProfessionalByEmail(String email) {
        if (email == null || email.isBlank()) {
            return Optional.empty();
        }
        return queryRepositoryPort.findByEmail(email);
    }

    @Override
    public Optional<Professional> getProfessionalByNickname(String nickname) {
        if (nickname == null || nickname.isBlank()) {
            return Optional.empty();
        }
        return queryRepositoryPort.findByNickname(nickname);
    }

    @Override
    public List<Professional> getAllProfessionals() {
        return queryRepositoryPort.findAll();
    }
}
