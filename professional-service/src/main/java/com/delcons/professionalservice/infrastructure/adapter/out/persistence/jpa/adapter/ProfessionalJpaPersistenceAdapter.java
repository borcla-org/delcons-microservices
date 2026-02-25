package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.adapter;

import com.delcons.professionalservice.domain.model.Professional;
import com.delcons.professionalservice.domain.port.out.persistence.ProfessionalCommandRepositoryPort;
import com.delcons.professionalservice.domain.port.out.persistence.ProfessionalQueryRepositoryPort;
import com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.repository.ProfessionalJpaRepository;
import com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity.ProfessionalEntity;
import com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.mapper.ProfessionalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProfessionalJpaPersistenceAdapter implements
        ProfessionalCommandRepositoryPort,
        ProfessionalQueryRepositoryPort {

    private final ProfessionalJpaRepository professionalJpaRepository;
    private final ProfessionalMapper professionalMapper;

    @Override
    public Optional<Professional> findById(Long id) {
        return professionalJpaRepository.findById(id)
                .map(professionalMapper::toDomain);
    }

    @Override
    public Optional<Professional> findByEmail(String email) {
        return professionalJpaRepository.findByEmail(email)
                .map(professionalMapper::toDomain);
    }

    @Override
    public Optional<Professional> findByNickname(String nickname) {
        return professionalJpaRepository.findByNickname(nickname)
                .map(professionalMapper::toDomain);
    }

    @Override
    public List<Professional> findAll() {
        return professionalJpaRepository.findAll().stream()
                .map(professionalMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByEmail(String email) {
        return professionalJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByNickname(String nickname) {
        return professionalJpaRepository.existsByNickname(nickname);
    }

    @Override
    public boolean existsById(Long id) {
        return professionalJpaRepository.existsById(id);
    }

    @Override
    public Professional save(Professional professional) {
        ProfessionalEntity entity = professionalMapper.toEntity(professional);
        ProfessionalEntity savedEntity = professionalJpaRepository.save(entity);
        return professionalMapper.toDomain(savedEntity);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!professionalJpaRepository.existsById(id)) {
            return false;
        }
        try {
            professionalJpaRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public Professional update(Professional professional) {
        return save(professional);
    }

}
