package com.delcons.professionalservice.application.usecase;

import com.delcons.professionalservice.domain.port.in.DeleteProfessionalUseCase;
import com.delcons.professionalservice.domain.port.out.persistence.ProfessionalCommandRepositoryPort;
import com.delcons.professionalservice.domain.port.out.persistence.ProfessionalQueryRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProfessionalUseCaseImpl implements DeleteProfessionalUseCase {
    private final ProfessionalCommandRepositoryPort commandRepositoryPort;
    private final ProfessionalQueryRepositoryPort queryRepositoryPort;

    @Override
    public boolean deleteProfessional(Long id) {
        if (id == null) {
            return false;
        }
        if (!queryRepositoryPort.existsById(id)) {
            return false;
        }
        return commandRepositoryPort.deleteById(id);
    }
}
