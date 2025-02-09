package com.santana.real_estate.util;

import com.santana.real_estate.domain.estatedomain.Estate;
import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;

public class EstateCreator {

    public static Estate createEstateHouseToBeSave() {
        return Estate.builder()
                .price(0.00)
                .address("Rua: test 1st april")
                .category(EstateCategory.HOUSE)
                .description("house Test")
                .transactionType(EstateTransactionType.SALE)
                .build();
    }

    public static Estate createEstateApartmentToBeSave() {
        return Estate.builder()
                .price(0.00)
                .address("Rua: test 2st april")
                .category(EstateCategory.APARTMENT)
                .description("house Test")
                .transactionType(EstateTransactionType.RENTAL)
                .build();
    }
    public static Estate createEstateWithValidId() {
        return Estate.builder()
                .id(1L)
                .price(0.00)
                .address("Rua: test 2st april")
                .category(EstateCategory.APARTMENT)
                .description("house Test")
                .transactionType(EstateTransactionType.RENTAL)
                .build();
    }
    public static Estate createEstateToBeUpdate() {
        return Estate.builder()
                .id(1L)
                .price(0.00)
                .address("Rua: test 2st april update")
                .category(EstateCategory.APARTMENT)
                .description("house Test update")
                .transactionType(EstateTransactionType.RENTAL)
                .build();
    }

    public static Estate createEstateHouseWithAddressNull() {
        return Estate.builder()
                .price(0.00)
                .address("Rua: test 1st april")
                .category(EstateCategory.HOUSE)
                .description("house Test")
                .transactionType(EstateTransactionType.SALE)
                .address(null)
                .build();
    }

}
