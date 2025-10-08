package com.inv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Value("${topic.inventory}")
	private String topicName;
	
	@PostMapping
	public String createOrder(@RequestBody String order) {
		kafkaTemplate.send(topicName, order);
		System.out.println("order details "+order);
		return "Order placed successfully";
	}
}
