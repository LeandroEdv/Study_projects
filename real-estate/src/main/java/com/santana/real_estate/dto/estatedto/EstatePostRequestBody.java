package com.santana.real_estate.dto.estatedto;

import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstatePostRequestBody {

    @NotBlank(message = "the address cannot be null or blank")
    private String address;

    //To do: Annotation about Enumerate
    @NotBlank
    private EstateCategory category;

    @NotBlank
    private EstateTransactionType transactionType;

    @Size(min = 3, message = "the price must have 3 characters")
    @Positive
    private double price;

    @NotBlank(message = "the Estate must be a description")
    private String description;
}
