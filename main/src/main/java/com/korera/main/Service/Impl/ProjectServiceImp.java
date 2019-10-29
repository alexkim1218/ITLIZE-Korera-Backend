package com.korera.main.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.korera.main.DAO.ProjectUserDAO;
import com.korera.main.Entity.ProjectUser;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.korera.main.DAO.ProjectDAO;
import com.korera.main.DAO.ProjectResourceDAO;
import com.korera.main.DAO.ResourceDAO;
import com.korera.main.DTO.ProjectDTO;
import com.korera.main.Entity.Project;
import com.korera.main.Entity.ProjectResource;
import com.korera.main.Entity.Resource;
import com.korera.main.Service.ProjectService;

@Service
public class ProjectServiceImp implements ProjectService {


	@Autowired
	ProjectDAO projectDAO;

	@Autowired
	ResourceDAO resourceDAO;

	@Autowired
	ProjectResourceDAO projectResourceDAO;

	@Autowired
	ProjectUserDAO projectUserDAO;


	@Override
	public ProjectDTO getDefaultProject(Integer uid) {
		List<ProjectDTO> projectDTOList = getProjectlistByUid(uid);
		ProjectDTO projectDTO = projectDTOList.get(0);
		return projectDTO;

	}

	@Override
	public List<ProjectDTO> getProjectlistByUid(Integer uid) {
		List<ProjectUser> projectUserList = projectUserDAO.findByUid(uid);
		List<ProjectDTO> projectList = new ArrayList<>();

		for (int i = 0; i < projectUserList.size(); i++) {


			ProjectUser projectUser = projectUserList.get(i);
			Integer pid = projectUser.getPid();
			Project project = getProjectByPid(pid);
			ProjectDTO projectDTO = new ProjectDTO();
			BeanUtils.copyProperties(project, projectDTO);


			projectList.add(projectDTO);
		}


		return projectList;
	}

	@Override
	public Project getProjectByPid(Integer pid) {
		return projectDAO.getOne(pid);
	}


	@Override
	public void addRow(Integer pId, Resource resource) {
		//add resource in the database
		resourceDAO.saveAndFlush(resource);

		//add ProjectResource with the newly created resource
		ProjectResource pr = new ProjectResource(pId, resource.getResourceId());
		projectResourceDAO.saveAndFlush(pr);

	}

	@Override
	public void addColumn(Integer pId, String colName, String colType) {
		// update the whole Project table (extraCols, extraColsType)
		// for type formula (formula-a + b) --> dash separated
		Project p = getProjectByPid(pId);

		String currCols = p.getExtraCols();
		String currColsType = p.getExtraColsType();

		boolean emptyExtraCols = false;
		if (currCols.length() == 0) {
			emptyExtraCols = true;
		}

		if (emptyExtraCols) {
			currCols = colName;
			currColsType = colType;
		} else {
			currCols += "," + colName;
			currColsType += "," + colType;
		}

		//update project database here
		p.setExtraCols(currCols);
		p.setExtraColsType(currColsType);
	}
}
