package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.response;

public record BranchResponse(
    Long id,
    AddressResponse address,
    CoverageAreaResponse coverageArea
) {}
