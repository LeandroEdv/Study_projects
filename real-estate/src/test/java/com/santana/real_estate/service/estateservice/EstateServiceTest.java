package com.santana.real_estate.service.estateservice;

import com.santana.real_estate.domain.estatedomain.Estate;
import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import com.santana.real_estate.dto.estatedto.EstatePostRequestBody;
import com.santana.real_estate.repository.estaterepository.EstateRepository;
import com.santana.real_estate.util.EstateCreator;
import com.santana.real_estate.util.EstatePostRequestBodyCreator;
import com.santana.real_estate.util.EstatePutRequestBodyCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class EstateServiceTest {
    @InjectMocks
    private EstateService estateService;

    @Mock
    private EstateRepository estateRepositoryMock;

    @BeforeEach
    void setUp() {
        PageImpl<Estate> EstatePage = new PageImpl<>(List.of(EstateCreator.createEstateWithValidId()));

        BDDMockito.when(estateRepositoryMock.findAll(ArgumentMatchers.any(PageRequest.class)))
                .thenReturn(EstatePage);

        BDDMockito.when(estateRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(EstateCreator.createEstateWithValidId()));

        BDDMockito.when(estateRepositoryMock.findByCategory(ArgumentMatchers.any(EstateCategory.class),
                ArgumentMatchers.any())).thenReturn(EstatePage);

        BDDMockito.when(estateRepositoryMock.findByCategoryAndTransactionType(ArgumentMatchers.any(EstateCategory.class),
                ArgumentMatchers.any(EstateTransactionType.class), ArgumentMatchers.any())).thenReturn(EstatePage);

        BDDMockito.when((estateRepositoryMock.save(ArgumentMatchers.any(Estate.class))))
                .thenReturn(EstateCreator.createEstateWithValidId());

        BDDMockito.doNothing().when(estateRepositoryMock).delete(ArgumentMatchers.any(Estate.class));
    }

    @Test
    @DisplayName("listAll Return page of Estate when successful")
    void findAll_returnPageOfEstate_whenSuccessful() {
        Estate expectedEstate = EstateCreator.createEstateWithValidId();
        PageRequest pageRequest = PageRequest.of(1, 10);

        Page<Estate> estatePage = estateService.findAll(pageRequest);

        Assertions.assertThat(estatePage).isNotNull().hasSize(1).isNotEmpty();
        Assertions.assertThat(estatePage.getContent().get(0)).isEqualTo(expectedEstate);
    }

    @Test
    @DisplayName("findByIdOrThrowBadRequestException Return Estate when successful")
    void findByIdOrThrowResponseStatusException_returnEstate_whenSuccessful() {
        Estate expectedEstate = EstateCreator.createEstateWithValidId();
        PageRequest pageRequest = PageRequest.of(1, 10);

        Estate estatePage = estateService.findByIdOrThrowResponseStatusException(1L);

        Assertions.assertThat(estatePage).isNotNull();

        Assertions.assertThat(estatePage.getId()).isEqualTo(expectedEstate.getId());
    }

    @Test
    @DisplayName("findByIdOrThrowResponseStatusException throw ResponseStatusException when Estate is not found")
    void findByIdOrThrowResponseStatusException_throwResponseStatusException_whenEstateIsNotFound() {

        BDDMockito.when(estateRepositoryMock.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.empty());

        Assertions.assertThatExceptionOfType(ResponseStatusException.class)
                .isThrownBy(() -> estateService.findByIdOrThrowResponseStatusException(1));
    }

    @Test
    @DisplayName("findByCategory Return page of Estate when successful")
    void findByCategory_returnPageOfEstate_whenSuccessful() {
        Estate expectedEstate = EstateCreator.createEstateWithValidId();
        PageRequest pageRequest = PageRequest.of(1, 10);

        Page<Estate> estatePage = estateService.findByCategory("house", pageRequest);

        Assertions.assertThat(estatePage).isNotNull().hasSize(1).isNotEmpty();
        Assertions.assertThat(estatePage.getContent().get(0).getCategory()).isEqualTo(expectedEstate.getCategory());
    }
    @Test
    @DisplayName("findByTransactionType Return page of Estate when successful")
    void findByCategoryAndTransactionType_returnPageOfEstate_whenSuccessful() {
        Estate expectedEstate = EstateCreator.createEstateWithValidId();

        Page<Estate> estatePage = estateService
                .findByCategoryAndTransactionType("house", "sale", null);

        Assertions.assertThat(estatePage).isNotNull().hasSize(1).isNotEmpty();
        Assertions.assertThat(estatePage.getContent().get(0).getCategory()).isEqualTo(expectedEstate.getCategory());
        Assertions.assertThat(estatePage.getContent().get(0).getTransactionType()).isEqualTo(expectedEstate.getTransactionType());
    }

    @Test
    @DisplayName("save Return the Estate saved when successful")
    void save_returnEstate_whenSuccessful() {
        EstatePostRequestBody estatePostRequestBody = EstatePostRequestBodyCreator.estatePostRequestBody();

        Estate savedEstate = estateService.save(estatePostRequestBody);

        Assertions.assertThat(savedEstate).isNotNull().isEqualTo(EstateCreator.createEstateWithValidId());
    }

    @Test
    @DisplayName("Delete remove Estate when successful")
    void delete_removeEstate_whenSuccessful() {
        Assertions.assertThatCode(() -> estateService.delete(1L));
    }

    //
    @Test
    @DisplayName("replace update Estate when successful")
    void replace_updateEstate_whenSuccessful() {

        Assertions.assertThatCode(() -> estateService.replace(EstatePutRequestBodyCreator.estatePostRequestBody()));

    }
}