package com.korera.main.Service;

import com.korera.main.DTO.ProjectDTO;
import com.korera.main.Entity.Project;
import com.korera.main.Entity.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
      ProjectDTO getDefaultProjectByUserID(Integer userId);

      Page<Resource> getResourcesbyPid(Integer pid, Pageable pageable);
      void setResouresbyPid(Integer pid, List<Resource> listResource );

      Page<ProjectDTO> getProjectsByUid(Integer uId,Pageable pageable);

      void addColumn (Integer pId, String colName, String colType);

      void addRow(Integer pId, Resource resource);

      Project getProjectByPid(Integer pid);

}
