package Service;

import DTO.ProjectDTO;
import Entity.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
      ProjectDTO getDefaultProjectByUserID(Integer userId);

      Page<Resource> getResourcesbyPid(Integer pId, Pageable pageable);
      List<Resource>  setResouresbyPid(Integer pId);

      List<ProjectDTO> getProjectsByUid(Integer uId);

      void addColumn (Integer pId, String colName, String colType);



}
