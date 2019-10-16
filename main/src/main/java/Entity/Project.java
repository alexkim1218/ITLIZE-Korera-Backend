package Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int projectID;
	
	@Column
	private String projectName;
	
	@ManyToMany
	@JoinTable(
	  name = "Project_Resource", 
	  joinColumns = @JoinColumn(name = "pid"), 
	  inverseJoinColumns = @JoinColumn(name = "rid"))
	

	private String name;
	
	





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
	
	@Override
	public String toString() {
		return "Project Name: " + projectName;
	}
}
