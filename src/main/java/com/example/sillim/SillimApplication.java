package com.example.sillim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.example.sillim.repository")
public class SillimApplication {

	public static void main(String[] args) {
		SpringApplication.run(SillimApplication.class, args);
	}

}
