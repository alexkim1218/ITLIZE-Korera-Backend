package com.korera.main.Service;

import com.korera.main.Entity.ProjectUser;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ProjectUserService {
	List<ProjectUser> getAllProjectUser(Integer uid);
}