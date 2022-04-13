package com.example.praticaintegradora1.service;

import com.example.praticaintegradora1.domain.Article;
import com.example.praticaintegradora1.elasticrepositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

        @Autowired
        private ArticleRepository repository;

        public Article addNew(Article payload) {
            return repository.save(payload);
        }

    public Iterable<Article> getAll() {
        return repository.findAll();
    }
}
