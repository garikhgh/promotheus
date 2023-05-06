package com.example.demo.metrics;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class MetricServiceCounter {

    private final Counter count;

    public MetricServiceCounter(MeterRegistry registry) {
        this.count = Counter.builder("myCounter")
                .tag("product", "counter")
                .register(registry);
    }

    public void processRequest() {
        this.count.increment();

    }
}
