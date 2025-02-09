package com.santana.real_estate.controller;

import com.santana.real_estate.domain.estatedomain.Estate;
import com.santana.real_estate.dto.estatedto.EstatePostRequestBody;
import com.santana.real_estate.dto.estatedto.EstatePutRequestBody;
import com.santana.real_estate.service.estateservice.EstateService;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
class EstateControllerTest {
    @InjectMocks
    private EstateController estateController;

    @Mock
    private EstateService estateServiceMock;

    @BeforeEach
    void setUp() {
        PageImpl<Estate> EstatePage = new PageImpl<>(List.of(EstateCreator.createEstateWithValidId()));

        BDDMockito.when(estateServiceMock.findAll(ArgumentMatchers.any()))
                .thenReturn(EstatePage);

        BDDMockito.when(estateServiceMock.findByCategory(ArgumentMatchers.anyString(), ArgumentMatchers.any()))
                .thenReturn(EstatePage);

        BDDMockito.when(estateServiceMock.findByCategoryAndTransactionType(ArgumentMatchers.anyString(),
                ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(EstatePage);

        BDDMockito.when((estateServiceMock.save(ArgumentMatchers.any(EstatePostRequestBody.class))))
                .thenReturn(EstateCreator.createEstateWithValidId());

        BDDMockito.doNothing().when(estateServiceMock).replace(ArgumentMatchers.any(EstatePutRequestBody.class));

        BDDMockito.doNothing().when(estateServiceMock).delete(ArgumentMatchers.anyLong());
    }

    @Test
    @DisplayName("listAll Return page of Estate when successful")
    void listAll_returnPageOfEstate_whenSuccessful() {
        Estate expectedEstate = EstateCreator.createEstateWithValidId();

        ResponseEntity<Page<Estate>> response = estateController.listAll(null);
        Page<Estate> estatePage = estateController.listAll(null).getBody();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(estatePage).isNotNull().hasSize(1).isNotEmpty();

        Assertions.assertThat(estatePage.getContent().get(0)).isEqualTo(expectedEstate);
    }

    @Test
    @DisplayName("findByCategory Return page of Estate when successful")
    void findByCategory_returnPageOfEstate_whenSuccessful() {
        Estate expectedEstate = EstateCreator.createEstateWithValidId();

        ResponseEntity<Page<Estate>> response = estateController.findByCategory("house", null);
        Page<Estate> estatePage = estateController.findByCategory("house", null).getBody();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(estatePage).isNotNull().hasSize(1).isNotEmpty();

        Assertions.assertThat(estatePage.getContent().get(0).getCategory()).isEqualTo(expectedEstate.getCategory());
    }

    @Test
    @DisplayName("findByTransactionType Return page of Estate when successful")
    void findByCategoryAndTransactionType_returnPageOfEstate_whenSuccessful() {
        Estate expectedEstate = EstateCreator.createEstateWithValidId();

        ResponseEntity<Page<Estate>> response = estateController
                .findByCategoryAndTransactionType("house", "sale", null);
        Page<Estate> estatePage = estateController
                .findByCategoryAndTransactionType("house", "sale", null).getBody();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(estatePage).isNotNull().hasSize(1).isNotEmpty();

        Assertions.assertThat(estatePage.getContent().get(0).getCategory()).isEqualTo(expectedEstate.getCategory());
        Assertions.assertThat(estatePage.getContent().get(0).getTransactionType()).isEqualTo(expectedEstate.getTransactionType());
    }

    @Test
    @DisplayName("save Return the Estate saved when successful")
    void save_returnEstate_whenSuccessful() {
        EstatePostRequestBody estatePostRequestBody = EstatePostRequestBodyCreator.estatePostRequestBody();

        ResponseEntity<Estate> response = estateController.save(estatePostRequestBody);
        Estate savedEstate = estateController.save(estatePostRequestBody).getBody();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertThat(savedEstate).isNotNull().isEqualTo(EstateCreator.createEstateWithValidId());
    }

    @Test
    @DisplayName("Delete remove Estate when successful")
    void delete_removeEstate_whenSuccessful() {
        Assertions.assertThatCode(() -> estateController.delete(1L));
        ResponseEntity<Void> estateResponseEntity = estateController.delete(1L);

        Assertions.assertThat(estateResponseEntity).isNotNull();
        Assertions.assertThat(estateResponseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }

    @Test
    @DisplayName("replace update Estate when successful")
    void replace_updateEstate_whenSuccessful() {

        Assertions.assertThatCode(() -> estateController.replace(EstatePutRequestBodyCreator.estatePostRequestBody()));
        ResponseEntity<Void> estateResponseEntity = estateController.replace(EstatePutRequestBodyCreator.estatePostRequestBody());

        Assertions.assertThat(estateResponseEntity).isNotNull();
        Assertions.assertThat(estateResponseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}