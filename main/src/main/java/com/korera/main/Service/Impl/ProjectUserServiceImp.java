package com.korera.main.Service.Impl;

import com.korera.main.DAO.ProjectUserDAO;

import com.korera.main.Entity.ProjectUser;
import com.korera.main.Service.ProjectUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectUserServiceImp implements ProjectUserService {

	@Autowired
	private ProjectUserDAO projectUserDao;

	@Override
	public List<ProjectUser> getAllProjectUser(Integer uid) {
		List<ProjectUser> projectUser = projectUserDao.findByUid(uid);

		if (projectUser != null) {
			return projectUser;
		}
		return null;
	}
}
