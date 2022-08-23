package com.example.employeeservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

    @Bean
    public OpenAPI openApiConfig(){
        return new OpenAPI().info(apiInfo());
    }

    public Info apiInfo(){
        Info info = new Info();
        info.
                title("Employee API")
                .description("Employee API to manage employees documented using Swagger \n\n Created by Yuri March")
                .version("v1.0.0");
        return info;
    }
}