package com.korera.main.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.korera.main.DAO.UserDAO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		com.korera.main.Entity.User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		else {
			return new org.springframework.security.
					core.userdetails.User(user.getUsername(),
							user.getPassword(),
							new ArrayList<>());
		}
			
		
	}
}