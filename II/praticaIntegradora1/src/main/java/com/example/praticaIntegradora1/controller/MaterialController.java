package com.example.praticaIntegradora1.controller;

import com.example.praticaIntegradora1.DTO.MaterialInputDTO;
import com.example.praticaIntegradora1.model.Material;
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
@RequestMapping("/material")
public class MaterialController {

    private final ModelMapper modelMapper;
    private MaterialRepository repository;

    @PostMapping(path = "/new")
    public ResponseEntity<Material> create(@RequestBody MaterialInputDTO payload) {
        Material material = modelMapper.map(payload, Material.class);
        Material response = repository.save(material);
        return ResponseEntity.created(URI.create("/get/"+response.getId())).body(response);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Material>> getAll() {
        List<Material> response = repository.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Material> getById(@PathVariable Integer id) {
        try {
            Material response = repository.findById(id).get();
            return ResponseEntity.ok().body(response);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Material> updateById(@PathVariable Integer id, @RequestBody MaterialInputDTO payload) {
        if (repository.existsById(id)) {
            Material newItem = modelMapper.map(payload, Material.class);
            newItem.setId(id);
            repository.save(newItem);
            return ResponseEntity.ok().body(newItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
