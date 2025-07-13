package com.ecom.controller;
import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ecom.common.IcommonController;
import com.ecom.dao.CouponDAO;
import com.ecom.model.Coupon;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class CouponController implements IcommonController<Coupon> {
	
	@Autowired
	private CouponDAO couponDAO;

	
	 @GetMapping("/coupon")
	    public List<Coupon> getAll() {
	        return couponDAO.getAll();
	    }

	    @GetMapping("/coupon/{id}")
	    public ResponseEntity<Coupon> getById(@PathVariable(value = "id") Long couponId) {
	    	Coupon coupon = couponDAO.getById(couponId);
	        return ResponseEntity.ok().body(coupon);
	    }

	    @PostMapping("/coupon")
	    public Coupon save(@Validated @RequestBody Coupon coupon) {
	    	return couponDAO.save(coupon);
	    }

	    @PutMapping("/coupon/{id}")
	    public ResponseEntity<Coupon> update(@PathVariable(value = "id") Long couponId,
	         @Validated @RequestBody Coupon couponDetails) {
	    	Coupon coupon = couponDAO.getById(couponId);
	    	
	    	coupon.setCouponCode(couponDetails.getCouponCode());
	    	coupon.setDiscountAmount(couponDetails.getDiscountAmount());
	    	coupon.setType(couponDetails.getType());
	    	coupon.setActive(couponDetails.getActive());
	    	coupon.setStartDate(couponDetails.getStartDate());
	    	coupon.setEndDate(couponDetails.getEndDate());
	    	
	        final Coupon updatedCoupon = couponDAO.save(coupon);
	        return ResponseEntity.ok(updatedCoupon);
	    }

	    @DeleteMapping("/coupon/{id}")
	    public Map<String, Boolean> delete(@PathVariable(value = "id") Long couponId){
	        Coupon coupon = couponDAO.getById(couponId);
	        couponDAO.delete(coupon);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
	    
	    
	    @GetMapping("/apply-coupon")
	    public ResponseEntity<?> applyCoupon(@RequestParam String code) {
	        Coupon coupon = couponDAO.findByCouponCode(code);

	        if (coupon == null) {
	            return ResponseEntity.badRequest().body("❌ Invalid Coupon Code");
	        }

	        // Check if coupon is active
	        if (!coupon.getActive()) {
	            return ResponseEntity.badRequest().body("❌ Coupon is inactive");
	        }

	        // Parse string date
	        LocalDate today = LocalDate.now();
	        LocalDate start = LocalDate.parse(coupon.getStartDate());
	        LocalDate end = LocalDate.parse(coupon.getEndDate());

	        if (today.isBefore(start) || today.isAfter(end)) {
	            return ResponseEntity.badRequest().body("❌ Coupon expired or not yet active");
	        }

	        // Return only necessary info to frontend
	        return ResponseEntity.ok(new CouponResponse(
	                coupon.getDiscountAmount(),
	                coupon.getType().toString()
	        ));
	    }

	    // Response DTO
	    static class CouponResponse {
	        private int discountAmount;
	        private String type;

	        public CouponResponse(int discountAmount, String type) {
	            this.discountAmount = discountAmount;
	            this.type = type;
	        }

	        public int getDiscountAmount() {
	            return discountAmount;
	        }

	        public String getType() {
	            return type;
	        }
	    }
	       
}
