package io.micro_spring_boot.building_blocks.resilience;

import io.github.resilience4j.bulkhead.BulkheadConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Resilience4jConfiguration {
    @Bean
    public CircuitBreakerConfig circuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
                .slidingWindowSize(100)
                .permittedNumberOfCallsInHalfOpenState(10)
                .waitDurationInOpenState(java.time.Duration.ofMillis(10000))
                .failureRateThreshold(60)
                .build();
    }


    @Bean
    public RetryConfig retryConfig() {
        return RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(java.time.Duration.ofMillis(1000))
                .retryExceptions(RuntimeException.class)
                .build();
    }

    @Bean
    public RateLimiterConfig rateLimiterConfig() {
        return RateLimiterConfig.custom()
                .limitForPeriod(100)
                .limitRefreshPeriod(java.time.Duration.ofMillis(10000))
                .timeoutDuration(java.time.Duration.ofMillis(1000))
                .build();
    }

    @Bean
    public TimeLimiterConfig timeLimiterConfig() {
        return TimeLimiterConfig.custom()
                .timeoutDuration(java.time.Duration.ofMillis(1000))
                .build();
    }

    @Bean
    public BulkheadConfig bulkheadConfiguration() {
        return BulkheadConfig.custom()
                .maxConcurrentCalls(100)
                .maxWaitDuration(java.time.Duration.ofMillis(1000))
                .build();
    }
}