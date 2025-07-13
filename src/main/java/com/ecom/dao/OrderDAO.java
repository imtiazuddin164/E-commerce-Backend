package com.ecom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.common.ICommonDAO;
import com.ecom.enums.OrderStatus;
import com.ecom.model.Order;
import com.ecom.model.Product;

@Repository(value = "orderDAO")
@Transactional
public class OrderDAO implements ICommonDAO<Order, Long> {
	
	
	
	@Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public Order save(Order order) {
//        getSession().save(order);
    	Order merged = (Order)getSession().merge(order);
        getSession().flush();
        return merged;
    }

    @Override
    public List<Order> getAll() {
        String hql = "from orders";
        return getSession().createQuery(hql, Order.class).getResultList();
    }

    @Override
    public Order getById(long id) {
        return getSession().get(Order.class, id);
    }

    @Override
    public Order update(Order order) {
        getSession().update(order);
        getSession().flush();
        return order;
    }

    @Override
    public Order delete(Order order) {
        getSession().delete(order);
        getSession().flush();
        return order;
    }
    
 // Add these methods inside your OrderDAO class

    public boolean isApproved(Long orderId) {
        Order order = getById(orderId);
        return order != null && order.isApproved();
    }

    public String approveOrder(Long orderId) {
        Order order = getById(orderId);
        if (order != null) {
            order.setApproved(true);
            order.setStatus(OrderStatus.APPROVED);
            update(order); // merge and flush handled inside update()
            return "Order Approved!";
        } else {
            return "Order not found!";
        }
    }
    
    public String rejectOrder(Long orderId) {
        Order order = getById(orderId);
        if (order != null) {
            order.setApproved(false);
            order.setStatus(OrderStatus.REJECTED);  // enum use করছো
            update(order); // DAO method
            return "Order Rejected!";
        } else {
            return "Order not found!";
        }
    }



	
//	@Autowired
//	private EntityManager entityManager;
//
//	private Session getSession() {
//		return entityManager.unwrap(Session.class);
//	}
//
//	public Order save(Order o) {
//		getSession().save(o);
//		getSession().flush();
//		return o;
//	}
//
//	public List<Order> getAll() {
//		String sql = "from orders";
//		List<Order> order = getSession().createQuery(sql).list();
//		return order;
//	}
//
//	public Order getById(long id) {
//		String sql = "from orders where id = '" + id + "'";
//		List<Order> ecomList = getSession().createQuery(sql).list();
//		return ecomList.get(0);
//
//	}
//
//	public Order update(Order o) {
//		String hql = "update orders set order_code = '" + o.getOrderCode() + "', customer_name = '" + o.getCustomerName()
//				+ "', phone = '" + o.getPhone() + "', address = '" + o.getAddress() + "'"
//				+ ", total_amount = '" + o.getTotalAmount() + "',order_date = '" + o.getOrderDate()
//				+ "', status = '" + o.getStatus() + "' where id = '" + o.getId() + "'";
//		Query q = getSession().createQuery(hql);
//		q.executeUpdate();
//		getSession().flush();
//		return o;
//	}
//
//	public Order delete(Order o) {
//		String sql = "delete orders where id = '" + o.getId() + "'";
//		int delete = getSession().createQuery(sql).executeUpdate();
//		return o;
//	}
//
//
//	
}
