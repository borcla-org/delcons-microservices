package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coverage_areas")
@Data
@NoArgsConstructor @AllArgsConstructor
public class CoverageAreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude",  column = @Column(name = "center_lat", precision = 9, scale = 6, nullable = false)),
            @AttributeOverride(name = "longitude", column = @Column(name = "center_lng", precision = 9, scale = 6, nullable = false))
    })
    private GeoPointEmbeddable center;

    @Column(name = "coverage_radius_km", nullable = false)
    private Integer radiusKm;
}
