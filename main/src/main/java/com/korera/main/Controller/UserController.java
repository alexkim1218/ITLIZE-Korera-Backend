package com.korera.main.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("createUser")
	public User createUser(@RequestBody String json) {
		JSONObject jsonObj = new JSONObject(json);
		String username = jsonObj.getString("username");
		String password = jsonObj.getString("password");
		String firstName = jsonObj.getString("firstName");
		String lastName = jsonObj.getString("lastName");
		String title = jsonObj.getString("title");
		User user = new User(username, password, firstName, lastName, title, new Date());
		return userService.createUser(user);
	}
	
	@GetMapping("login")
	public User login(@RequestParam String username, @RequestParam String password) {
		return userService.getUserByCredentials(username, password);
	}
}
