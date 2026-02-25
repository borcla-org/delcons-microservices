package com.delcons.professionalservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {
    private Long id;

    private Long organizationId;

    private Address address;
    private CoverageArea coverageArea;
}
