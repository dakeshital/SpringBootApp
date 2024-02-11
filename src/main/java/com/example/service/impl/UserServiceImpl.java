package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repo.UserRepository;
import com.example.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepo;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub

		return userrepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public User getUserBId(Long id) {
		// TODO Auto-generated method stub
		Optional<User> user = userrepo.findById(id);
		return user.get();
	}

	@Override
	public User updateUser(User user) {
		User existingUser = userrepo.findById(user.getId()).get();
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		User updatedUser = userrepo.save(existingUser);
		return updatedUser;
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userrepo.deleteById(id);
	}

}
