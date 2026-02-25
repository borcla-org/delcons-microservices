package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request;

public record BranchRequest(
    AddressRequest address,
    CoverageAreaRequest coverageArea
) {}
