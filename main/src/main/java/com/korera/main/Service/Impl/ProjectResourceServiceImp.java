package com.korera.main.Service.Impl;

import com.korera.main.DAO.ProjectResourceDAO;
import com.korera.main.Entity.ProjectResource;
import com.korera.main.Service.ProjectResourceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectResourceServiceImp implements ProjectResourceService {

	@Autowired
	private ProjectResourceDAO projectResourceDao;

	@Override
	public List<ProjectResource> getAllProjectResource(Integer pid) {
		List<ProjectResource> projectResource = projectResourceDao.findByPid(pid);

		if (projectResource != null) {
			return projectResource;
		}
		return null;
	}
}
