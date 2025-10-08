package com.encora;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	
	//Consumer1
	@KafkaListener(topics="my-topic", groupId = "my-group")
	public void listen(String msg) {
		System.out.println("Message received 1: "+ msg);
	}
	
	//Consumer2
	@KafkaListener(topics="my-topic", groupId = "my-group2")
	public void listen2(String msg) {
		System.out.println("Message received 2: "+ msg);
	}
		
	//Consumer3
	@KafkaListener(topics="my-topic", groupId = "my-group")
	public void listen3(String msg) {
		System.out.println("Message received 3: "+ msg);
	}
}
