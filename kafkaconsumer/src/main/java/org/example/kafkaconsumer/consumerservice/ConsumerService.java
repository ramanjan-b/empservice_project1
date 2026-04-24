package com.springproject.project1.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "employee-topic", groupId = "test-group")
    public void consume(String message) {
        System.out.println("Received: " + message);
    }
}