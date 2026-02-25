package com.delcons.professionalservice.domain.model;

import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    private Long id;
    private String name;
    private Long ownerUserId;
    private Address headquartersAddress;
    private List<Branch> branches = new ArrayList<>();
}
