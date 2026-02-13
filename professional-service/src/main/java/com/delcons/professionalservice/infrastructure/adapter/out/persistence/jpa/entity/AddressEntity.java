package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor @AllArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120)
    private String city;

    @Column(length = 200)
    private String street;

    @Column(length = 20)
    private String zip;

    @Column(length = 120)
    private String country;

    @Column(length = 120)
    private String state;
}
