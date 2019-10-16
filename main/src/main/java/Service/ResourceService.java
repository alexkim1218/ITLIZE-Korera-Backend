package Service;

import Entity.Resource;
import org.springframework.data.domain.Page;

public interface ResourceService {

    Page<Resource> getAllResources();

    void editResourceByRid(int rid,Resource resource);
}
