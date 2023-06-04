package com.example.demo.Model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
  
	private double discount;

   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "customer_id")
  private Customer customer;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

public Order(Integer id, double discount, Customer customer) {
		super();
		this.id = id;
		this.discount = discount;
		this.customer = customer;
	}

//	public Order(int id, Integer customerId, float discount) {
//		super();
//		this.id = id;
//		this.customerId = customerId;
//		this.discount = discount;
//	}
	
	public Customer getCustomerid() {
		return customer;
}
	public void setCustomerid(Customer customer) {
		this.customer = customer;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount2) {
		this.discount = discount2;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", discount=" + discount + ", customerid=" + customer + "]";
	}
	
	
}
