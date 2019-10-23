package com.korera.main.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

import com.korera.main.Config.JwtTokenUtil;
import com.korera.main.Entity.User;
import com.korera.main.Model.JwtRequest;
import com.korera.main.Service.JwtUserDetailsService;
import com.korera.main.Service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private PasswordEncoder bcryptEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@PostMapping("createUser")
	public Boolean createUser(@RequestBody String json) {
		/*
		 * Accepts a JSON formatted string with the parameters to create a user.
		 * Returns a true if the user is created, otherwise returns false.
		 * Will return false if a user with the given username already exists.
		 */
		JSONObject jsonObj = new JSONObject(json);
		String username = jsonObj.getString("username");
		String password = jsonObj.getString("password");
		String firstName = jsonObj.getString("firstName");
		String lastName = jsonObj.getString("lastName");
		String title = jsonObj.getString("title");
		
		//Hash the password with bcrypt
		String hashedPassword = bcryptEncoder.encode(password);
		User user = new User(username, hashedPassword, firstName, lastName, title, new Date());
		User created = userService.createUser(user);
		return (created != null) ? true : false;
	}
	
	@PostMapping("login")
	public String login(@RequestBody JwtRequest jwtReq) {
		/*
		 * Accepts a string username and password, and returns a temporary
		 * JWT authentication token as a string
		 */
		
		User user = userService.getUserByCredentials(jwtReq.getUsername(), jwtReq.getPassword());
		
		if(user == null) {
			return "failed";
		}
		else {
			
			final UserDetails userDetails = userDetailsService
					.loadUserByUsername(jwtReq.getUsername());
			
			final String token = jwtTokenUtil.generateToken(userDetails);
			
			return token;
		}
	}
	
//	@GetMapping("getUser")
//	public User getUser(@RequestParam String username, @RequestParam String password) {
//		/*
//		 * Accepts a string username and password, and returns the user object. If either parameter
//		 * is invalid, returns null.
//		 */
//		
//		return userService.getUserByCredentials(username, password);
//	}
	@GetMapping("getUser")
	public User getUser(@RequestHeader("Authorization") String auth) {
		
		//find user from the token
		if(auth.startsWith("Bearer ")) {
			String jwtToken = auth.substring(7);
			
			String username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			return userService.getUserByUsername(username);
			
			
			
		}
		
		return null;
	}
}
