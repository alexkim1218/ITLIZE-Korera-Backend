package com.korera.main.Service.Impl;

import com.korera.main.DAO.ProjectResourceDAO;
import com.korera.main.Entity.ProjectResource;
import com.korera.main.Service.ProjectResourceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectResourceServiceImp implements ProjectResourceService {

	@Autowired
	private ProjectResourceDAO projectResourceDao;

	@Override
	public void deleteAllProjectResourceByPid(Integer pid) {
		List<ProjectResource> projectResourceList = getAllProjectResource(pid);
		if(projectResourceList != null){
			projectResourceDao.deleteAll(projectResourceList);
		}
	}

	@Override
	public List<ProjectResource> getAllProjectResource(Integer pid) {
		List<ProjectResource> projectResource = projectResourceDao.findByPid(pid);

		if (projectResource != null) {
			return projectResource;
		}
		return null;
	}

	@Override
	public ProjectResource addProjectResource(Integer pid, Integer rid){
		ProjectResource projectResource = new ProjectResource(pid, rid);
		return projectResourceDao.save(projectResource);
	}
}
