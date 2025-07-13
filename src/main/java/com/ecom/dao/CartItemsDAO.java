package com.ecom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.common.ICommonDAO;
import com.ecom.model.CartItems;


@Repository(value = "cartItemsDAO")
@Transactional

public class CartItemsDAO implements ICommonDAO<CartItems, Long>{

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public CartItems save(CartItems c) {
		getSession().save(c);
		getSession().flush();
		return c;
	}

	public List<CartItems> getAll() {
		String sql = "from cartItems";
		List<CartItems> cartItems = getSession().createQuery(sql).list();
		return cartItems;
	}

	public CartItems getById(long id) {
		String sql = "from cartItems where id = '" + id + "'";
		List<CartItems> ecomList = getSession().createQuery(sql).list();
		return ecomList.get(0);

	}

	public CartItems update(CartItems c) {
		String hql = "update cartItems set cartItems_code = '" + c.getCartItemsCode() + "', user_id = '" + c.getUserId()
				+ "', product_id = '" + c.getProductId() + "', product_code = '" + c.getProductCode() + "'"
				+ ", product_name = '" + c.getProductName() + "',quantity = '" + c.getQuantity()
				+ "', price = '" + c.getPrice() + "', total_price = '" + c.getTotalPrice() + "'  where id = '"
				+ c.getId() + "'";
		Query q = getSession().createQuery(hql);
		q.executeUpdate();
		getSession().flush();
		return c;
	}

	public CartItems delete(CartItems c) {
		String sql = "delete cartItems where id = '" + c.getId() + "'";
		int delete = getSession().createQuery(sql).executeUpdate();
		return c;
	}

	
}
