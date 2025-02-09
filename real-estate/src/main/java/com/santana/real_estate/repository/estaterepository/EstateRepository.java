package com.santana.real_estate.repository.estaterepository;


import com.santana.real_estate.domain.estatedomain.Estate;
import com.santana.real_estate.domain.estatedomain.EstateCategory;
import com.santana.real_estate.domain.estatedomain.EstateTransactionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstateRepository extends JpaRepository<Estate, Long> {

    Page<Estate> findByCategory(EstateCategory category, Pageable pageable);
    Page<Estate> findByCategoryAndTransactionType(EstateCategory category, EstateTransactionType transactionType, Pageable pageable);
}
