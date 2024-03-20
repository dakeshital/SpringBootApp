package com.example.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.exception.UserNotFoundException;
import com.example.service.impl.UserServiceImpl;

import lombok.AllArgsConstructor;

@RestController
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

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		Optional<User> userOptional = service.getUserById(id);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			return ResponseEntity.ok(user);
		} else {
			throw new UserNotFoundException("User not found with ID: " + id);
		}
	}

	@PutMapping("{id}")
	// http://localhost:8080/api/userdetailss/1
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
		user.setId(userId);
		User updatedUser = service.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		service.deleteUserById(userId);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}

}
