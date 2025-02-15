package com.santana.real_estate.repository.estaterepository;


import com.santana.real_estate.domain.estatedomain.address.EstateAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstateAddressRepository extends JpaRepository<EstateAddress, Long> {


}
