package com.example.praticaIntegradora1.controller;

import com.example.praticaIntegradora1.DTO.CategoryInputDTO;
import com.example.praticaIntegradora1.model.Category;
import com.example.praticaIntegradora1.repository.CategoryRepository;
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
@RequestMapping("/category")
public class CategoryController {

    private final ModelMapper modelMapper;
    private CategoryRepository repository;

    @PostMapping(path = "/new")
    public ResponseEntity<Category> create(@RequestBody Object payload) {
        Category newCategory = modelMapper.map(payload, Category.class);
        Category response = repository.save(newCategory);
        return ResponseEntity.created(URI.create("/category/"+response.getId())).body(response);
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Category>> getAll() {
        System.out.println("testeGetAllCategory");
        List<Category> response = repository.findAll();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Category> getById(@PathVariable Integer id) {
        try {
            Category response = repository.findById(id).get();
            return ResponseEntity.ok().body(response);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Category> deleteById(@PathVariable Integer id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Category> updateById(@PathVariable Integer id, @RequestBody Object payload) {
        if (repository.existsById(id)) {
            Category newItem = modelMapper.map(payload, Category.class);
            newItem.setId(id);
            repository.save(newItem);
            return ResponseEntity.ok().body(newItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
