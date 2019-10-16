package Service;

import DTO.ProjectDTO;
import Entity.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {
      ProjectDTO getDefaultProjectByUserID(Integer userId);

      Page<Resource> getResourcesbyPid(Integer pid, Pageable pageable);
      void setResouresbyPid(Integer pid, List<Resource> listResource );

      Page<ProjectDTO> getProjectsByUid(Integer uId,Pageable pageable);

      void addColumn (Integer pId, String colName, String colType);

      void addRow(Integer pId, Resource resource);



}
