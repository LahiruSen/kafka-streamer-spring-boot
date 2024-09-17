# Spring Boot Kafka Consumer/Producer Application

This project demonstrates a Spring Boot application that consumes messages from a Kafka topic, processes the messages based on custom business logic, and publishes the results to two different Kafka topics: `CustomerEVEN` and `CustomerODD`.

## Features

- **Kafka Consumer**: Listens to messages from a specified Kafka topic (`input-topic`).
- **Kafka Producer**: Publishes processed messages to different Kafka topics based on the business logic.
- **Business Logic**: Determines whether the customer's age is even or odd, and routes the message accordingly.

## Requirements

- **Java 17+**
- **Apache Kafka** (a local Kafka instance or a cloud provider like Confluent)
- **Spring Boot**
- **Maven** 

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/kafka-spring-boot-app.git
cd kafka-spring-boot-app
```

### 2. Configure Kafka

Update the Kafka properties in src/main/resources/application.properties as per your configuration from Kafka instance.

### 3. Build and Run the Application

```bash
mvn clean install
mvn spring-boot:run

```
### 4. Build and Run the Application

You can produce messages to the input-topic Kafka topic using the Kafka command-line tool or any Kafka producer client. 
The message should be in the following JSON format:

{
"first_name": "John",
"last_name": "Doe",
"age": 28
}

**Alternatively you can use the REST endpoint exposed in CustomerController class.**

### Contact
For any questions or support, feel free to contact the repository owner at lahirurc1st@gmail.com.
