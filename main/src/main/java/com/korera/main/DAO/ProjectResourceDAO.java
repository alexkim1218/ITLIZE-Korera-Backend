package com.korera.main.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.korera.main.Entity.ProjectResource;
import com.korera.main.Entity.ProjectUser;

public interface ProjectResourceDAO extends JpaRepository<ProjectResource, Integer> {
	public List<ProjectResource> findByPid(int pid);
}
