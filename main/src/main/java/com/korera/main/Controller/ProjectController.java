package com.korera.main.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korera.main.DAO.ProjectResourceDAO;
import com.korera.main.DAO.ResourceDAO;
import com.korera.main.Entity.Project;
import com.korera.main.Entity.Resource;
//import com.korera.main.Entity.Project;
import com.korera.main.Service.ProjectService;
import com.korera.main.Service.ResourceService;


@RestController
public class ProjectController {
	
	@Autowired 
	private ProjectService projectService;
	
	@Autowired
	private ProjectResourceDAO resDao;
	
	@RequestMapping("/project")
	public Project callProject() {
//		User u = new User("chbernar", "asdf1234", "Christhoper", "Bernard", "Programmer");
//		u.addProject(new Project())
		
		Project p = projectService.getProjectByPid(1);
		
		return p;
//		return "project called";
	}
}
