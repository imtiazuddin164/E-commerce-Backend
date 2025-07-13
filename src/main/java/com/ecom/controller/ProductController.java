    package com.ecom.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.common.IcommonController;
import com.ecom.dao.ProductDAO;
import com.ecom.model.Product;
import com.ecom.repository.ProductRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")

public class ProductController implements IcommonController<Product> {

	

	
	@Autowired
	private ProductDAO productDAO;
	

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
  
	

    @GetMapping("/product")
    public List<Product> getAll() {
        return productDAO.getAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getById(@PathVariable(value = "id") Long productId) {
    	Product product = productDAO.getById(productId);
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/product")
    public Product save(@Validated @RequestBody Product product) {
        //return employeeDAO.save(employee);
    	return productDAO.save(product);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> update(@PathVariable(value = "id") Long productId,
         @Validated @RequestBody Product productDetails) {
    	Product product = productDAO.getById(productId);
    	
    	product.setProductCode(productDetails.getProductCode());
    	product.setProductName(productDetails.getProductName());
    	product.setCategoryId(productDetails.getCategoryId());
    	product.setCategoryName(productDetails.getCategoryName());
    	product.setSubcategoryId(productDetails.getSubcategoryId());
    	product.setSubcategoryName(productDetails.getSubcategoryName());
    	product.setSellerId(productDetails.getSellerId());
    	product.setDescription(productDetails.getDescription());
    	product.setPrice(productDetails.getPrice());
    	product.setStock(productDetails.getStock());
//    	product.setMainImage(productDetails.getMainImage());
        
        final Product updatedProduct = productDAO.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/product/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long productId){
        Product product = productDAO.getById(productId);
        productDAO.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
    
	//image upload
    @PostMapping("/saveProductWithImage")
    public Product saveProductWithImage(@RequestPart("product") Product product,
                                        @RequestPart("image") MultipartFile file) throws IOException {
        
        // Save image to static folder
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
        String imagePath = "src/main/resources/static/img/" + file.getOriginalFilename();
        ImageIO.write(image, "jpg", new File(imagePath));
        
        // Save product to DB
        product.setMainImage(file.getOriginalFilename());
        return productDAO.save(product);
    }
    
    
    
}


