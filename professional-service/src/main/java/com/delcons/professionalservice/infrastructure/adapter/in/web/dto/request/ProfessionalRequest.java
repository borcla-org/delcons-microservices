package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request;

import com.delcons.professionalservice.domain.model.enums.ProfessionalType;
import com.delcons.professionalservice.domain.model.enums.Specialty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

public record ProfessionalRequest(
        @NotBlank(message = "Nickname is required")
        @Size(min = 3, max = 30, message = "Nickname must be between 3 and 30 characters")
        @Pattern(
                regexp = "^[a-zA-Z0-9._-]+$",
                message = "Nickname can only contain letters, numbers, dot, underscore, and hyphen"
        )
        String nickname,

        @Email(message = "Email must be valid")
        @Size(max = 254, message = "Email is too long")
        @NotBlank String email,

        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 60, message = "Name must be between 2 and 60 characters")
        String name,

        @NotBlank(message = "Lastname is required")
        @Size(min = 2, max = 60, message = "Lastname must be between 2 and 60 characters")
        String lastname,

        @Size(max = 500, message = "Description must be at most 500 characters")
        String description,

        @NotBlank @Pattern(regexp = "^\\+[1-9]\\d{7,14}$")
        String phoneNumber,

        @Size(max = 2048, message = "ImageUrl is too long")
        @Pattern(
                regexp = "^(https?://).+",
                message = "ImageUrl must be a valid URL starting with http:// or https://"
        )
        String imageUrl,

        @Size(max = 2048, message = "CoverImageUrl is too long")
        @Pattern(
                regexp = "^(https?://).+",
                message = "CoverImageUrl must be a valid URL starting with http:// or https://"
        )
        String coverImageUrl,

        Set<Specialty> specialties,
        ProfessionalType type,

        @Valid
        AddressRequest mainAddress,

        @Valid
        CoverageAreaRequest coverageArea
) {
}