package com.example.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ElasticsearchTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchTestApplication.class, args);
	}

}
