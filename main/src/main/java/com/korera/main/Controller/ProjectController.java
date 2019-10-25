package com.korera.main.Controller;

import java.util.ArrayList;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.korera.main.DTO.ProjectDTO;
import com.korera.main.Entity.Resource;
import com.korera.main.Service.ProjectResourceService;
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
	private ResourceService resourceService;

	@Autowired
	private ProjectResourceService projectResourceService;

	@Autowired
	private ProjectUserService projectUserService;

	@Autowired
	private ProjectResourceDAO resDao;

	@Autowired
	private UserService userService;

	@GetMapping("/getDefaultProject/{uid}")
	public ProjectDTO getDefaultProject(@PathVariable("uid") Integer uid) {
		ProjectDTO defaultProject = projectService.getDefaultProjectByUserID(uid);
		return defaultProject;
	}

	@GetMapping("/getUserProjects/{uid}")
	public Page<ProjectDTO> getUserProjects(@PathVariable("uid") Integer uid) {
		Page<ProjectDTO> projects = projectService.getProjectsByUid(uid, null);
		return projects;
	}

	@GetMapping("/getProjectResources/{pid}")
	public Page<Resource> getProjectResources(@PathVariable("pid") Integer pid) {
		Page<Resource> resources = projectService.getResourcesbyPid(pid, null);
		return resources;
	}

	@PostMapping("/addProjectResource/{pid}")
	public void addProjectResource(@RequestBody String resourceJson, @PathVariable("pid") Integer pid) {
		JSONObject resourceObj = new JSONObject(resourceJson);
		resourceObj.put(resourceJson, pid);
	}

	@PutMapping("/editProjectResource/{pid}")
	public void editProjectResource(@RequestBody String resourceJson, @PathVariable("pid") Integer pid) {
		JSONObject resourceObj = new JSONObject(resourceJson);
		resourceObj.remove(resourceJson);
		resourceObj.put(resourceJson, pid);
	}

	@DeleteMapping("/resetProjectResource/{pid}")
	public void resetProjectResource(@PathVariable("pid") Integer pid) {
		projectService.setResouresbyPid(pid, new ArrayList<>());
	}

	@PostMapping("/addField")
	public void addField(@RequestBody String fieldJson) {
		JSONObject fieldObj = new JSONObject(fieldJson);
		Integer pid = fieldObj.getInt("pid");
		String resourceName = fieldObj.getString("resourceName");
		Integer resourceCode = fieldObj.getInt("resourceCode");
		String extraColsVal = fieldObj.getString("extraColsVal");
		Resource r = new Resource(resourceName, resourceCode, extraColsVal);

		projectService.addRow(pid, r);
	}

	@DeleteMapping("/deleteField")
	public void removeField(@RequestParam String fieldJson) {
		JSONObject fieldObj = new JSONObject(fieldJson);
		Integer pid = fieldObj.getInt("pid");
		Integer resourceId = fieldObj.getInt("resourceId");
		String resourceName = fieldObj.getString("resourceName");
		Integer resourceCode = fieldObj.getInt("resourceCode");
		String extraColsVal = fieldObj.getString("extraColsVal");
		//TODO: No Service for this yet
	}
}