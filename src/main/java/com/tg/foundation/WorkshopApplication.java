package com.tg.foundation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tg.foundation.model.User;
import com.tg.foundation.repository.UserRepository;

@SpringBootApplication
public class WorkshopApplication {
    public static void main(String[] args) {
        SpringApplication.run(WorkshopApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository repo) {
        return args -> {
            User user = new User();
            user.setName("Engineer Alex");
            user.setEmail("alex@datalake.com");
            repo.save(user);
        };
    }
}