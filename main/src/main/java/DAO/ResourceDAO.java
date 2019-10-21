package DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Resource;

public interface ResourceDAO extends JpaRepository<Resource, Integer>{

}
