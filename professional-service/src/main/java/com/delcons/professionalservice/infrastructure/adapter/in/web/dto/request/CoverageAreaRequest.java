package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CoverageAreaRequest(
        @Valid GeoPointRequest center,
        @NotNull Integer radiusKm
) {
}
