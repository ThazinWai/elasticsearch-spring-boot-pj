package com.example.elasticsearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    ProductElasticRepo productElasticRepo;

    @Autowired
    ProductRepo productRepo;

    @Cacheable(value = "allProductES", key = "'products'")
    public List<Product> getAllProductsFromElasticSearch(String query) {

        logger.info("Fetching all products from Elasticsearch with query: {}", query);
        List<Product> result = productElasticRepo.findByNameOrDescription(query, query);
        logger.info("Query result: {}", result);
        return result;
    }

    @CacheEvict(value = {"allProduct", "allProductES"}, key = "'products'")
    public Product saveProduct(Product product){
        logger.info("Saving product: {} to database", product.getName());
        Product savedProduct = productRepo.save(product);
        //save product to elastic
        productElasticRepo.save(savedProduct);
        logger.info("Product saved successfully with ID: {}", savedProduct.getId());
        return savedProduct;
    }
}
