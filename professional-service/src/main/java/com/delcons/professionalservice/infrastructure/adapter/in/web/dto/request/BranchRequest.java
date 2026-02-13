package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request;

public record BranchRequest(
    Long id,
    AddressRequest address,
    CoverageAreaRequest coverageArea
) {}
