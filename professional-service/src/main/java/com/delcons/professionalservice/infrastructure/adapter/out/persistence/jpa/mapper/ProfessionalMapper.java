package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.mapper;

import com.delcons.professionalservice.domain.model.*;
import com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfessionalMapper {

    ProfessionalEntity toEntity(Professional domain);

    Professional toDomain(ProfessionalEntity entity);

    AddressEmbeddable toEmbeddable(Address domain);
    Address toDomain(AddressEmbeddable entity);

    CoverageAreaEntity toEntity(CoverageArea domain);
    CoverageArea toDomain(CoverageAreaEntity entity);

    GeoPointEmbeddable toEntity(GeoPoint domain);
    GeoPoint toDomain(GeoPointEmbeddable entity);

}
