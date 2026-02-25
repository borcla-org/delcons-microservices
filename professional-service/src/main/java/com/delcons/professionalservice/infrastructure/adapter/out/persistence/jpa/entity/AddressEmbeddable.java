package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEmbeddable {
    private String city;
    private String street;
    private String zip;
    private String country;
    private String state;
}
