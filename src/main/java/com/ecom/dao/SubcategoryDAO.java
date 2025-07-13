package com.ecom.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.common.ICommonDAO;
import com.ecom.model.Subcategory;

@Repository(value = "subcategoryDAO")
@Transactional

public class SubcategoryDAO implements ICommonDAO<Subcategory, Long> {

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public Subcategory save(Subcategory sc) {
		System.out.println(sc.getCategoryName());
		getSession().save(sc);
		getSession().flush();
		return sc;
	}

	public List<Subcategory> getAll() {
		String sql = "from subcategory";
		List<Subcategory> subcategory = getSession().createQuery(sql).list();
		return subcategory;
	}

	public Subcategory getById(long id) {
		String sql = "from subcategory where id = '" + id + "'";
		List<Subcategory> ecomList = getSession().createQuery(sql).list();
		return ecomList.get(0);

	}

	public Subcategory update(Subcategory sc) {
		String hql = "update category set Code = '" + sc.getSubcategoryCode() + "', Name = '" + sc.getSubcategoryName()
				+ "', category_id = '" + sc.getCategoryId() + "', category_name = '" + sc.getCategoryName() + "'  where id = '" + sc.getId() + "'";
		Query q = getSession().createQuery(hql);
		q.executeUpdate();
		getSession().flush();
		return sc;
	}

	public Subcategory delete(Subcategory sc) {
		String sql = "delete subcategory where id = '" + sc.getId() + "'";
		int delete = getSession().createQuery(sql).executeUpdate();
		return sc;
	}

}
