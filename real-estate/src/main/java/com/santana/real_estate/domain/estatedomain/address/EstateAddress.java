package com.santana.real_estate.domain.estatedomain.address;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.santana.real_estate.domain.estatedomain.Estate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "TB_ADDRESS")
public class EstateAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column()
    private String number;

    @Column()
    private String zipCode;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String state;


    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    @JsonBackReference
    private Estate estate;

}


