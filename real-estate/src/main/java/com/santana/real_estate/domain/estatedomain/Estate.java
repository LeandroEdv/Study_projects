package com.santana.real_estate.domain.estatedomain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Estate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstateCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstateTransactionType transactionType;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String description;

}
