package com.santana.real_estate.repository.estaterepository;

import com.santana.real_estate.domain.estatedomain.Estate;
import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import com.santana.real_estate.domain.estatedomain.address.EstateAddress;
import com.santana.real_estate.util.EstateAddressCreator;
import com.santana.real_estate.util.EstateCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@DataJpaTest
@DisplayName("Estate Repository test")
class EstateRepositoryTest {

    @Autowired
    private EstateRepository estateRepository;
    @Autowired
    private EstateAddressRepository estateAddressRepository;

    @BeforeEach
    void SetUp() {

        EstateAddress estateAddress01 = EstateAddressCreator.createAddressToBeSave();
        EstateAddress estateAddressSavad01 = this.estateAddressRepository.save(estateAddress01);
        EstateAddress estateAddress02 = EstateAddressCreator.createAddressToBeSave();
        EstateAddress estateAddressSavad02 = this.estateAddressRepository.save(estateAddress02);


        Estate house = EstateCreator.createEstateHouseToBeSave();
        house.setAddress(estateAddressSavad01);
        Estate houseSaved = this.estateRepository.save(house);

        Estate apartment = EstateCreator.createEstateApartmentToBeSave();
        apartment.setAddress(estateAddressSavad02);

        Estate apartmentToSave = this.estateRepository.save(apartment);
    }

    @Test
    @DisplayName("FindByCategory return list of Estate matching the category")
    void findByCategory_returnListOfEstate_whenSuccessful() {


        Pageable pageable = PageRequest.of(0, 10);

        Page<Estate> houseList = this.estateRepository.findByCategory(EstateCategory.HOUSE, pageable);
        Page<Estate> apartmentList = this.estateRepository.findByCategory(EstateCategory.APARTMENT, pageable);


        Assertions.assertThat(houseList.getContent()).isNotEmpty().hasSize(1);

        Assertions.assertThat(apartmentList.getContent()).isNotEmpty().hasSize(1);

        Assertions.assertThat(houseList.getContent().get(0).getCategory()).isEqualTo(EstateCategory.HOUSE);
        Assertions.assertThat(apartmentList.getContent().get(0).getCategory()).isEqualTo(EstateCategory.APARTMENT);

    }


    @Test
    @DisplayName("findByCategory Returns Empty List When NoMatch")
    void findByCategory_ReturnsEmptyList_whenNoMatch() {
        Pageable pageable = PageRequest.of(0, 10);
        estateAddressRepository.deleteAll();
        estateRepository.deleteAll();

        Page<Estate> estates = this.estateRepository.findByCategory(EstateCategory.HOUSE, pageable);
        Assertions.assertThat(estates).isEmpty();
    }

    @Test
    @DisplayName("findByCategoryAndTransactionType return list of Estates matching category and transaction type when successful")
    void findByCategoryAndTransactionType_returnListOfEstate_whenSuccessful() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Estate> houseList = this.estateRepository
                .findByCategoryAndTransactionType(EstateCategory.HOUSE, EstateTransactionType.SALE, pageable);
        Page<Estate> apartmentList = this.estateRepository
                .findByCategoryAndTransactionType(EstateCategory.APARTMENT, EstateTransactionType.RENTAL, pageable);

        Assertions.assertThat(houseList).isNotNull().hasSize(1);
        Assertions.assertThat(apartmentList).isNotNull().hasSize(1);

        Assertions.assertThat(houseList.getContent().get(0).getCategory()).isEqualTo(EstateCategory.HOUSE);
        Assertions.assertThat(apartmentList.getContent().get(0).getCategory()).isEqualTo(EstateCategory.APARTMENT);

        Assertions.assertThat(houseList.getContent().get(0).getTransactionType()).isEqualTo(EstateTransactionType.SALE);
        Assertions.assertThat(apartmentList.getContent().get(0).getTransactionType()).isEqualTo(EstateTransactionType.RENTAL);
    }

    @Test
    @DisplayName("findByCategoryAndTransactionType Returns Empty List When NoMatch")
    void findByCategoryAndTransactionType_returnsEmptyList_whenNoMatch() {
        Pageable pageable = PageRequest.of(0, 10);
        estateRepository.deleteAll();
        Page<Estate> houseList = this.estateRepository
                .findByCategoryAndTransactionType(EstateCategory.HOUSE, EstateTransactionType.SALE, pageable);

        Page<Estate> apartmentList = this.estateRepository
                .findByCategoryAndTransactionType(EstateCategory.APARTMENT, EstateTransactionType.RENTAL, pageable);

        Assertions.assertThat(houseList.getContent()).isEmpty();
        Assertions.assertThat(apartmentList.getContent()).isEmpty();
    }

    //    @Test
//    @DisplayName("save Throws DataIntegrityViolationException when address is null")
//    void save_throwsDataIntegrityViolationException_whenAddressIsNull() {
//        EstateAddress estateAddress = null;
//
//        Estate estate = EstateCreator.createEstateHouseWithAddressNull();
//        estate.setAddress(estateAddress);
//
//        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
//                .isThrownBy(() -> this.estateRepository.save(estate));
//    }

    @Test
    @DisplayName("save Throws DataIntegrityViolationException when address is null")
    void save_throwsDataIntegrityViolationException_whenAddressIsNull() {

        EstateAddress address = EstateAddressCreator.createAddressNull();
        Estate estate = EstateCreator.createEstateHouseWithAddressNull();
        estate.setAddress(address);

        Assertions.assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> this.estateRepository.save(estate));
    }
}