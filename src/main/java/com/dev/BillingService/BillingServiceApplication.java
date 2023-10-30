package com.dev.BillingService;

import com.dev.BillingService.entity.Bill;
import com.dev.BillingService.entity.ProductItem;
import com.dev.BillingService.entity.customer;
import com.dev.BillingService.repositories.BillRepository;
import com.dev.BillingService.repositories.ProductItemRepository;
import com.dev.BillingService.service.CustomerServiceClient;
import com.dev.BillingService.service.InventoryServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication{
	public static void main(String[] args) {SpringApplication.run(BillingServiceApplication.class, args);
		}

		@Bean
		CommandLineRunner start(
				BillRepository billRepository,
				ProductItemRepository productItemRepository,
				InventoryServiceClient inventoryServiceClient,
				CustomerServiceClient customerServiceClient){
		return args->{
				Bill bill=new Bill();
			bill.setBillingDate(new Date() );
			customer Customer=customerServiceClient.findCustomerById(1L);
			bill.setCustomerId(Customer.getId());
			billRepository.save(bill);
			inventoryServiceClient.findAll().getContent().forEach(p->{
					productItemRepository.save(new ProductItem(null,null,p.getId(),p.getPrice(),(int)(1+Math.random()*1000),bill));
				});
			};
	}}
