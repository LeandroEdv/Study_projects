package com.santana.real_estate.repository.userrepository;

import com.santana.real_estate.domain.userdomain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    UserDetails findByUsername(String username);

    Boolean existsByUsername(String username);

   // Boolean existsByEmail(String email);
}
