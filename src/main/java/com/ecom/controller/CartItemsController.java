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
import com.ecom.dao.CartItemsDAO;
import com.ecom.dao.ProductDAO;
import com.ecom.model.CartItems;
import com.ecom.model.Product;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class CartItemsController implements IcommonController<CartItems> {

	
	@Autowired
	private CartItemsDAO cartItemsDAO;


    @GetMapping("/cartItems")
    public List<CartItems> getAll() {
        return cartItemsDAO.getAll();
    }

    @GetMapping("/cartItems/{id}")
    public ResponseEntity<CartItems> getById(@PathVariable(value = "id") Long cartItemsId) {
    	CartItems cartItems = cartItemsDAO.getById(cartItemsId);
        return ResponseEntity.ok().body(cartItems);
    }

    @PostMapping("/cartItems")
    public CartItems save(@Validated @RequestBody CartItems cartItems) {
        //return employeeDAO.save(employee);
    	return cartItemsDAO.save(cartItems);
    }

    @PutMapping("/cartItems/{id}")
    public ResponseEntity<CartItems> update(@PathVariable(value = "id") Long cartItemsId,
         @Validated @RequestBody CartItems cartItemsDetails) {
    	CartItems cartItems = cartItemsDAO.getById(cartItemsId);
    	
    	cartItems.setCartItemsCode(cartItemsDetails.getCartItemsCode());
    	cartItems.setUserId(cartItemsDetails.getUserId());
    	cartItems.setProductId(cartItemsDetails.getProductId());
    	cartItems.setProductCode(cartItemsDetails.getProductCode());
    	cartItems.setProductName(cartItemsDetails.getProductName());
    	cartItems.setQuantity(cartItemsDetails.getQuantity());
    	cartItems.setPrice(cartItemsDetails.getPrice());
    	cartItems.setTotalPrice(cartItemsDetails.getTotalPrice());
        
        final CartItems updatedCartItems = cartItemsDAO.save(cartItems);
        return ResponseEntity.ok(updatedCartItems);
    }

    @DeleteMapping("/cartItems/{id}")
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long cartItemsId){
    	CartItems cartItems = cartItemsDAO.getById(cartItemsId);
        cartItemsDAO.delete(cartItems);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
