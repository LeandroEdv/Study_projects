package com.santana.real_estate.domain.estatedomain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.santana.real_estate.domain.estatedomain.address.EstateAddress;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Estate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    //@Column(nullable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Address_id")
    @JsonManagedReference
    private EstateAddress address;

}
