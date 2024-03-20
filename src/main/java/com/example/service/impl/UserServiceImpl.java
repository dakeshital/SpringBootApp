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
		return userrepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userrepo.findAll();
	}

//	@Override
//	public User getUserById(Long id) {
//		Optional<User> user = userrepo.findById(id);
//		return user.get();
//	}
	public Optional<User> getUserById(Long id) {
        return userrepo.findById(id);
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
		userrepo.deleteById(id);
	}

}
