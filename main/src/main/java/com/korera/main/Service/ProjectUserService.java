package com.korera.main.Service;

import com.korera.main.Entity.ProjectUser;
import java.util.List;

public interface ProjectUserService {
	List<ProjectUser> getAllProjectUser(Integer uid);
}