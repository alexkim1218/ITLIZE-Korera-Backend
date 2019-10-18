package com.korera.main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.korera.main.Entity.Project;

@Repository
public interface ProjectDAO extends JpaRepository<Project,Integer>{

}
