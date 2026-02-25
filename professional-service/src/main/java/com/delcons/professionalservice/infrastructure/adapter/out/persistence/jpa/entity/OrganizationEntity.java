package com.delcons.professionalservice.infrastructure.adapter.out.persistence.jpa.entity;

import com.delcons.professionalservice.domain.model.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organizations")
public class OrganizationEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 180)
    private String name;

    @Column(name = "owner_user_id", nullable = false)
    private Long ownerUserId;

    @Embedded
    private AddressEmbeddable headquartersAddress;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BranchEntity> branches = new ArrayList<>();
}
