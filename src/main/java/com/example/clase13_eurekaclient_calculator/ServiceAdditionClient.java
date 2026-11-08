package com.example.clase13_eurekaclient_calculator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-addition")
public interface ServiceAdditionClient {

    @GetMapping("/addition/{item_a}/{item_b}")
    String addition(@PathVariable("item_a") int a, @PathVariable("item_b") int b);

}
