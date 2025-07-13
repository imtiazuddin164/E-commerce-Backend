package com.ecom.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecom.dao.OrderDAO;
import com.ecom.enums.OrderStatus;
import com.ecom.model.Order;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")

public class OrderController {
	
	
	
	@Autowired
    private OrderDAO orderDAO;

    
    @PostMapping("/orders")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
    	System.out.println("Hi");
        Order saved = orderDAO.save(order);
        
        return ResponseEntity.ok(saved);      
    }

    
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderDAO.getAll());
    }

    
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderDAO.getById(id);
        if (order == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(order);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order existing = orderDAO.getById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        order.setId(id);
        Order updated = orderDAO.update(order);
        return ResponseEntity.ok(updated);   
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        Order order = orderDAO.getById(id);
        if (order == null) return ResponseEntity.notFound().build();

        orderDAO.delete(order);
        return ResponseEntity.ok("Order deleted.");
    }
	
//    new section approval 
    


    // ✅ Check approval status (customer side)
    @GetMapping("/orders/check-approval/{orderId}")
    public ResponseEntity<Boolean> checkApproval(@PathVariable Long orderId) {
        Order order = orderDAO.getById(orderId);
        if (order == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(order.isApproved());
    }

    // ✅ Approve an order (admin side)
    @PutMapping("/orders/approve/{orderId}")
    public ResponseEntity<String> approveOrder(@PathVariable Long orderId) {
        Order order = orderDAO.getById(orderId);
        System.out.println("orderId:" + orderId);
        if (order == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");

        order.setApproved(true);
        order.setStatus(OrderStatus.APPROVED);
        orderDAO.update(order);
        return ResponseEntity.ok("Order Approved");
    }
    
    @PutMapping("/orders/reject/{orderId}")
    public ResponseEntity<String> rejectOrder(@PathVariable Long orderId) {
        Order order = orderDAO.getById(orderId);
        if (order == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");

        order.setApproved(false);
        order.setStatus(OrderStatus.REJECTED);
        orderDAO.update(order);
        return ResponseEntity.ok("Order Rejected");
    }


//	@Autowired
//	private OrderDAO orderDAO;
//	
//	@GetMapping("/order")
//    public List<Order> getAll() {
//        return orderDAO.getAll();
//    }
//
//    @GetMapping("/order/{id}")
//    public ResponseEntity<Order> getById(@PathVariable(value = "id") Long orderId) {
//    	Order order = orderDAO.getById(orderId);
//        return ResponseEntity.ok().body(order);
//    }
//
//    @PostMapping("/order")
//    public Order save(@Validated @RequestBody Order order) {
//    	return orderDAO.save(order);
//    }
//
//    @PutMapping("/order/{id}")
//    public ResponseEntity<Order> update(@PathVariable(value = "id") Long orderId,
//         @Validated @RequestBody Order orderDetails) {
//    	Order order = orderDAO.getById(orderId);
//    	
//    	order.setUserId(orderDetails.getUserId());
//    	order.setOrderCode(orderDetails.getOrderCode());
//    	order.setCustomerName(orderDetails.getCustomerName());
//    	order.setPhone(orderDetails.getPhone());
//    	order.setAddress(orderDetails.getAddress());
//    	order.setTotalAmount(orderDetails.getTotalAmount());
//    	order.setOrderDate(orderDetails.getOrderDate());
//    	order.setStatus(orderDetails.getStatus());
//  
//
//        
//        final Order updatedOrder = orderDAO.save(order);
//        return ResponseEntity.ok(updatedOrder);
//    }
//
//    @DeleteMapping("/order/{id}")
//    public Map<String, Boolean> delete(@PathVariable(value = "id") Long orderId){
//        Order order = orderDAO.getById(orderId);
//        orderDAO.delete(order);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }
//    
	
}
