package com.korera.main.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.korera.main.Entity.ProjectUser;

public interface ProjectUserDAO extends JpaRepository<ProjectUser, Integer> {
	public List<ProjectUser> findByUid(int uid);
}
