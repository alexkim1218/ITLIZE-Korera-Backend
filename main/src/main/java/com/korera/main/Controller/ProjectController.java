package com.korera.main.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.korera.main.DAO.ProjectResourceDAO;
import com.korera.main.DAO.ResourceDAO;
import com.korera.main.DTO.ProjectDTO;
import com.korera.main.Entity.Project;
import com.korera.main.Entity.Resource;
import com.korera.main.Entity.User;
//import com.korera.main.Entity.Project;
import com.korera.main.Service.ProjectService;
import com.korera.main.Service.ProjectUserService;
import com.korera.main.Service.ResourceService;
import com.korera.main.Service.UserService;


@RestController
@RequestMapping("project")
public class ProjectController {
	
	@Autowired 
	private ProjectService projectService;
	
	@Autowired
	private ProjectResourceDAO resDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectUserService projectUserService;
	
	@GetMapping("/getDefaultProject/{uid}")
	public ProjectDTO getDefaultProject(@PathVariable("uid") Integer uid) {
		ProjectDTO p = projectService.getDefaultProjectByUserID(uid);
		return p;
	}
	
	@GetMapping("/getUserProjects/{uid}")
	public List<Project> getUserProjects(@PathVariable("uid") Integer uid){
//		return projectService.getProjectsByUid(uid, ).getContent();
//		TODO
		return null;
	}
	
	
	@GetMapping("/getProjectResources/{pid}")
	public List<Project> getProjectResources(@PathVariable("pid") Integer pid){
//		TODO

		return null;
	}
	
	@PostMapping("/addProjectResource/{pid}")
	public void addProjectResource(@RequestBody String resourceJson,
			@PathVariable("pid") Integer pid) {
//		TODO
	}
	
	@PutMapping("/editProjectResource/{pid}")
	public void editProjectResource(@RequestBody String resourceJson,
			@PathVariable("pid") Integer pid) {
//		TODO
	}
	
	@DeleteMapping("/resetProjectResource/{pid}")
	public void resetProjectResource() {
//		TODO
	}
	
	@PostMapping("/addField")
	public void addField(@RequestBody String fieldName) {
//		TODO
	}
	
	@DeleteMapping("/deleteField")
	public void removeField(@RequestParam String fieldName) {
//		TODO
	}
	
	
	
	
}
