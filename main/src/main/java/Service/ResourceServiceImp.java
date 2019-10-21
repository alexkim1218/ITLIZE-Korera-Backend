package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.ResourceDAO;
import Entity.Resource;

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
		resource.setResourceID(rid);
		resourceDAO.save(resource);
		System.out.println("Resourse with ID:" + rid + " updated.");
	}

}
