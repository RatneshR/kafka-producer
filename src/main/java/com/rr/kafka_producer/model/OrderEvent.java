package com.rr.kafka_producer.model;

import java.time.Instant;

public record OrderEvent(
    String orderId,
    String productId,
    int quantity,
    double price,
    Instant timestamp) {
}
