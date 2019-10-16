package Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	
	@RequestMapping("/project")
	public String callProject() {
		return "project called";
	}
}
