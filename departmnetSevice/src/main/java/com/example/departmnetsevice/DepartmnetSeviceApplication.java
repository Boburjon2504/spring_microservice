package com.example.departmnetsevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DepartmnetSeviceApplication {


    public static void main(String[] args) {
        SpringApplication.run(DepartmnetSeviceApplication.class, args);
    }

}
