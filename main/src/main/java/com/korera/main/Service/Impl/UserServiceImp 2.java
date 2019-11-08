package com.korera.main.Service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korera.main.DAO.UserDAO;
import com.korera.main.Entity.User;
import com.korera.main.Service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDAO userDao;
	
	@Override
	public User getUserByCredentials(String username, String password) {
		User user = userDao.findByUsername(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		
		return null;
	}

	@Override
	public User createUser(User user) {
		
		//First check if username already exists
		User createUser = userDao.findByUsername(user.getUsername());
		if(createUser != null) {
			//User already exists
			System.out.println("User with username " + user.getUsername()
					+ " already exists.");
			return null;
		}
		
		User createdUser = userDao.saveAndFlush(user);
		System.out.println("User created successfully!");
		return createdUser;
	}

}
