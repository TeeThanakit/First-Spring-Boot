package com.example.mysprintboot.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    List<String> productList = new ArrayList<>();

    @GetMapping
    public ResponseEntity<String> showText() {
        return ResponseEntity.ok("hello sprint boot");
    }

    @PostConstruct
    public void init() {
        productList.add("book");
        productList.add("pen");
        productList.add("pencil");
    }

    @GetMapping("/getAll")
    public ResponseEntity<List> getAll() {
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/add")
    public ResponseEntity<List> add(@RequestBody String product)
    {
        productList.add(product);
        return ResponseEntity.ok(productList);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> edit(@PathVariable("id") int id,@RequestBody String product)
    {
        try {
            productList.set(id-1,product);
            return ResponseEntity.ok(productList);
        }
        catch (IndexOutOfBoundsException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam("id") int id)
    {
        try{
            productList.remove(id);
            return ResponseEntity.ok("Delete success");
        }
        catch (IndexOutOfBoundsException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
    }
}
