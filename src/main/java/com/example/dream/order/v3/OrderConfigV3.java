package com.example.dream.order.v3;

import com.example.dream.order.OrderService;
import com.example.dream.order.v1.OrderServiceV1;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfigV3 {

    @Bean
    OrderService orderService(MeterRegistry registry) {
        return new OrderServiceV3(registry);
    }
}
