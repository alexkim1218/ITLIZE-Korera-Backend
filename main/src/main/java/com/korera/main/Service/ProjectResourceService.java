package com.korera.main.Service;

import com.korera.main.Entity.ProjectResource;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ProjectResourceService {
	List<ProjectResource> getAllProjectResource(Integer pid);

	ProjectResource addProjectResource(Integer pid, Integer rid);

	void deleteAllProjectResourceByPid(Integer pid);
}