package com.example.dream;

import com.example.dream.order.gauge.StockConfigV1;
import com.example.dream.order.v4.OrderConfigV4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({OrderConfigV4.class, StockConfigV1.class})
@SpringBootApplication(scanBasePackages = "com.example.dream.order.controller")
public class DreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamApplication.class, args);
	}

}
