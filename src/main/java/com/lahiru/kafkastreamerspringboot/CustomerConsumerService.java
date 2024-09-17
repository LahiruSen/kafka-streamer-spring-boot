package com.lahiru.kafkastreamerspringboot;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerConsumerService {

    @KafkaListener(topics = "input-topic", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }


}
