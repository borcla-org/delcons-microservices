package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.response;

public record CoverageAreaResponse(
    Long id,
    GeoPointResponse center,
    Integer radiusKm
) {}
