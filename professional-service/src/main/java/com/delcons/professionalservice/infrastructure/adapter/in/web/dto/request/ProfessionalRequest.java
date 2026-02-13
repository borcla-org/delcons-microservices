package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request;

import com.delcons.professionalservice.domain.model.enums.ProfessionalType;
import com.delcons.professionalservice.domain.model.enums.Specialty;
import java.util.List;
import java.util.Set;

public record ProfessionalRequest(
    String nickname,
    String name,
    String email,
    String lastname,
    String description,
    String phoneNumber,
    String imageUrl,
    String coverImageUrl,
    Set<Specialty> specialties,
    ProfessionalType type,
    AddressRequest mainAddress,
    List<BranchRequest> branches,
    CoverageAreaRequest coverageArea
) {}
