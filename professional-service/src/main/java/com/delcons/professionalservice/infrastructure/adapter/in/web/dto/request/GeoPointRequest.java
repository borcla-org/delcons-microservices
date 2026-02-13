package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request;

import java.math.BigDecimal;

public record GeoPointRequest(
    BigDecimal latitude,
    BigDecimal longitude
) {}
