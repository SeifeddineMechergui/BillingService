package com.dev.BillingService.service;

import com.dev.BillingService.entity.customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "http://localhost:3000/")
public interface CustomerServiceClient {
    @GetMapping("/customers/{id}?projection=fullProjection")
    customer findCustomerById(@PathVariable("id") Long id);
}