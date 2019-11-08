package com.korera.main.Controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korera.main.Entity.ProjectResource;
import com.korera.main.Entity.Resource;
import com.korera.main.Service.ProjectResourceService;
import com.korera.main.Service.ResourceService;

@RestController
@RequestMapping("resource")
@CrossOrigin(origins = "*")
public class ResourceController {
	
	@Autowired
	ResourceService resourceService;
	
	@Autowired
	ProjectResourceService projectResourceService;
	
	@PostMapping(path = "/addResource")
	public Resource addResource(@RequestBody String json) {
		JSONObject jsonObj = new JSONObject(json);
		String resourceName = jsonObj.getString("resourceName");
		int resourceCode = jsonObj.getInt("resourceCode");
		String extraColsVal = jsonObj.getString("extraColsVal");
		
		Resource resource = new Resource(resourceName, resourceCode, extraColsVal);
		return resourceService.addResource(resource);
	}
	
	@GetMapping(path = "/getAllResources")
	public List<Resource> getAllResources(){
		return resourceService.getAllResources();
	}
	
	@GetMapping(path = "/getResourcesByProject/{pid}")
	public List<Resource> getResourcesByProject(@PathVariable("pid") Integer pid){
		List<ProjectResource> prList = projectResourceService.getAllProjectResource(pid);
		List<Resource> rList = new ArrayList<Resource>();
		for(int i=0; i < prList.size(); i++) {
			rList.add(resourceService.getResourceById(prList.get(i).getRid()));
		}
		return rList;
	}
}
