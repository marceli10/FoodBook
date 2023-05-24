package com.example.foodbook;

import com.example.foodbook.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
@EnableNeo4jRepositories
public class FoodBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodBookApplication.class, args);
    }

}
