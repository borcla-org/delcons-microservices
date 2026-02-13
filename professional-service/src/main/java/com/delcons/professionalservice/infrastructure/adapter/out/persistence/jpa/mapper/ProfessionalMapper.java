package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.mapper;

import com.delcons.professionalservice.domain.model.*;
import com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity.*;
import com.delcons.professionalservice.infrastructure.adapter.persistence.jpa.entity.*;
import com.delcons.professionalservice.infrastructure.out.persistence.jpa.entity.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProfessionalMapper {

    ProfessionalEntity toEntity(Professional domain);

    Professional toDomain(ProfessionalEntity entity);

    AddressEntity toEntity(Address domain);
    Address toDomain(AddressEntity entity);

    CoverageAreaEntity toEntity(CoverageArea domain);
    CoverageArea toDomain(CoverageAreaEntity entity);

    GeoPointEmbeddable toEntity(GeoPoint domain);
    GeoPoint toDomain(GeoPointEmbeddable entity);

    @Mapping(target = "professional", ignore = true)
    BranchEntity toEntity(Branch domain);

    @Mapping(target = "professional", ignore = true)
    Branch toDomain(BranchEntity entity);

    @AfterMapping
    default void linkBranches(@MappingTarget ProfessionalEntity professionalEntity) {
        if (professionalEntity.getBranches() != null) {
            professionalEntity.getBranches().forEach(branch -> branch.setProfessional(professionalEntity));
        }
    }
}
