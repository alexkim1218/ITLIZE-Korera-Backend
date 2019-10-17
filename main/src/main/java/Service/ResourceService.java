package Service;

import Entity.Resource;

import java.util.List;

public interface ResourceService {

    List<Resource> getAllResources();

    void editResourceByRid(int rid,Resource resource);
}
