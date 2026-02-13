package com.delcons.professionalservice.application.usecase;

import com.delcons.professionalservice.domain.model.Professional;
import com.delcons.professionalservice.domain.port.in.ProfessionalService;
import com.delcons.professionalservice.domain.port.out.ProfessionalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessionalUseCase implements ProfessionalService {

    private final ProfessionalRepositoryPort professionalRepositoryPort;

    @Override
    public Professional createProfessional(Professional professional) {
        if (professionalRepositoryPort.existsByEmail(professional.getEmail())) {
            throw new IllegalArgumentException("Professional with email " + professional.getEmail() + " already exists");
        }
        if (professionalRepositoryPort.existsByNickname(professional.getNickname())) {
            throw new IllegalArgumentException("Professional with nickname " + professional.getNickname() + " already exists");
        }
        return professionalRepositoryPort.save(professional);
    }

    @Override
    public Optional<Professional> getProfessionalById(Long id) {
        return professionalRepositoryPort.findById(id);
    }

    @Override
    public List<Professional> getAllProfessionals() {
        return professionalRepositoryPort.findAll();
    }

    @Override
    public Professional updateProfessional(Professional professional) {
        if (!professionalRepositoryPort.findById(professional.getId()).isPresent()) {
             throw new IllegalArgumentException("Professional with id " + professional.getId() + " not found");
        }
        return professionalRepositoryPort.save(professional);
    }

    @Override
    public void deleteProfessional(Long id) {
        professionalRepositoryPort.deleteById(id);
    }
}
