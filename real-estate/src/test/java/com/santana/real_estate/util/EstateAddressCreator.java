package com.santana.real_estate.util;


import com.santana.real_estate.domain.estatedomain.Estate;
import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import com.santana.real_estate.domain.estatedomain.address.EstateAddress;
import com.santana.real_estate.domain.estatedomain.address.Uf;

public class EstateAddressCreator {

    public static EstateAddress createAddressToBeSave(){

        return EstateAddress.builder()
                .street("Rua velha")
                .number("A51")
                .uf(Uf.BA)
                .zipCode("154-222")
                .neighborhood("centro")
                .city("Camaça")
                .build();
    }
    public static EstateAddress createAddressNull(){

        return EstateAddress.builder()
                .street(null)
                .number("A51")
                .uf(Uf.BA)
                .zipCode("154-222")
                .neighborhood("centro")
                .city("Camaça")
                .build();
    }


}
