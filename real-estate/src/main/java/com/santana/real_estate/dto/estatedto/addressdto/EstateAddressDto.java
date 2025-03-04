package com.santana.real_estate.dto.estatedto.addressdto;

import com.santana.real_estate.domain.estatedomain.address.Uf;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstateAddressDto {


    @NotBlank(message = "The category cannot be null")
    @Schema(description = "Address Street", example = "Rua: Helena")
    private String street;

    @Schema(description = "Property number", example = "265A")
    private String number;

    @Schema(description = "Address Zip-Code", example = "93220-690")
    private String zipCode;

    @NotNull(message = "Address Neighborhood cannot be null")
    @Schema(description = "Address Neighborhood", example = "Bela Vista")
    private String neighborhood;

    @NotNull(message = "The City cannot be null")
    @Schema(description = "City", example = "Porto Alegre")
    private String city;

    @Enumerated(EnumType.STRING)
    @Schema(description = "uf", example = "GO, DF, BA")
    private Uf uf;

}
