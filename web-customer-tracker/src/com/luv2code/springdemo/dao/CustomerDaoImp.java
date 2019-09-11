package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
@Component
public class CustomerDaoImp implements CustomrtDAO {

	
	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory ;
	
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery =
				currentSession.createQuery("from Customer order by lastName"
						,Customer.class);
		
		// Execute a query and get result
		List<Customer> customers = theQuery.getResultList();
		
		//return the result
		
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		//get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class,theId);
		
		return theCustomer;
	}

	@Override
	public Object deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId) ;
		query.executeUpdate();
		return null;
	}

}
