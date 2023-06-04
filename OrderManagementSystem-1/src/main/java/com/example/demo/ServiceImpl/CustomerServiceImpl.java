package com.example.demo.ServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.CustomerRepository;
import com.example.demo.Model.Customer;
import com.example.demo.Model.CustomerCategory;
import com.example.demo.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;
	
 // Implement methods for creating customers and updating their order count
	
	@Override
	public Customer createCustomer(Customer customer) {
		customer.setCustomerType(CustomerCategory.REGULER);
		logger.info("Customer Service Implementation : createCustomer() method");
		return customerRepository.save(customer);
	}
	
	public Customer getCustomerById(Long customerId) {
		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public Customer promoteCustomer(Long customerId) {
	Customer customer=	customerRepository.findById(customerId)
			            .orElseThrow(()-> new IllegalArgumentException("Invalid Customer Id" + customerId ));
	customer.setOrderCount(customer.getOrderCount()+1);	
	
	if(customer.getOrderCount()==0 && customer.getOrderCount()<=10 ) {
		customer.setCustomerType(CustomerCategory.REGULER);
	}else if(customer.getOrderCount()==10) {
		customer.setCustomerType(CustomerCategory.GOLD);
	}else if(customer.getOrderCount()==20) {
		customer.setCustomerType(CustomerCategory.PLATINUM);
	}
	return customerRepository.save(customer);
	 
	}
}

