package com.delcons.professionalservice.domain.model;

import com.delcons.professionalservice.domain.model.enums.ProfessionalType;
import com.delcons.professionalservice.domain.model.enums.Specialty;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professional implements Cloneable{
    private Long id;
    private String nickname;
    private String name;
    private String email;
    private String lastname;
    private String description;
    private String phoneNumber;
    private String imageUrl;
    private String coverImageUrl;
    private boolean verified;
    private boolean available;
    private double rating;
    private Integer completedProjects;

    private Address address;

    private Long organizationId;

    private Set<Specialty> specialties;
    private ProfessionalType type;
    private CoverageArea coverageArea;

    public void changeType(ProfessionalType type) {
        this.type = type;
        enforceCoverageAreaRule();
    }

    public void setCoverageArea(CoverageArea coverageArea) {
        this.coverageArea = coverageArea;
        enforceCoverageAreaRule();
    }

    private void enforceCoverageAreaRule() {
        if (this.type == null) {
            return;
        }

        boolean independent = this.type == ProfessionalType.INDIVIDUAL;

        if (independent && this.coverageArea == null) {
            throw new IllegalArgumentException("CoverageArea es obligatorio para independientes");
        }
        if (!independent && this.coverageArea != null) {
            throw new IllegalArgumentException("CoverageArea solo aplica para independientes");
        }
    }

    @Override
    public Professional clone() {
        try {
            return (Professional) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}