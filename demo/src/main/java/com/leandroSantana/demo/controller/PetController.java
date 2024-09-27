package com.leandroSantana.demo.controller;

import com.leandroSantana.demo.entity.Pet;
import com.leandroSantana.demo.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService petService;

@PostMapping
public Pet create(@RequestBody Pet pet){
   return petService.savePet(pet);
}
@GetMapping
public List<Pet> listAll(){
    return petService.listAll();
}
@PutMapping
public List<Pet> update(@RequestBody Pet pet){

    return petService.update(pet);
}
@DeleteMapping("{id}")
public List<Pet> delete(@PathVariable("id") Long id){
    return petService.deletePet(id);
}
}
