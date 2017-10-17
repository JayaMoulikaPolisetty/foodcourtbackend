package com.niit.foodcourtbackend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.foodcourtbackend.Customer;
import com.niit.foodcourtbackend.dao.*;

@Repository("customerDao")
@Transactional
public class CustomerDaoImpl implements CustomerDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCustomer(Customer customer) {
		
		try {
			
			sessionFactory.getCurrentSession().save(customer);
			return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	@Override
	public boolean deleteCustomer(Customer customer) {
		try {
			sessionFactory.getCurrentSession().remove(customer);
			return true;
			
		}
		catch(Exception e) 
		{
		return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			
			sessionFactory.getCurrentSession().update(customer);
			return true;
		}
	catch(Exception e) {
		return false;
	}
		
	}
	

}

