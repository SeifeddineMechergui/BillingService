package com.dev.BillingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class customer {
    private Long id;
    private String name;
    private String email;
}
