package com.delcons.professionalservice.domain.model;

import com.delcons.professionalservice.domain.model.enums.ProfessionalType;
import com.delcons.professionalservice.domain.model.enums.Specialty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professional {
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
    private Address mainAddress;
    private List<Branch> branches = new ArrayList<>();
    private Set<Specialty> specialties;
    private ProfessionalType type;
    private CoverageArea coverageArea;
}

