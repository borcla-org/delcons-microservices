package com.delcons.professionalservice.application.usecase;

import com.delcons.professionalservice.domain.exception.ProfessionalAlreadyExistsException;
import com.delcons.professionalservice.domain.exception.ProfessionalNotFoundException;
import com.delcons.professionalservice.domain.model.Professional;
import com.delcons.professionalservice.domain.port.in.UpdateProfessionalUseCase;
import com.delcons.professionalservice.domain.port.out.persistence.ProfessionalCommandRepositoryPort;
import com.delcons.professionalservice.domain.port.out.persistence.ProfessionalQueryRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProfessionalUseCaseImpl implements UpdateProfessionalUseCase {
    private final ProfessionalCommandRepositoryPort commandRepositoryPort;
    private final ProfessionalQueryRepositoryPort queryRepositoryPort;

    @Override
    public Professional updateProfessional(Professional incoming) {
        if (incoming == null || incoming.getId() == null) {
            throw new IllegalArgumentException("Professional id is required");
        }

        Professional current = queryRepositoryPort.findById(incoming.getId())
                .orElseThrow(() -> new ProfessionalNotFoundException("Professional with id " + incoming.getId() + " not found"));

        if (incoming.getEmail() != null && !incoming.getEmail().isBlank()
                && current.getEmail() != null
                && !incoming.getEmail().equalsIgnoreCase(current.getEmail())) {

            queryRepositoryPort.findByEmail(incoming.getEmail())
                    .filter(found -> found.getId() != null && !found.getId().equals(incoming.getId()))
                    .ifPresent(found -> {
                        throw ProfessionalAlreadyExistsException.withEmail(incoming.getEmail());
                    });
        }

        if (incoming.getNickname() != null && !incoming.getNickname().isBlank()
                && current.getNickname() != null
                && !incoming.getNickname().equalsIgnoreCase(current.getNickname())) {

            queryRepositoryPort.findByNickname(incoming.getNickname())
                    .filter(found -> found.getId() != null && !found.getId().equals(incoming.getId()))
                    .ifPresent(found -> {
                        throw ProfessionalAlreadyExistsException.withNickname(incoming.getNickname());
                    });
        }
        Professional merged = current.clone();

        merged.setEmail(firstNonBlank(incoming.getEmail(), current.getEmail()));
        merged.setNickname(firstNonBlank(incoming.getNickname(), current.getNickname()));

        merged.setName(firstNonBlank(incoming.getName(), current.getName()));
        merged.setLastname(firstNonBlank(incoming.getLastname(), current.getLastname()));
        merged.setDescription(firstNonBlank(incoming.getDescription(), current.getDescription()));
        merged.setPhoneNumber(firstNonBlank(incoming.getPhoneNumber(), current.getPhoneNumber()));

        merged.setImageUrl(firstNonBlank(incoming.getImageUrl(), current.getImageUrl()));
        merged.setCoverImageUrl(firstNonBlank(incoming.getCoverImageUrl(), current.getCoverImageUrl()));

        merged.setVerified(incoming.isVerified());
        merged.setAvailable(incoming.isAvailable());
        merged.setRating(incoming.getRating());
        merged.setCompletedProjects(incoming.getCompletedProjects());

        merged.setAddress(incoming.getAddress() != null ? incoming.getAddress() : current.getAddress());
        merged.setCoverageArea(incoming.getCoverageArea() != null ? incoming.getCoverageArea() : current.getCoverageArea());
        merged.setSpecialties(incoming.getSpecialties() != null ? incoming.getSpecialties() : current.getSpecialties());

        return commandRepositoryPort.update(merged);
    }

    private String firstNonBlank(String a, String b) {
        return (a != null && !a.isBlank()) ? a : b;
    }
}
