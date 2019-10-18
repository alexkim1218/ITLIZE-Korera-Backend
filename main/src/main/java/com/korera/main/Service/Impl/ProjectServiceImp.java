package com.korera.main.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.korera.main.DAO.ProjectDAO;
import com.korera.main.DTO.ProjectDTO;
import com.korera.main.Entity.Project;
import com.korera.main.Entity.Resource;
import com.korera.main.Service.ProjectService;

@Service
public class ProjectServiceImp implements ProjectService {
	
	@Autowired
	private ProjectDAO projectDao;
	
//	@Autowired
//	private ProjectResourceDAO projectResourceDao;
//	
//	@Autowired
//	private ProjectUserDAO projectUserDao;
//	
//	@Autowired
//	private ResourceDAO resourceDao;
	
	@Override
	public ProjectDTO getDefaultProjectByUserID(Integer userId) {
		
		
		return null;
	}

	@Override
	public Page<Resource> getResourcesbyPid(Integer pid, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setResouresbyPid(Integer pid, List<Resource> listResource) {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<ProjectDTO> getProjectsByUid(Integer uId, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addColumn(Integer pId, String colName, String colType) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRow(Integer pId, Resource resource) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Project getProjectByPid(Integer pid) {
		return projectDao.getOne(pid);
	}

}
