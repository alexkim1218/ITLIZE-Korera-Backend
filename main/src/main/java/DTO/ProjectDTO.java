package DTO;


import Entity.Resource;

import java.util.List;

public class ProjectDTO {


    public class Project {


        private int projectID;


        private String projectName;

        List<Resource> projectResourceList;


        public int getProjectID() {
            return projectID;
        }

        public void setProjectID(int projectID) {
            this.projectID = projectID;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public List<Resource> getProjectResourceList() {
            return projectResourceList;
        }

        public void setProjectResourceList(List<Resource> projectResourceList) {
            this.projectResourceList = projectResourceList;
        }


    }

}
