package com.lahiru.kafkastreamerspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerProducerService producerService;

    @PostMapping("/send/{topic}")
    public void sendMessage(@PathVariable String topic, @RequestBody String message) {
        producerService.sendMessage(topic, message);
    }
}