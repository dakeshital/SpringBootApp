package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.User;
import com.example.repo.UserRepository;

@SpringBootApplication
public class SpringBootCrudAppApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudAppApplication.class, args);
		
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(1L);
		user.setName("shital");
		user.setEmail("asdff@msf.sdh");
		repo.save(user);
		System.out.println("user saved"+user);
	}
}
