package com.ecom.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.common.IcommonController;
import com.ecom.dao.CategoryDAO;
import com.ecom.model.Category;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")

public class CategoryController implements IcommonController<Category> {

	@Autowired
	private CategoryDAO categoryDAO;

//
//  @GetMapping("/product")
//  public List<Product> getAll() {
//      return productDAO.getAll();
//  }
//  
//  @GetMapping("/product/{id}")
//  public ResponseEntity<Product> getById(@PathVariable(value = "id") Long productId) {
//  	Product product = productDAO.getProductById(productId);
//      return ResponseEntity.ok().body(product);
//  }
//
//  @PostMapping("/product")
//  public Product save(@RequestBody Product product) {
//      return productDAO.save(product);
//  }
//  
//  
//  
//  @Override
//  public ResponseEntity<Product> update(Long id, Product t) {
//  	// TODO Auto-generated method stub
//  	return null;
//  }
//  
//	@Override
//	public Map<String, Boolean> delete(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//  

	@GetMapping("/category")
	public List<Category> getAll() {
		return categoryDAO.getAll();
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getById(@PathVariable(value = "id") Long categoryId) {
		Category category = categoryDAO.getById(categoryId);
		return ResponseEntity.ok().body(category);
	}

	@PostMapping("/category")
	public Category save(@Validated @RequestBody Category category) {
		// return employeeDAO.save(employee);
		return categoryDAO.save(category);
	}

	@PutMapping("/category/{id}")
	public ResponseEntity<Category> update(@PathVariable(value = "id") Long categoryId,
			@Validated @RequestBody Category categoryDetails) {
		Category category = categoryDAO.getById(categoryId);

		category.setCategoryCode(categoryDetails.getCategoryCode());
		category.setCategoryName(categoryDetails.getCategoryName());

		final Category updatedCategory = categoryDAO.save(category);
		return ResponseEntity.ok(updatedCategory);
	}

	@DeleteMapping("/category/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long categoryId) {
		Category category = categoryDAO.getById(categoryId);
		categoryDAO.delete(category);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
