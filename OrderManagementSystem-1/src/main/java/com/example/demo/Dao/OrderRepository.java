package com.example.demo.Dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;

import jakarta.transaction.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<Order,Serializable>{

}
