package com.korera.main.DTO;


import com.korera.main.Entity.Project;
import com.korera.main.Entity.Resource;

import java.util.List;
import java.util.Set;

public class ProjectDTO {





        private Integer projectId;

        private String projectName;

        private List<Project> projectList;







        public int getProjectID() {
            return projectId;
        }

        public void setProjectID(int projectID) {
            this.projectId = projectID;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }



}
