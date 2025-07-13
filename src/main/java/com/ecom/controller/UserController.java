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
import com.ecom.dao.UserDAO;
import com.ecom.model.Category;
import com.ecom.model.User;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController implements IcommonController<User> {
	
	@Autowired
	private UserDAO userDao;

    @GetMapping("/user")
    public List<User> getAll() {
        return userDao.getAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getById(@PathVariable(value = "id") Long userId) {
    	User user = userDao.getUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        //return employeeDAO.save(employee);
    	return userDao.save(user);
    }
    
    @PostMapping("/user/login")
    public User login(@RequestBody User user) {
        //return employeeDAO.save(employee);
    	return userDao.getUserByUsername(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> update(@PathVariable(value = "id") Long userId,
         @Validated @RequestBody User userDetails) {
    	User user = userDao.getUserById(userId);
    	user.setName(userDetails.getName());
    	user.setEmail(userDetails.getEmail());
    	user.setPhone(userDetails.getPhone());
    	user.setUserName(userDetails.getUserName());
    	user.setPassword(userDetails.getPassword());
    	user.setConfirmPassword(userDetails.getConfirmPassword());
        final User updateduser = userDao.save(user);
        return ResponseEntity.ok(updateduser);
    }

	@Override
	public Map<String, Boolean> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

//    @DeleteMapping("/user/{id}")
//    public Map<String, Boolean> delete(@PathVariable(value = "id") Long userId){
//    	User user = userDao.getUserById(userId);
//    	userDao.delete(user);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

}
