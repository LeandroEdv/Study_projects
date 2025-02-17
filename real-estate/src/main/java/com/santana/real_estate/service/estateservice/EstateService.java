package com.santana.real_estate.service.estateservice;

import com.santana.real_estate.domain.estatedomain.Estate;
import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import com.santana.real_estate.domain.estatedomain.address.EstateAddress;
import com.santana.real_estate.dto.estatedto.EstatePostRequestBody;
import com.santana.real_estate.dto.estatedto.EstatePutRequestBody;
import com.santana.real_estate.repository.estaterepository.EstateRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class EstateService {

    private final EstateRepository estateRepository;

    public Page<Estate> findAll(Pageable pageable) {

        return estateRepository.findAll(pageable);
    }

    public Page<Estate> findByCategory(String category, Pageable pageable) {

        return estateRepository.findByCategory(EstateCategory.valueOf(category.toUpperCase()), pageable);
    }

    public Page<Estate> findByCategoryAndTransactionType(String category, String transactionType, Pageable pageable) {

        return estateRepository.findByCategoryAndTransactionType(EstateCategory.valueOf(category.toUpperCase()),
                EstateTransactionType.valueOf(transactionType.toUpperCase()), pageable);
    }

    public Estate findByIdOrThrowResponseStatusException(long id) {
        return estateRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("Estate id '%d' not found", id)));
    }
@Transactional
    public Estate save(EstatePostRequestBody estatePostRequestBody) {

        EstateAddress address = EstateAddress.builder()
                .street(estatePostRequestBody.getAddress().getStreet())
                .number(estatePostRequestBody.getAddress().getNumber())
                .uf(estatePostRequestBody.getAddress().getUf())
                .zipCode(estatePostRequestBody.getAddress().getZipCode())
                .neighborhood(estatePostRequestBody.getAddress().getNeighborhood())
                .city(estatePostRequestBody.getAddress().getCity())
                .build();

        Estate estate = Estate.builder()
                .price(estatePostRequestBody.getPrice())
                .category(estatePostRequestBody.getCategory())
                .transactionType(estatePostRequestBody.getTransactionType())
                .address(address)
                .description(estatePostRequestBody.getDescription())
                .build();
        return estateRepository.save(estate);
    }

    public void delete(long id) {

        estateRepository.delete(findByIdOrThrowResponseStatusException(id));
    }

    public void replace(EstatePutRequestBody estatePutRequestBody) {
        Estate estate = findByIdOrThrowResponseStatusException(estatePutRequestBody.getId());
        EstateAddress address = EstateAddress.builder()
                .street(estatePutRequestBody.getAddress().getStreet())
                .number(estatePutRequestBody.getAddress().getNumber())
                .uf(estatePutRequestBody.getAddress().getUf())
                .zipCode(estatePutRequestBody.getAddress().getZipCode())
                .neighborhood(estatePutRequestBody.getAddress().getNeighborhood())
                .city(estatePutRequestBody.getAddress().getCity())
                .build();

        estate = Estate.builder()
                .id(estatePutRequestBody.getId())
                .price(estatePutRequestBody.getPrice())
                .transactionType(estatePutRequestBody.getTransactionType())
                .category(estatePutRequestBody.getCategory())
                .address(address)
                .description(estatePutRequestBody.getDescription())
                .build();
        estateRepository.save(estate);
    }
}

