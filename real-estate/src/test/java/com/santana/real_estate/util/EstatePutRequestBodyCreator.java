package com.santana.real_estate.util;

import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import com.santana.real_estate.dto.estatedto.EstatePostRequestBody;
import com.santana.real_estate.dto.estatedto.EstatePutRequestBody;

public class EstatePutRequestBodyCreator {

public static EstatePutRequestBody estatePostRequestBody(){
    return EstatePutRequestBody.builder()
            .category(EstateCategory.HOUSE)
            .transactionType(EstateTransactionType.SALE)
            .address("Rua de Test sem numero")
            .price(151.00)
            .description("Casa a venda só para test")
            .build();
}
}
