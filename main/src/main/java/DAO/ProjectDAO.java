package DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Project;

public interface ProjectDAO extends JpaRepository<Project,Integer>{
                
}
