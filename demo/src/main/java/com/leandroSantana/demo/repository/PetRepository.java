package com.leandroSantana.demo.repository;

import com.leandroSantana.demo.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {
}
