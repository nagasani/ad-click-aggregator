package com.example.adclick.controller;

import com.example.adclick.model.AdClickEvent;
import com.example.adclick.service.ClickProcessingService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ads")
public class AdClickController {

    @Autowired
    private ClickProcessingService clickProcessingService;

    @RateLimiter(name = "adClickRateLimiter", fallbackMethod = "rateLimiterFallback")
    @PostMapping("/click")
    public ResponseEntity<String> receiveAdClick(@RequestBody AdClickEvent adClickEvent) {
        clickProcessingService.processClick(adClickEvent);
        return ResponseEntity.ok("Ad click received");
    }

    // Fallback method when rate limit is exceeded
    public ResponseEntity<String> rateLimiterFallback(AdClickEvent adClickEvent, RequestNotPermitted ex) {
        return ResponseEntity.status(429).body("Too Many Requests - Try again later");
    }
}
