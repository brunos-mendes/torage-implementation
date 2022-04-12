package com.example.praticaIntegradora1.controller;

import com.example.praticaIntegradora1.DTO.JewelInput;
import com.example.praticaIntegradora1.model.Jewel;
import com.example.praticaIntegradora1.repository.CategoryRepository;
import com.example.praticaIntegradora1.repository.JewelRepository;
import com.example.praticaIntegradora1.repository.MaterialRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@AllArgsConstructor
@RequestMapping("/jewel")
public class jewelController {

    private final ModelMapper modelMapper;
    private JewelRepository repository;
    private CategoryRepository categoryRepository;
    private MaterialRepository materialRepository;

    @PostMapping(path = "/new")
    public ResponseEntity<Jewel> create(@RequestBody JewelInput payload) {
        Jewel newJewel = modelMapper.map(payload, Jewel.class);
        newJewel.setCategory(categoryRepository.getById(payload.getCategory_id()));
        newJewel.setMaterial(materialRepository.getById(payload.getMaterial_id()));
        Jewel response = repository.save(newJewel);
        return ResponseEntity.created(URI.create("/get/"+response.getId())).body(response);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Jewel>> getAll() {
        List<Jewel> response = repository.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Jewel> getById(@PathVariable Integer id) {
        try {
            Jewel response = repository.findById(id).get();
            return ResponseEntity.ok().body(response);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Jewel> deleteById(@PathVariable Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Jewel> updateById(@PathVariable Integer id, @RequestBody JewelInput payload) {
        if (repository.existsById(id)) {
            Jewel newItem = modelMapper.map(payload, Jewel.class);
            newItem.setId(id);
            repository.save(newItem);
            return ResponseEntity.ok().body(newItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
