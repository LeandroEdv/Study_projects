package com.santana.real_estate.dto.estatedto.addressdto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstateAddressDto {

    // to do: implement validation
    private String street;

    private String number;

    private String zipCode;

    private String neighborhood;

    private String city;

    private String state;

}
