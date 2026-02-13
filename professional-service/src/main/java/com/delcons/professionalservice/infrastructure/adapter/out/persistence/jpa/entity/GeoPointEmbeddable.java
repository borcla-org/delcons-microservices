package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoPointEmbeddable {
    @NotNull
    @DecimalMin("-90.0") @DecimalMax("90.0")
    @Column(precision = 9, scale = 6, nullable = false)
    private BigDecimal latitude;

    @NotNull
    @DecimalMin("-180.0") @DecimalMax("180.0")
    @Column(precision = 9, scale = 6, nullable = false)
    private BigDecimal longitude;
}
