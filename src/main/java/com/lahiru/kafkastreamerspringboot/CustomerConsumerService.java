package com.lahiru.kafkastreamerspringboot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerConsumerService {

    @Autowired
    private CustomerProducerService customerProducerService;

    @KafkaListener(topics = "input-topic", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);

        int age = extractAgeFromMessage(message);

        // Determine if age is even or odd and publish to the appropriate topic
        if (age % 2 == 0) {
            customerProducerService.sendMessage("CustomerEVEN", message);
        } else {
            customerProducerService.sendMessage("CustomerODD", message);
        }
    }

    public int extractAgeFromMessage(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(message);
            return jsonNode.get("age").asInt();
        } catch (Exception e) {
            throw new RuntimeException("Error parsing message: " + message, e);
        }
    }


}
