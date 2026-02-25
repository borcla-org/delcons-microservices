package com.delcons.professionalservice.infrastructure.adapter.in.web.mapper;

import com.delcons.professionalservice.domain.model.*;
import com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request.*;
import com.delcons.professionalservice.infrastructure.adapter.in.web.dto.response.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfessionalRestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rating", ignore = true)
    @Mapping(target = "completedProjects", ignore = true)
    @Mapping(target = "verified", ignore = true)
    @Mapping(target = "available", ignore = true)
    Professional toDomain(ProfessionalRequest request);

    ProfessionalResponse toResponse(Professional professional);

    Address toDomain(AddressRequest dto);
    AddressResponse toDto(Address domain);

    CoverageArea toDomain(CoverageAreaRequest dto);
    CoverageAreaResponse toDto(CoverageArea domain);

    GeoPoint toDomain(GeoPointRequest dto);
    GeoPointResponse toDto(GeoPoint domain);
}