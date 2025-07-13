package com.ecom.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ecom.common.ICommonDAO;
import com.ecom.model.ShippingDetails;

@Repository(value = "shippingDetailsDAO")
@Transactional
public class ShippingDetailsDAO implements ICommonDAO<ShippingDetails, Long> {

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public ShippingDetails save(ShippingDetails s) {
		getSession().save(s);
		getSession().flush();
		return s;
	}

	public List<ShippingDetails> getAll() {
		String sql = "from shippingDetails";
		List<ShippingDetails> shippingDetails = getSession().createQuery(sql).list();
		return shippingDetails;
	}

	public ShippingDetails getById(long id) {
		String sql = "from shippingDetails where id = '" + id + "'";
		List<ShippingDetails> ecomList = getSession().createQuery(sql).list();
		return ecomList.get(0);

	}

	public ShippingDetails update(ShippingDetails s) {
		String hql = "update products set shippingDetails_code = '" + s.getShippingDetailsCode() + "', user_id = '"
				+ s.getUserId() + "', order_id = '" + s.getOrderId() + "', address = '" + s.getAddress() + "'"
				+ ", phone = '" + s.getPhone() + "', courier = '" + s.getCourier() + "', street = '" + s.getStreet()
				+ "', city = '" + s.getCity() + "', state = '" + s.getState() + "', postal_code = '" + s.getPostalCode()
				+ "', country = '" + s.getCountry() + "', tracking_no = '" + s.getTrackingNo() + "', status = '"
				+ s.getStatus() + "'  where id = '" + s.getId() + "'";
		Query q = getSession().createQuery(hql);
		q.executeUpdate();
		getSession().flush();
		return s;
	}

	public ShippingDetails delete(ShippingDetails s) {
		String sql = "delete products where id = '" + s.getId() + "'";
		int delete = getSession().createQuery(sql).executeUpdate();
		return s;
	}

}
