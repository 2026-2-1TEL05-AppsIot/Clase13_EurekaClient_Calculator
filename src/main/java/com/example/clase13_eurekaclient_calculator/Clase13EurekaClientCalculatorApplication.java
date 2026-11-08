package com.example.clase13_eurekaclient_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Clase13EurekaClientCalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Clase13EurekaClientCalculatorApplication.class, args);
    }

}
