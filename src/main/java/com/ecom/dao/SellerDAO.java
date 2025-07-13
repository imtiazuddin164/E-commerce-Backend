package com.ecom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.common.ICommonDAO;
import com.ecom.model.Seller;

@Repository(value = "sellerDAO")
@Transactional

public class SellerDAO implements ICommonDAO<Seller, Long> {

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public Seller save(Seller s) {
		getSession().save(s);
		getSession().flush();
		return s;
	}

	public List<Seller> getAll() {
		String sql = "from seller";
		List<Seller> seller = getSession().createQuery(sql).list();
		return seller;
	}

	public Seller getById(long id) {
		String sql = "from seller where id = '" + id + "'";
		List<Seller> ecomList = getSession().createQuery(sql).list();
		return ecomList.get(0);

	}

	public Seller update(Seller s) {
//		String hql = "update seller set seller_name = '" + s.getName() + "', email = '" + s.getEmail()
//				+ "', phone = '" + s.getPassword() + "', user_name = '" + s.getUserName() + "'"
//				+ ", password = '" + s.getPassword() + "',confirm_password = '" + s.getConfirmPassword() + "', shop_name = '" + s.getShopName() + "',business_type = '" + s.getBusinessType() + "',status = '" + s.getStatus() + "',created_at = '" + s.getCreatedAt() + "'  where id = '"
//				+ s.getId() + "'";
		
		String hql = "update seller set status = '"+s.getStatus()+"' where id = '"
				+ s.getId() + "'";
		
		Query q = getSession().createQuery(hql);
		q.executeUpdate();
		getSession().flush();
		return s;
	}

	public Seller delete(Seller s) {
		String sql = "delete products where id = '" + s.getId() + "'";
		int delete = getSession().createQuery(sql).executeUpdate();
		return s;
	}

}
