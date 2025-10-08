# RetailProject - Order and Inventory Microservices with Kafka Integration

Welcome to the **RetailProject**, a microservices-based architecture designed to handle order processing and inventory management using Spring Boot and Apache Kafka.

---

## Project Overview

This project consists of two main microservices:

1. **OrderService33** - Responsible for consuming order messages from Kafka topics and maintaining the order records.
2. **InventoryService33** - Responsible for producing (sending) order messages to Kafka topics for inventory updates.

Both microservices are designed to communicate asynchronously using Apache Kafka, enabling scalable and decoupled system architecture.

---

## Technologies Used

- **Java 17**
- **Spring Boot** (Web, Kafka)
- **Apache Kafka** (Message Broker)
- **Maven** (Build and Dependency Management)
- **REST APIs** for communication

---

## Architecture & Workflow

### InventoryService33

- Exposes a REST endpoint `/inventory` to accept order creation requests.
- Upon receiving an order, it sends the order message to a Kafka topic defined by `topic.inventory`.
- Utilizes `KafkaTemplate` to publish messages asynchronously.

### OrderService33

- Listens to Kafka topic `order-topic` for incoming order messages.
- Consumes the messages using `@KafkaListener`.
- Stores and exposes consumed messages through a REST endpoint `/orders/msgs` for retrieval.
- Demonstrates how Kafka consumers can be used for real-time processing of events.

---

## Getting Started

### Prerequisites

- Java 17+
- Apache Kafka running locally or remotely
- Maven 3.x+
- IDE or CLI to run Spring Boot applications

### Running the Services

1. **Start Kafka Broker** on your local machine or use a hosted Kafka service.
2. Clone the repository.
3. Build the services using Maven
