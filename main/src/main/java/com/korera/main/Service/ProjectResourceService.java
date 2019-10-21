package com.korera.main.Service;

import com.korera.main.Entity.ProjectResource;
import java.util.List;

public interface ProjectResourceService {
	List<ProjectResource> getAllProjectResource(Integer pid);
}