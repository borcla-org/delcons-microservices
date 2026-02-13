package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa;

import com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity.ProfessionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessionalJpaRepository extends JpaRepository<ProfessionalEntity, Long> {
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    Optional<ProfessionalEntity> findByEmail(String email);
}