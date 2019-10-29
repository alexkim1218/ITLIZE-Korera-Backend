package com.korera.main.Service;

import com.korera.main.DTO.ProjectDTO;
import com.korera.main.Entity.Project;
import com.korera.main.Entity.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ProjectService {
      ProjectDTO getDefaultProject(Integer uid);

      Project getProjectByPid(Integer pid);

      public List<ProjectDTO> getProjectlistByUid(Integer uid);



      void addColumn (Integer pId, String colName, String colType);

      void addRow(Integer pId, Resource resource);

}
