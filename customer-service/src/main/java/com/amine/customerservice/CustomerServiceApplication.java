package com.amine.customerservice;

import com.amine.customerservice.config.GlobalConfig;
import com.amine.customerservice.entities.Customer;
import com.amine.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            List<Customer> customerList = List.of(
                    Customer.builder()
                            .firstName("Amine")
                            .lastName("MIFTAH")
                            .email("amine@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("Hatim")
                            .lastName("MIFTAH")
                            .email("hatim@gmail.com")
                            .build()
            );
            customerRepository.saveAll(customerList);
        };
    }
}
