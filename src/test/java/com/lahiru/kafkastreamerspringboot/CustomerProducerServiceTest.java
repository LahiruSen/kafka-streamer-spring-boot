package com.lahiru.kafkastreamerspringboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.*;

class CustomerProducerServiceTest {

    @InjectMocks
    private CustomerProducerService customerProducerService;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendMessageToEvenTopic() {
        // Given
        String topic = "CustomerEVEN";
        String message = "Test message";

        // When
        customerProducerService.sendMessage(topic, message);

        // Then
        verify(kafkaTemplate, times(1)).send(topic, message);
    }

    @Test
    void testSendMessageToOddTopic() {
        // Given
        String topic = "CustomerODD";
        String message = "Test message";

        // When
        customerProducerService.sendMessage(topic, message);

        // Then
        verify(kafkaTemplate, times(1)).send(topic, message);
    }
}
