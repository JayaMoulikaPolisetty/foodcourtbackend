package com.niit.foodcourtbackend;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.foodcourtbackend.configuration.HibernateConfiguration;
import com.niit.foodcourtbackend.dao.CustomerDao;

public class CustomerTest {

	   
	AnnotationConfigApplicationContext context;
	CustomerDao customerDao;
	Customer customer;
	
	
	
	@Before
	public void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		customerDao=(CustomerDao)context.getBean("customerDao");
		customer=new Customer();
	
	}
	
	/* @Test
	public void test() {
		
		customer.setFirstName("Sai Chand");
		customer.setLastName("Potukuchi");
		customer.setMobile("9056731351");
		customer.setUsername("Chandu");;
		customer.setPassword("chandumouli");
		customer.setComfirmPassword("chandumouli");
		
		Assert.assertEquals("Customer added successfully", true, customerDao.addCustomer(customer) );
	}
	*/
	/*@Test
	public void test() {
		
		customer.setCustId(4);
		customerDao.deleteCustomer(customer);
	}
*/
	@Test
	public void test() {
		
		customer.setCustId(3);
		customer.setFirstName("chandu");
		customer.setLastName("Potukuchi");
		customer.setMobile("9056731351");
		customer.setUsername("Chandu");;
		customer.setPassword("chandumouli");
		customer.setComfirmPassword("chandumouli");
		customerDao.updateCustomer(customer);
	}
}

