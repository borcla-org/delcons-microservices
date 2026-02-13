package com.delcons.professionalservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoverageArea {
    private Long id;
    private GeoPoint center;
    private Integer radiusKm;
}

