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
import com.ecom.dao.SellerDAO;
import com.ecom.model.Product;
import com.ecom.model.Seller;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")

public class SellerController implements IcommonController<Seller> {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	@GetMapping("/seller")
    public List<Seller> getAll() {
        return sellerDAO.getAll();
    }

    @GetMapping("/Seller/{id}")
    public ResponseEntity<Seller> getById(@PathVariable(value = "id") Long sellerId) {
    	Seller seller = sellerDAO.getById(sellerId);
        return ResponseEntity.ok().body(seller);
    }

    @PostMapping("/seller")
    public Seller save(@Validated @RequestBody Seller seller) {
        //return employeeDAO.save(employee);
    	return sellerDAO.save(seller);
    }

    @PutMapping("/seller/{id}")
    public ResponseEntity<Seller> update(@PathVariable(value = "id") Long sellerId,
         @Validated @RequestBody Seller sellerDetails) {
    	Seller seller = sellerDAO.getById(sellerId);
    	
    	seller.setStatus(sellerDetails.getStatus());

        
        final Seller updatedSeller = sellerDAO.save(seller);
        return ResponseEntity.ok(updatedSeller);
    }

    @DeleteMapping("/seller/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long sellerId){
        Seller seller = sellerDAO.getById(sellerId);
        sellerDAO.delete(seller);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    

}
