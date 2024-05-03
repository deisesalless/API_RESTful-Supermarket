package com.deisesales.supermarket.controllers;

import com.deisesales.supermarket.dtos.ProductRecordDTO;
import com.deisesales.supermarket.models.ProductModel;
import com.deisesales.supermarket.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping("/product")
    public ResponseEntity<ProductModel> register(@RequestBody @Valid ProductRecordDTO data) {
        var product = new ProductModel();
        BeanUtils.copyProperties(data, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductModel>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("product/{id}")
    public ResponseEntity<ProductModel> findByID(@PathVariable UUID id) {
         Optional<ProductModel> product = repository.findById(id);

         if (product.isEmpty()) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         return ResponseEntity.status(HttpStatus.OK).body(product.get());
    }

    @PutMapping("product/{id}")
    public ResponseEntity<ProductModel> update(@PathVariable UUID id, @RequestBody @Valid ProductRecordDTO data) {
        Optional<ProductModel> product = repository.findById(id);

        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        BeanUtils.copyProperties(data, product.get());
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(product.get()));
    }

    @DeleteMapping("product/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        Optional<ProductModel> product = repository.findById(id);

        if (product.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
