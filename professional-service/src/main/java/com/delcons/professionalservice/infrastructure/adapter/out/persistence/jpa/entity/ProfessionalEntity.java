package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity;

import com.delcons.professionalservice.domain.model.enums.ProfessionalType;
import com.delcons.professionalservice.domain.model.enums.Specialty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "professionals")
public class ProfessionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickname;

    private String name;

    @Column(nullable = false, unique = true)
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

    @Embedded
    private AddressEmbeddable mainAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id")
    private OrganizationEntity organization;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Set<Specialty> specialties;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProfessionalType type;

    @OneToOne(fetch = FetchType.LAZY)
    private CoverageAreaEntity coverageArea;
}
