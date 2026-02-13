package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.response;

import java.math.BigDecimal;

public record GeoPointResponse(
    BigDecimal latitude,
    BigDecimal longitude
) {}
