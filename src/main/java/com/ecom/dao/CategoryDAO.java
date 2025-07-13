package com.ecom.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.common.ICommonDAO;
import com.ecom.model.Category;

@Repository(value = "categoryDAO")
@Transactional
public class CategoryDAO implements ICommonDAO<Category, Long> {

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public Category save(Category c) {
		getSession().save(c);
		getSession().flush();
		return c;
	}

	public List<Category> getAll() {
		String sql = "from category";
		List<Category> category = getSession().createQuery(sql).list();
		return category;
	}

	public Category getById(long id) {
		String sql = "from category where id = '" + id + "'";
		List<Category> ecomList = getSession().createQuery(sql).list();
		return ecomList.get(0);

	}

	public Category update(Category c) {
		String hql = "update category set Code = '" + c.getCategoryCode() + "', Name = '" + c.getCategoryName()
				+ "'  where id = '" + c.getId() + "'";
		Query q = getSession().createQuery(hql);
		q.executeUpdate();
		getSession().flush();
		return c;
	}

	public Category delete(Category c) {
		String sql = "delete category where id = '" + c.getId() + "'";
		int delete = getSession().createQuery(sql).executeUpdate();
		return c;
	}

}
