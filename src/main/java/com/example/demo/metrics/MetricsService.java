package com.example.demo.metrics;

import com.example.demo.facade.ProductFacade;
import com.example.demo.service.ProductCounterService;
import com.example.demo.service.ProductService;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@Slf4j
public class MetricsService {

    public Supplier<Number> fetchProductCount(){
        return ProductCounterService::getProductCountSize;
    }
    public MetricsService(MeterRegistry registry) {
        log.info("Registering product countMetric into the Prometheus.");
        Gauge.builder("product_counter", fetchProductCount())
                .strongReference(true)
                .tag("product", "counter")
                .register(registry);
        log.info("CounterMetric is already registered in the Prometheus.");
    }

}
