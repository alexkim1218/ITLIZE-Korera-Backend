package com.korera.main.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

import com.korera.main.Entity.User;
import com.korera.main.Service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
    private PasswordEncoder bcryptEncoder;
	
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
	
	@GetMapping("login")
	public String login(@RequestParam String username, @RequestParam String password) {
		/*
		 * Accepts a string username and password, and returns a temporary
		 * JWT authentication token as a string
		 */
		
		User user = userService.getUserByCredentials(username, password);
		if(user == null) {
			return "failed";
		}
		else {
			//TODO: Update this to return a JWT token for the given user;
			return "validtoken";
		}
	}
	
	@GetMapping("getUser")
	public User getUser(@RequestParam String username, @RequestParam String password) {
		/*
		 * Accepts a string username and password, and returns the user object. If either parameter
		 * is invalid, returns null.
		 */
		
		return userService.getUserByCredentials(username, password);
	}
}
