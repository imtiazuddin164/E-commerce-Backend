package com.ecom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.common.ICommonDAO;
import com.ecom.model.Coupon;

@Repository(value = "couponDAO")
@Transactional
public class CouponDAO implements ICommonDAO<Coupon, Long>{
	
	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public Coupon save(Coupon p) {
		getSession().save(p);
		getSession().flush();
		return p;
	}

	public List<Coupon> getAll() {
		String sql = "from coupon";
		List<Coupon> coupon = getSession().createQuery(sql).list();
		return coupon;
	}

	public Coupon getById(long id) {
		String sql = "from coupon where id = '" + id + "'";
		List<Coupon> ecomList = getSession().createQuery(sql).list();
		return ecomList.get(0);

	}

	public Coupon update(Coupon p) {
		String hql = "update coupon set Code = '" + p.getCouponCode() + "', discount_amount = '" + p.getDiscountAmount()
				+ "', type = '" + p.getType() + "', active = '" + p.getActive() + "'" + ", start_date = '" + p.getStartDate() 
				+ "',end_date = '" + p.getEndDate() + "'  where id = '" + p.getId() + "'";
		Query q = getSession().createQuery(hql);
		q.executeUpdate();
		getSession().flush();
		return p;
	}

	public Coupon delete(Coupon p) {
		String sql = "delete coupon where id = '" + p.getId() + "'";
		int delete = getSession().createQuery(sql).executeUpdate();
		return p;
	}

	
    public Coupon findByCouponCode(String code) {
        String jpql = "SELECT c FROM coupon c WHERE c.couponCode = :code";
        TypedQuery<Coupon> query = entityManager.createQuery(jpql, Coupon.class);
        query.setParameter("code", code);
        List<Coupon> result = query.getResultList();

        return result.isEmpty() ? null : result.get(0);
    }

}
