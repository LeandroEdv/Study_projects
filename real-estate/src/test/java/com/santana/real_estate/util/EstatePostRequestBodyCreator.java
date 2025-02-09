package com.santana.real_estate.util;

import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import com.santana.real_estate.dto.estatedto.EstatePostRequestBody;

public class EstatePostRequestBodyCreator {

public static EstatePostRequestBody estatePostRequestBody(){
    return EstatePostRequestBody.builder()
            .category(EstateCategory.HOUSE)
            .transactionType(EstateTransactionType.SALE)
            .address("Rua de Test sem numero")
            .price(151.00)
            .description("Casa a venda só para test")
            .build();
}
}
