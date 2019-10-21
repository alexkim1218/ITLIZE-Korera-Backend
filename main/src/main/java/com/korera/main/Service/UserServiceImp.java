package com.korera.main.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korera.main.Entity.User;
import com.korera.main.DAO.UserDAO;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserDAO userDao;
	
	@Override
	public User getUserByCredentials(String username, String password) {
		User user = userDao.findByUserName(username);
		if(user != null && password.equals(user.getPassword())) {
			return user;
		}
		
		return null;
	}

	@Override
	public User createUser(User user) {
		
		//First check if username already exists
		User createUser = userDao.findByUserName(user.getUsername());
		if(createUser != null) {
			//User already exists
			System.out.println("User with username " + user.getUsername()
					+ " already exists.");
			return null;
		}
		
		User createdUser = userDao.save(user);
		System.out.println("User created successfully!");
		return createdUser;
	}

}
