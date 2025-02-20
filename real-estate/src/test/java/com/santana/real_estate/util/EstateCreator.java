package com.santana.real_estate.util;


import com.santana.real_estate.domain.estatedomain.Estate;
import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import com.santana.real_estate.domain.estatedomain.address.EstateAddress;
import com.santana.real_estate.domain.estatedomain.address.Uf;

public class EstateCreator {



    public static Estate createEstateHouseToBeSave() {


        return Estate.builder()
               .price(0.00)
               .category(EstateCategory.HOUSE)
               .description("house Test")
               .transactionType(EstateTransactionType.SALE)
               .build();
    }

    public static Estate createEstateApartmentToBeSave() {

        return Estate.builder()
                .price(0.00)
                .category(EstateCategory.APARTMENT)
                .description("house Test")
                .transactionType(EstateTransactionType.RENTAL)
                .build();

    }

    public static Estate createEstateWithValidId() {
        EstateAddress address = EstateAddress.builder()
                .id(1L)
                .street("Rua velha")
                .number("A51")
                .uf(Uf.BA)
                .zipCode("154-222")
                .neighborhood("centro")
                .city("Camaça")
                .build();


        return Estate.builder()
                .id(3L)
                .price(0.00)
                .address(address)
                .category(EstateCategory.APARTMENT)
                .description("house Test")
                .transactionType(EstateTransactionType.RENTAL)
                .build();
    }

    public static Estate createEstateToBeUpdate() {
        EstateAddress address = EstateAddress.builder()
                .id(1L)
                .street("Rua velha 2")
                .number("A51 222")
                .uf(Uf.MA)
                .zipCode("154-222 66")
                .neighborhood("centro")
                .city("Teste City")
                .build();


        return Estate.builder()
                .price(0.00)
                .address(address)
                .category(EstateCategory.APARTMENT)
                .description("house Test update")
                .transactionType(EstateTransactionType.RENTAL)
                .build();
    }

    public static Estate createEstateHouseWithAddressNull() {

        return Estate.builder()
                .price(0.00)
                .category(EstateCategory.HOUSE)
                .description("house Test")
                .transactionType(EstateTransactionType.SALE)
                .address(null)
                .build();
    }

}
