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
import com.ecom.dao.ShippingDetailsDAO;
import com.ecom.model.ShippingDetails;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")

public class ShippingDetailsController implements IcommonController<ShippingDetails> {

	@Autowired
	private ShippingDetailsDAO shippingDetailsDAO;

	@GetMapping("/sdetails")
	public List<ShippingDetails> getAll() {
		return shippingDetailsDAO.getAll();
	}

	@GetMapping("/sdetails/{id}")
	public ResponseEntity<ShippingDetails> getById(@PathVariable(value = "id") Long sDetailsId) {
		ShippingDetails shippingDetails = shippingDetailsDAO.getById(sDetailsId);
		return ResponseEntity.ok().body(shippingDetails);
	}

	@PostMapping("/sdetails")
	public ShippingDetails save(@Validated @RequestBody ShippingDetails shippingDetails) {
		// return employeeDAO.save(employee);
		return shippingDetailsDAO.save(shippingDetails);
	}

	@PutMapping("/sdetails/{id}")
	public ResponseEntity<ShippingDetails> update(@PathVariable(value = "id") Long sDetailsId,
			@Validated @RequestBody ShippingDetails shippingDetail) {
		ShippingDetails shippingDetails = shippingDetailsDAO.getById(sDetailsId);

		shippingDetails.setShippingDetailsCode(shippingDetail.getShippingDetailsCode());
		shippingDetails.setUserId(shippingDetail.getUserId());
		shippingDetails.setOrderId(shippingDetail.getOrderId());
		shippingDetails.setAddress(shippingDetail.getAddress());
		shippingDetails.setPhone(shippingDetail.getPhone());
		shippingDetails.setCourier(shippingDetail.getCourier());
		shippingDetails.setStreet(shippingDetail.getStreet());
		shippingDetails.setCity(shippingDetail.getCity());
		shippingDetails.setState(shippingDetail.getState());
		shippingDetails.setPostalCode(shippingDetail.getPostalCode());
		shippingDetails.setCountry(shippingDetail.getCountry());
		shippingDetails.setTrackingNo(shippingDetail.getTrackingNo());
		shippingDetails.setStatus(shippingDetail.getStatus());

		final ShippingDetails updatedShippingDetails = shippingDetailsDAO.save(shippingDetails);
		return ResponseEntity.ok(updatedShippingDetails);
	}

	@DeleteMapping("/sdetails/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Long sDetailsId) {
		ShippingDetails shippingDetails = shippingDetailsDAO.getById(sDetailsId);
		shippingDetailsDAO.delete(shippingDetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
