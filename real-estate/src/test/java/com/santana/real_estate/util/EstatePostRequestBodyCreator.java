package com.santana.real_estate.util;

import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import com.santana.real_estate.dto.estatedto.EstatePostRequestBody;
import com.santana.real_estate.dto.estatedto.addressdto.EstateAddressDto;

public class EstatePostRequestBodyCreator {


public static EstatePostRequestBody estatePostRequestBody(){
    EstateAddressDto address = EstateAddressDto.builder()
            .street("Rua velha")
            .number("A51")
            .uf("BA")
            .zipCode("154-222")
            .neighborhood("centro")
            .city("Camaça")
            .build();

    return EstatePostRequestBody.builder()
            .category(EstateCategory.HOUSE)
            .transactionType(EstateTransactionType.SALE)
            .address(address)
            .price(151.00)
            .description("Casa a venda só para test")
            .build();
}
}
