package com.okta.blog.sqlinjection;

import com.okta.blog.sqlinjection.domain.Employee;
import com.okta.blog.sqlinjection.domain.Role;
import com.okta.blog.sqlinjection.repository.jpa.EmployeeRepositoryJpaSafe;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;

@Configuration
@Slf4j
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepositoryJpaSafe repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo", "secret", Role.MANAGER)));
            log.info("Preloading " + repository.save(new Employee("Frodo", "secret2", Role.STAFF)));
            log.info("Preloading " + repository.save(new Employee("Bilbo77", "secret77", Role.MANAGER)));
        };
    }
}