package com.ecommerce.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.Ecom;


@Repository(value="ecomDAO")
@Transactional
public class EcomDAO {

	@Autowired
	private EntityManager entityManager;
	
	//List<User> users = entityManager.unwrap(Session.class).createQuery("from user").list();
	
	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	
//	public List<User> getAllUsers() {
//		List<User> users = getSession().createQuery("from user").list();
//		return users;
//	}
	
	
	String sql= "from ecom";
	public List<Ecom> getAllUsers() {
		List<Ecom> imt = getSession().createQuery(sql).list();
		return imt;
	}
	
	
}