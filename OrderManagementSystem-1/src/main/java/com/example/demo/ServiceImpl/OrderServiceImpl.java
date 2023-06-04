package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.CustomerRepository;
import com.example.demo.Dao.OrderRepository;
import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public Order createOrder(Order order) {
            double discount=0;
		Customer customer=customerRepository.findById(order.getCustomerid()).orElseThrow(()-> new IllegalArgumentException("Invalid Customer Id" + order.getCustomerid()));
		if("GOLD".equals(customer.getCustomerType())) {
			discount=0.1;
		}else if ("PLATINUM".equals(customer.getCustomerType())) {
			discount=0.2;
		}
        order.setDiscount(discount);
        orderRepository.save(order);
        return order;
	}

}
