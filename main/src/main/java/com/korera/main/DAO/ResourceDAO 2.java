package com.korera.main.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.korera.main.Entity.Resource;

public interface ResourceDAO extends JpaRepository<Resource, Integer> {

}
