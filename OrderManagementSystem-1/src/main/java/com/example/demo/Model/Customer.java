package com.example.demo.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customer_id;
	private String name;
	private int orderCount;
	
	@OneToMany(mappedBy="customer")
	private List<Order> order;
	
	@Enumerated(EnumType.STRING)
	private CustomerCategory customerType;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customer_id, String name, int orderCount, CustomerCategory customerType) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.orderCount = orderCount;
		this.customerType = customerType;
	}

	
	

	public Customer(String name, int orderCount, CustomerCategory customerType) {
		super();
		this.name = name;
		this.orderCount = orderCount;
		this.customerType = customerType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public CustomerCategory getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerCategory customerType) {
		this.customerType = customerType;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", name=" + name + ", orderCount=" + orderCount + ", order="
				+ order + ", customerType=" + customerType + "]";
	}

//	public List<Order> getOrder() {
//		return order;
//	}
//
//	public void setOrder(List<Order> order) {
//		this.order = order;
//	}
	

}
