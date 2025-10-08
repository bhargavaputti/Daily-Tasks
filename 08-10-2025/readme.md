# Kafka Producer-Consumer Demo with Spring Boot

This project demonstrates a simple Kafka-based messaging system using Spring Boot with separate Producer and Consumer applications.

---

## Components

### Producer Application
- Publishes messages to Kafka topic `my-topic`.
- REST endpoint: `POST /api/send?msg=your_message`
- Uses `KafkaTemplate` to send messages asynchronously.

### Consumer Application
- Listens to Kafka topic `my-topic` with multiple consumers.
- Consumers are in two groups:
  - `my-group`: Contains two consumers that share message load.
  - `my-group2`: Contains one consumer that receives all messages independently.

---

## Kafka Topic & Consumer Groups

| Topic     | Consumer Group | Description                         |
|-----------|----------------|-----------------------------------|
| my-topic  | my-group       | Two consumers load balance messages|
| my-topic  | my-group2      | Single consumer receives all messages|

---

## Setup & Run

1. Start Kafka broker on `localhost:9092`.
2. Run Producer and Consumer Spring Boot apps.
3. Send messages using:
curl -X POST "http://localhost:8080/api/send?msg=HelloKafka
4. Consumers will receive and process messages according to their groups.

---

## Key Points

- Consumers in the same group share messages (each message processed once per group).
- Different groups receive full copies of messages.
- Scalable and decoupled message processing using Kafka.

---

## Technologies

- Java 17
- Spring Boot
- Spring Kafka
- Apache Kafka

---

