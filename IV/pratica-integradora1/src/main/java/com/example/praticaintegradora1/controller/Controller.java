package com.example.praticaintegradora1.controller;

import com.example.praticaintegradora1.domain.Article;
import com.example.praticaintegradora1.domain.Author;
import com.example.praticaintegradora1.dto.InpuutDTO;
import com.example.praticaintegradora1.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @Autowired
    ArticleService service;

    @PostMapping(path = "/new")
    public ResponseEntity create(@RequestBody InpuutDTO payload) {
        System.out.println(payload);
        List<Author> authors = new ArrayList<>();
        payload.getAuthorList().stream().forEach(a -> {
            authors.add(Author.builder()
                    .name(a.getName())
                    .build());
        });
        Article newArticle = Article.builder()
                .title(payload.getTitle())
                .authorlist(authors)
                .build();
        Article response = service.addNew(newArticle);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity get(){
        List<Article> response = new ArrayList<>();
        service.getAll().forEach(a -> response.add(Article.builder().title(a.getTitle()).authorlist(a.getAuthorlist()).id(a.getId()).build()));
        return ResponseEntity.ok(response);
    }
}
