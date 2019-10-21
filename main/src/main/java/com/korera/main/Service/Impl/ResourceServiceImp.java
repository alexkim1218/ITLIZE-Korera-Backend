package com.korera.main.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.korera.main.DAO.ResourceDAO;
import com.korera.main.Entity.Resource;
import com.korera.main.Service.ResourceService;

@Service
public class ResourceServiceImp implements ResourceService {
	
	@Autowired
	ResourceDAO resourceDAO;
	
	@Override
	public List<Resource> getAllResources() {
		// TODO Auto-generated method stub
		return resourceDAO.findAll();
	}

	@Override
	public void editResourceByRid(int rid, Resource resource) {
		// TODO Auto-generated method stub
		if(resourceDAO.findById(rid).isEmpty()) {
			System.out.println("Resource with ID:" + rid + " not found.");
			return;
		}
		resource.setResourceId(rid);
		resourceDAO.save(resource);
		System.out.println("Resourse with ID:" + rid + " updated.");
	}

}
