package com.rr.kafka_producer.controller;


import com.rr.kafka_producer.model.OrderEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderController(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<String> publicOrder(@RequestBody OrderEvent event) {
        kafkaTemplate.send("orders", event.orderId(), event);
        return ResponseEntity.ok("Order published");
    }
}
