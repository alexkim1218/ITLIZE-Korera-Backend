package Entity;

import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "User")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int userID;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String title;	

	@Column
	private Date regDate;	

	@ManyToMany (fetch = FetchType.LAZY)
	@JoinTable (name = "Project_User", 
	joinColumns = @JoinColumn (name = "userID"), 
	inverseJoinColumns = @JoinColumn (name = "projectID"))
	private List<Project> listProjects;

	public User (String username, String password, String firstName, String lastName, String title) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.title = title;
	}

	public int getID () {
		return userID;
	}

	public String getUsername () {
		return username;
	}

	public String getPassword () {
		return password;
	}

	public String getName () {
		return firstName + " " + lastName;
	}

	public String getTitle () {
		return title;
	}

	public Date getRegDate () {
		return regDate;
	}

	public List<Project> getProjects () {
		return listProjects;
	}
}
