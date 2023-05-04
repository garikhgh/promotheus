package com.example.demo.metrics;


import io.prometheus.client.Counter;

public class MetricServiceCounter {
    public static final Counter counter = Counter.build()
            .name("Counter")
            .help("Total Products")
            .register();

    private MetricServiceCounter() {
    }

    void processRequest() {
        counter.inc();
    }
}
