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
import com.ecom.dao.SubcategoryDAO;
import com.ecom.model.Subcategory;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")

public class SubcategoryController implements IcommonController<Subcategory> {
	
	
	@Autowired
	private SubcategoryDAO subcategoryDAO;

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
  
	

    @GetMapping("/subcategory")
    public List<Subcategory> getAll() {
        return subcategoryDAO.getAll();
    }

    @GetMapping("/subcategory/{id}")
    public ResponseEntity<Subcategory> getById(@PathVariable(value = "id") Long subcategoryId) {
    	Subcategory subcategory = subcategoryDAO.getById(subcategoryId);
        return ResponseEntity.ok().body(subcategory);
    }

    @PostMapping("/subcategory")
    public Subcategory save(@Validated @RequestBody Subcategory subcategory) {
        //return employeeDAO.save(employee);
    	return subcategoryDAO.save(subcategory);
    }

    @PutMapping("/subcategory/{id}")
    public ResponseEntity<Subcategory> update(@PathVariable(value = "id") Long subcategoryId,
         @Validated @RequestBody Subcategory subcategoryDetails) {
    	Subcategory subcategory = subcategoryDAO.getById(subcategoryId);
    	
    	subcategory.setSubcategoryCode(subcategoryDetails.getSubcategoryCode());
    	subcategory.setSubcategoryName(subcategoryDetails.getSubcategoryName());
    	subcategory.setCategoryId(subcategoryDetails.getCategoryId());
    	subcategory.setCategoryName(subcategoryDetails.getCategoryName());
    	
        
        final Subcategory updatedSubcategory = subcategoryDAO.save(subcategory);
        return ResponseEntity.ok(updatedSubcategory);
    }

    @DeleteMapping("/subcategory/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long subcategoryId){
    	Subcategory subcategory = subcategoryDAO.getById(subcategoryId);
        subcategoryDAO.delete(subcategory);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    

}
