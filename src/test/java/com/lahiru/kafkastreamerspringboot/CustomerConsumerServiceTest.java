package com.lahiru.kafkastreamerspringboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class CustomerConsumerServiceTest {

    @InjectMocks
    private CustomerConsumerService customerConsumerService;

    @Mock
    private CustomerProducerService customerProducerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsumeEvenAgeMessage() {
        // Given
        String message = "{\"first_name\": \"John\", \"last_name\": \"Doe\", \"age\": 28}";

        // When
        customerConsumerService.consume(message);

        // Then
        verify(customerProducerService, times(1)).sendMessage("CustomerEVEN", message);
    }

    @Test
    void testConsumeOddAgeMessage() {
        // Given
        String message = "{\"first_name\": \"Jane\", \"last_name\": \"Doe\", \"age\": 27}";

        // When
        customerConsumerService.consume(message);

        // Then
        verify(customerProducerService, times(1)).sendMessage("CustomerODD", message);
    }

    @Test
    void testExtractAgeFromMessage() {
        // Given
        String message = "{\"first_name\": \"John\", \"last_name\": \"Doe\", \"age\": 35}";

        // When
        int age = customerConsumerService.extractAgeFromMessage(message);

        // Then
        assert(age == 35);
    }
}
