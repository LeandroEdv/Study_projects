package com.santana.real_estate.dto.estatedto;

import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import com.santana.real_estate.dto.estatedto.addressdto.EstateAddressDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstatePutRequestBody {

    @NotNull(message = "The ID cannot be null")
    private long id;

    //To do: Annotation about Enumerate
    @NotNull(message = "The category cannot be null")
    @Enumerated(EnumType.STRING)
    @Schema(description = "Estate category", example = "HOUSE / APARTMENT")
    private EstateCategory category;

    @NotNull(message = "The transaction type cannot be null")
    @Enumerated(EnumType.STRING)
    @Schema(description = "Estate transaction type", example = "RENTAL / SALE")
    private EstateTransactionType transactionType;

    @NotNull(message = "The price cannot be null")
    @Schema(description = "Estate transaction price", example = "2500.00")
    @Positive
    private double price;

    @NotBlank(message = "The description cannot be blank")
    @Schema(description = "Estate description", example = "large house near of a park")
    private String description;

    //@NotBlank(message = "the address cannot be null or blank")
    private EstateAddressDto address;

}
