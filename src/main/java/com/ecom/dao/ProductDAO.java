
package com.ecom.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ecom.common.ICommonDAO;
import com.ecom.model.Product;

@Repository(value = "productDAO")
@Transactional
public class ProductDAO implements ICommonDAO<Product, Long>{

//    @Autowired
//    private EntityManager entityManager;
//
//    private Session getSession() {
//        return entityManager.unwrap(Session.class);
//    }
//
//    public Product save(Product p){
//        getSession().save(p);
//        getSession().flush();
//        return p;
//    }
//
//    public List<Product> getAll(){
//        String sql = "from Product";
//        return getSession().createQuery(sql, Product.class).getResultList();
//    }
//
//    public Product getById(long id) {
//        String sql = "from Product where id = :id";
//        List<Product> productList = getSession().createQuery(sql, Product.class)
//                                                 .setParameter("id", id)
//                                                 .getResultList();
//        return productList.isEmpty() ? null : productList.get(0);
//    }

	@Autowired
	private EntityManager entityManager;

	private Session getSession() {
		return entityManager.unwrap(Session.class);
	}

	public Product save(Product p) {
		getSession().save(p);
		getSession().flush();
		return p;
	}

	public List<Product> getAll() {
		String sql = "from products";
		List<Product> products = getSession().createQuery(sql).list();
		return products;
	}

	public Product getById(long id) {
		String sql = "from products where id = '" + id + "'";
		List<Product> ecomList = getSession().createQuery(sql).list();
		return ecomList.get(0);

	}

	public Product update(Product p) {
		String hql = "update products set Code = '" + p.getProductCode() + "', Name = '" + p.getProductName()
				+ "', category_id = '" + p.getCategoryId() + "', category_name = '" + p.getCategoryName() + "'"
				+ ", sub_category_id = '" + p.getSubcategoryId() + "',sub_categoryName = '" + p.getSubcategoryName()
				+ "', seller_id = '" + p.getSellerId() + "', price = '" + p.getPrice() + "', stock = '" + p.getStock()
				+ "', main_image = '" + p.getMainImage() + "', created_at = '" + p.getCategoryId() + "'  where id = '"
				+ p.getId() + "'";
		Query q = getSession().createQuery(hql);
		q.executeUpdate();
		getSession().flush();
		return p;
	}

	public Product delete(Product p) {
		String sql = "delete products where id = '" + p.getId() + "'";
		int delete = getSession().createQuery(sql).executeUpdate();
		return p;
	}



}
