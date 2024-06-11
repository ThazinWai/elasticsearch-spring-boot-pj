package com.example.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    // get all from Elasticsearch
    @GetMapping("/es/{query}")
    public List<Product> getAllProductsFromElasticSearch(@PathVariable String query) {
        return productService.getAllProductsFromElasticSearch(query);
    }
}
