package com.korera.main.DTO;


import com.korera.main.Entity.Resource;

import java.io.Serializable;
import java.util.List;

public class ProjectDTO implements Serializable{

        private int projectId;
        private String projectName;


        public ProjectDTO() {}
        public int getProjectID() {
            return projectId;
        }

        public void setProjectId(int projectID) {
            this.projectId = projectID;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

}
