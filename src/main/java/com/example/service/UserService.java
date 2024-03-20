package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.User;

public interface UserService {

	public User createUser(User user);

	public List<User> getAllUsers();

	Optional<User> getUserById(Long id);

	public User updateUser(User user);

	public void deleteUserById(Long id);

}
