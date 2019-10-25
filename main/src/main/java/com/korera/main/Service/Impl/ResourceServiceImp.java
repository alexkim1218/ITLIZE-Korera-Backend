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
	private ResourceDAO resourceDAO;
	
	@Override
	public List<Resource> getAllResources() {
		// TODO Auto-generated method stub
		return resourceDAO.findAll();
	}

	@Override
	public void editResourceByRid(int rid, Resource resource) {
		// TODO Auto-generated method stub
		if(resourceDAO.getOne(rid) == null) {
			System.out.println("Resource with ID:" + rid + " not found.");
			return;
		}
		resource.setResourceId(rid);
		resourceDAO.save(resource);
		System.out.println("Resource with ID:" + rid + " updated.");
	}
	
	@Override
	public Resource getResourceById(int rid) {
		return resourceDAO.getOne(rid);
	}

	@Override
	public Resource addResource(Resource resource) {
		return resourceDAO.save(resource);
	}
	
	@Override
	public void deleteResource(Resource resource) {
		resourceDAO.delete(resource);
	}
	
	@Override
    public void deleteAllResource() {
		resourceDAO.deleteAll();
	}
	

}
