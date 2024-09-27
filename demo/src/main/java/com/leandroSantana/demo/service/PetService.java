package com.leandroSantana.demo.service;

import com.leandroSantana.demo.entity.Pet;
import com.leandroSantana.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public Pet savePet(Pet pet){
        return petRepository.save(pet);
    }
    public List<Pet> listAll(){
        return petRepository.findAll();
    }
    public Pet listId(Long id){
        return petRepository.findById(id).orElse(null);
    }
    public List<Pet> update(Pet pet){
        petRepository.save(pet);
        return listAll();
    }
    public List<Pet> deletePet(Long id){
        petRepository.deleteById(id);
        return  listAll();
    }
}
