package com.dev.BillingService.repositories;

import com.dev.BillingService.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
