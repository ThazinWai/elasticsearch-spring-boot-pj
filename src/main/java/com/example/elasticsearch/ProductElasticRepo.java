package com.example.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductElasticRepo extends ElasticsearchRepository<Product, Long> {
    List<Product> findByNameOrDescription(String name, String description);
}
