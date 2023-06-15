//package com.example.demo;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.example.demo.Dao.CustomerRepository;
//import com.example.demo.Model.Customer;
//import com.example.demo.Model.CustomerCategory;
//import com.example.demo.ServiceImpl.CustomerServiceImpl;
//
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//public class CustomerServiceImplTest {
//
//	@InjectMocks
//	private	CustomerServiceImpl customerServiceimpl;
//		
//	  @Mock
//	  private CustomerRepository customerRepo;
//			
//	  @Test
//	  public void testCreateCustomer() {
//		  String name="Demo";
//		  Customer customer1 = new Customer(name, 0, CustomerCategory.REGULER);
//	      Mockito.when(customerRepo.save(Mockito.any())).thenReturn(customer1);
//	      Customer createdCustomer = customerServiceimpl.createCustomer(name);
//	      assertNotNull(createdCustomer);
//	      assertEquals(name, createdCustomer.getName());
//	      assertEquals(CustomerCategory.REGULAR, createdCustomer.getType());
//	      Mockito.verify(customerRepo, Mockito.times(1)).save(Mockito.any());
//	  }
//			@Test
//			public void testGetAllCustomers() {
//		        Customer customer2 = new Customer("B", 10, CustomerCategory.GOLD);
//		        Customer customer3 = new Customer("C", 20, CustomerCategory.PLATINUM);
//		        List<Customer> customers = Arrays.asList(customer2, customer3);
//		        Mockito.when(customerRepo.findAll()).thenReturn(customers);	
//		        List<Customer> result = customerServiceimpl.getAllCustomers();
//		        assertEquals(customers.size(), result.size());
//		        assertEquals(customers.get(0).getName(), result.get(0).getName());
//		        assertEquals(customers.get(1).getType(), result.get(1).getType());
//		        Mockito.verify(customerRepo, Mockito.times(1)).findAll();
//		    }
//			@Test
//		    public void testPromoteCustomers() {
//		    
//		        Customer regularCustomer = new Customer("B", 10, CustomerCategory.REGULAR);
//		        Customer goldCustomer = new Customer("C", 20, CustomerCategory.GOLD);
//		        List<Customer> customers = Arrays.asList(regularCustomer, goldCustomer);
//		        Mockito.when(customerRepo.findAll()).thenReturn(customers);
//
//		     customerServiceimpl.promoteCustomers();
//
//		     assertEquals(CustomerCategory.GOLD, regularCustomer.getType());
//		        assertEquals(CustomerCategory.GOLD, goldCustomer.getType());
//		        Mockito.verify(customerRepo, Mockito.times(1)).saveAll(customers);
//		    }
//		
//			}
//		
//		
//}
