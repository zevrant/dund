package com.dnd.resources.dundresourceorganizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories
@SpringBootApplication
@EnableTransactionManagement
public class DundResourceOrganizerApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(DundResourceOrganizerApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        return new ReloadableResourceBundleMessageSource();
    }


}
