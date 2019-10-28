package com.korera.main.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.korera.main.Entity.Project;
import com.korera.main.Entity.ProjectResource;
import com.korera.main.Entity.ProjectUser;
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

	@GetMapping(path = "/getDefaultProject/{uid}")
	public ProjectDTO getDefaultProject(@PathVariable("uid") Integer uid) {
		ProjectDTO defaultProject = projectService.getDefaultProject(uid);
		return defaultProject;
	}

	@GetMapping(path = "/getUserProjects/{uid}")
	public List<Project> getUserProjects(@PathVariable("uid") Integer uid) {
		List<ProjectUser> projectUserList = projectUserService.getAllProjectUser(uid);
        List<Project> projectList = new ArrayList<>();
        
        for (int i = 0; i <projectUserList.size(); i++) {
            ProjectUser projectUser = projectUserList.get(i);
            Integer pid = projectUser.getPid();
            Project project = projectService.getProjectByPid(pid);
            projectList.add(project);
        }
        
        return  projectList;
	}

	@GetMapping(path = "/getProjectResources/{pid}")
	public Set<Resource> getProjectResources(@PathVariable("pid") Integer pid) {
		
		List<ProjectResource> projectResourceList = projectResourceService.getAllProjectResource(pid);
        Set<Resource> resourceSet = new HashSet<>();
        
        for (int i = 0; i <projectResourceList.size(); i++) {
            ProjectResource projectResource = projectResourceList.get(i);
            Integer rid = projectResource.getRid();
            Resource resource = resourceService.getResourceById(rid);
            resourceSet.add(resource);
        }
        
        return resourceSet;
	}

	@PostMapping(path = "/addProjectResource/{pid}/{rid}")
	public void addProjectResource(@PathVariable("rid") Integer rid, @PathVariable("pid") Integer pid) {
		projectResourceService.addProjectResource(pid,rid);
	}

	@PutMapping(path = "/editProjectResource/{pid}")
	public void editProjectResource(@RequestBody String resourceJson, @PathVariable("pid") Integer pid) throws Exception {
		JSONObject resourceObj = new JSONObject(resourceJson);

		Integer rid = resourceObj.getInt("resourceId");
		String resourceName = resourceObj.getString("resourceName");
		Integer resourceCode = resourceObj.getInt("resourceCode");
		String extraColsVal = resourceObj.getString("extraColsVal");
		Resource r = new Resource(rid, resourceName, resourceCode, extraColsVal);

		resourceService.editResourceByRid(rid,r);
	}

	@DeleteMapping(path = "/resetProjectResource/{pid}")
	public void resetProjectResource(@PathVariable("pid") Integer pid) {
		projectResourceService.deleteAllProjectResourceByPid(pid);
	}

	@PostMapping(path = "/addField")
	public void addField(@RequestBody String fieldJson) {
		JSONObject fieldObj = new JSONObject(fieldJson);
		Integer pid = fieldObj.getInt("pid");
		String resourceName = fieldObj.getString("resourceName");
		Integer resourceCode = fieldObj.getInt("resourceCode");
		String extraColsVal = fieldObj.getString("extraColsVal");
		Resource r = new Resource(resourceName, resourceCode, extraColsVal);

		projectService.addRow(pid, r);
	}

	@DeleteMapping(path = "/deleteAllResource")
	public void removeField() {
		resourceService.deleteAllResource();
	}
	
	@PostMapping(path = "/addColumn/{pid}")
	public void addColumn(@RequestBody String colJson, @PathVariable("pid") Integer pid) {
		JSONObject colObj = new JSONObject(colJson);
		String colName = colObj.getString("colName");
		String colType = colObj.getString("colType");
		projectService.addColumn(pid, colName, colType);
	}
	
	@DeleteMapping(path = "/deleteColumn/{pid}")
	public void deleteColumn(@RequestParam String colName, 
			@RequestParam String colType, @PathVariable("pid") Integer pid) {
		projectService.deleteColumn(pid, colName, colType);
	}
}