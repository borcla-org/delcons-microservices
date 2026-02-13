package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.response;

import com.delcons.professionalservice.domain.model.enums.ProfessionalType;
import com.delcons.professionalservice.domain.model.enums.Specialty;
import java.util.List;
import java.util.Set;

public record ProfessionalResponse(
    Long id,
    String nickname,
    String name,
    String email,
    String lastname,
    String description,
    String phoneNumber,
    String imageUrl,
    String coverImageUrl,
    boolean verified,
    boolean available,
    double rating,
    Integer completedProjects,
    Set<Specialty> specialties,
    ProfessionalType type,
    AddressResponse mainAddress,
    List<BranchResponse> branches,
    CoverageAreaResponse coverageArea
) {}
