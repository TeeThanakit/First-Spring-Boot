package com.example.mysprintboot.Service;

import com.example.mysprintboot.Entity.Pet;
import com.example.mysprintboot.Repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

//    public List<Pet> FindByBreed(String breed){
//        return petRepository.findByBreeds(breed);
//    }

//    public List<Pet> FindByBreedAndType(String breed, String type){
//        return petRepository.findByBreedsLikeOrTypeOrderByNameASC(breed, type);
//    }
//
//    public List<Pet> FindByBirthDay(int birthDay){
//        return petRepository.findByBirthYearGreaterThan(birthDay);
//    }
//
//    public List<Pet> FindByBreedNameAndType(String name, String breeds, String type){
//        return petRepository.findByNameEqualsAndBreedsEqualsAndTypeEquals(name,breeds,type);
//    }
}
