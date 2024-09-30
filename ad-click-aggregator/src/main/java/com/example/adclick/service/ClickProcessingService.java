package com.example.adclick.service;

import com.example.adclick.model.AdClickEvent;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class ClickProcessingService {

    @CircuitBreaker(name = "externalService", fallbackMethod = "processClickFallback")
    public void processClick(AdClickEvent adClickEvent) {
        // Simulate processing the click event
        // For example, call an external analytics service
        callExternalService(adClickEvent);
    }

    private void callExternalService(AdClickEvent adClickEvent) {
        // Simulate external service call
        // You can replace this with actual logic
        if (Math.random() < 0.5) {
            throw new RuntimeException("External service failed");
        }
        // Simulate successful processing
        System.out.println("Processed click for Ad ID: " + adClickEvent.getAdId());
    }

    // Fallback method for circuit breaker
    public void processClickFallback(AdClickEvent adClickEvent, Throwable throwable) {
        // Handle fallback logic, e.g., log the failure and continue
        System.err.println("Fallback: Failed to process click for Ad ID: " + adClickEvent.getAdId());
        // You might store the event for later processing or notify an admin
    }
}
