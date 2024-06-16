package com.example.dream.order.v1;

import com.example.dream.order.OrderService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequiredArgsConstructor
public class OrderServiceV1 implements OrderService {

    private final MeterRegistry registry;

    private AtomicInteger stock = new AtomicInteger(100);

    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();

        Counter orderCounter = Counter.builder("my.order")
            .tag("class", this.getClass().getName())
            .tag("method", "order")
            .description("order")
            .register(registry);
        orderCounter.increment();
    }

    @Override
    public void cancel() {
        log.info("주문 취소");
        stock.incrementAndGet();

        Counter cancelCounter = Counter.builder("my.order")
            .tag("class", this.getClass().getName())
            .tag("method", "cancel")
            .description("cancel")
            .register(registry);
        cancelCounter.increment();
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
