package Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Entity.Project;
import Entity.User;

@RestController
public class ProjectController {
	
	@RequestMapping("/project")
	public User callProject() {
		User u = new User("chbernar", "asdf1234", "Christhoper", "Bernard", "Programmer");
		return u;
	}
}
