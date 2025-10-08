package com.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

	private List<String> messages = new ArrayList<>();
	
	@KafkaListener(topics = "order-topic", groupId = "OrderGroup")
	public void consume(String msg) {
		System.out.println("Received msg:" + msg);
		messages.add(msg);
	}
	
	public List<String> getMessages(){
		return this.messages;
	}
}
