package com.example.mysprintboot.controller;

import com.example.mysprintboot.Entity.Pet;
import com.example.mysprintboot.Entity.UsersTrain;
import com.example.mysprintboot.Service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
@RequiredArgsConstructor
public class PetController {
    private final PetService petService;



//    @GetMapping("/getByBreeds")
//    public ResponseEntity<List<Pet>> getBreedsOne(@RequestParam("input") String input) {
//        return ResponseEntity.ok(petService.FindByBreed(input));
//    }
}
