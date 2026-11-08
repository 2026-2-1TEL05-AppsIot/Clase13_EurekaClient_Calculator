package com.example.clase13_eurekaclient_calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
public class CalculatorController {

    @Autowired
    private ServiceAdditionClient serviceAdditionClient;

    final CircuitBreakerFactory circuitBreakerFactory;

    public  CalculatorController(CircuitBreakerFactory circuitBreakerFactory) {
        this.circuitBreakerFactory = circuitBreakerFactory;
    }


    @GetMapping("/addcalculator/")
    public String addCalculatortest()
    {
            return "Calculator : Test AddCalculator";
    }

    @GetMapping("/addcalculator/{item_a}/{item_b}")
    public String addCalculator(@PathVariable("item_a") int item_a,
                                @PathVariable("item_b") int item_b)
    {
        CircuitBreaker breaker = circuitBreakerFactory.create("addcalculator");

        return breaker.run(() -> {
            return "Calculator : " + serviceAdditionClient.addition(item_a,item_b);
        }, throwable -> {
            return "Calculator : Wait";
        });
    }


    // Clase interna para representar el JSON de entrada
    static class Operacion {
        public String a;
        public String b;
        // Necesario para que Jackson pueda instanciarlo
        public Operacion() {}
    }

    @PostMapping(value = "/addcalculator/",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String addCalculatorPost(@RequestBody Operacion op)
    {
            int item_a = Integer.valueOf(op.a);
            int item_b = Integer.valueOf(op.b);
            return "Calculator Post : " + serviceAdditionClient.addition(item_a,item_b);
    }
}
