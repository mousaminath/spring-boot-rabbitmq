package com.example.demo.consumer;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.demo.Person;

@Component
public class User {
	@RabbitListener(queues = "demo_queue")
	public void consumeMessageFromQueue(Person person) {
		System.out.println("Message Received !! " + person);
	}
}
