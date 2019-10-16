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
	
	@Column
	private String extraCols;
	
	@Column
	private String extraColsType;
	
	@ManyToMany
	@JoinTable(
	  name = "Project_Resource", 
	  joinColumns = @JoinColumn(name = "pid"), 
	  inverseJoinColumns = @JoinColumn(name = "rid"))
	private List<Resource> listResources;
 
	public int getProjectID() {
		return projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public boolean setProjectName(String projectName) {
		this.projectName = projectName;
		return true;
	}
	
	public String getExtraCols() {
		return extraCols;
	}

	public void setExtraCols(String extraCols) {
		this.extraCols = extraCols;
	}

	public String getExtraColsType() {
		return extraColsType;
	}

	public void setExtraColsType(String extraColsType) {
		this.extraColsType = extraColsType;
	}

	public List<Resource> getResources() {
		return listResources;
	}

	public void setResources(List<Resource> listResources) {
		this.listResources = listResources;
	}
	
	
	@Override
	public String toString() {
		return "Project Name: " + projectName;
	}
}
