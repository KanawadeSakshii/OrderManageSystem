package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Service.CustomerService;
import com.example.demo.Service.OrderService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService; 
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Customer>CreatedCustomer(@RequestBody Customer customer){
		Customer customer1=customerService.createCustomer(customer);
		return ResponseEntity.ok().body(customer1);
	}
	
	@PostMapping("/{customerId}/orders")
	public Order promoteCustomer(@PathVariable Long customerId,  @RequestBody Order order) {
		 customerService.promoteCustomer(customerId);
		 return orderService.createOrder(order);
				
	}
	@GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }
}
