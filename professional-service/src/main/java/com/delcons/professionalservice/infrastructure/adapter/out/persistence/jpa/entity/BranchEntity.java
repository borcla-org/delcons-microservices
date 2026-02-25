package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity;

import com.delcons.professionalservice.domain.model.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
@Table(name = "professional_branches")
public class BranchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organization_id", nullable = false)
    private OrganizationEntity organization;

    @Embedded
    private AddressEmbeddable address;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    @JoinColumn(name = "coverage_area_id", nullable = false, unique = true)
    private CoverageAreaEntity coverageArea;
}
