package com.example.praticaintegradora1.elasticrepositories;

import com.example.praticaintegradora1.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepository extends ElasticsearchRepository<Article, Integer> {
}
