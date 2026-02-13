package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request;

public record CoverageAreaRequest(
    Long id,
    GeoPointRequest center,
    Integer radiusKm
) {}
