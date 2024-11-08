package com.example.mysprintboot.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/animals")
@Slf4j
public class AnimalController {

    List<String> animals = new ArrayList<>();

    @PostConstruct
    public void init() {
        animals.add("cat");
        animals.add("dog");
        animals.add("hippo");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List> getAll()
    {
        return ResponseEntity.ok(animals);
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getById(@PathVariable("id") int id)
    {
        String animal = animals.get(id);
        return ResponseEntity.ok(animal);
    }

    @PostMapping("/add")
    public ResponseEntity<List> add(@RequestBody String animal) {
        animals.add(animal);
        return ResponseEntity.ok(animals);
    }

    @PutMapping()
    public ResponseEntity<?> edit(@RequestParam("id") int id, @RequestBody String animal)
    {
        try {
            animals.set(id-1,animal);
            return ResponseEntity.ok(animals);
        }
        catch (IndexOutOfBoundsException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) {
        try {
            animals.remove(id);
            return ResponseEntity.ok("Deleted");
        }
        catch (IndexOutOfBoundsException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
    }
}
