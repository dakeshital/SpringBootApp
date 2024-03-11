package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.impl.UserServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/userdetails")
public class UserController {

	@Autowired
	private UserServiceImpl service;

	@PostMapping("/save")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createduser = service.createUser(user);
		return new ResponseEntity<>(createduser, HttpStatus.CREATED);
	}

    // http://localhost:8080/api/userdetails/all
	@GetMapping("/all")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}
	
    // http://localhost:8080/api/userdetails/1
	@GetMapping("{id}")
	public User getUserById(@PathVariable ("id") Long userid) {
		User userId=service.getUserBId(userid);
		return userId;
	}
	
	@PutMapping("{id}")
    // http://localhost:8080/api/userdetailss/1
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
        user.setId(userId);
        User updatedUser = service.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        service.deleteUserById(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
	
}
