package com.delcons.professionalservice.infrastructure.adapter.out.persistence.adapter;

import com.delcons.professionalservice.domain.model.Professional;
import com.delcons.professionalservice.domain.port.out.ProfessionalRepositoryPort;
import com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.ProfessionalJpaRepository;
import com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity.ProfessionalEntity;
import com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.mapper.ProfessionalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProfessionalPersistenceAdapter implements ProfessionalRepositoryPort {

    private final ProfessionalJpaRepository professionalJpaRepository;
    private final ProfessionalMapper professionalMapper;

    @Override
    public Professional save(Professional professional) {
        ProfessionalEntity entity = professionalMapper.toEntity(professional);
        ProfessionalEntity savedEntity = professionalJpaRepository.save(entity);
        return professionalMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Professional> findById(Long id) {
        return professionalJpaRepository.findById(id)
                .map(professionalMapper::toDomain);
    }

    @Override
    public List<Professional> findAll() {
        return professionalJpaRepository.findAll().stream()
                .map(professionalMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        professionalJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByEmail(String email) {
        return professionalJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByNickname(String nickname) {
        return professionalJpaRepository.existsByNickname(nickname);
    }
}
