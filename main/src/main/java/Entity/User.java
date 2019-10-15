package Entity;

import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.NaturalId;
import org.springframework.context.support.BeanDefinitionDsl.Role;

public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long userID;

	@NaturalId
	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	private String name;

	// TODO: CREATE MANY-TO-MANY TABLE

	public User() {}

	public User (String username, String password, String name) {
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public Long getID () {
		return userID;
	}

	public String getUsername () {
		return username;
	}

	public String getPassword () {
		return password;
	}

	public String getName () {
		return name;
	}

	public Set<Role> getTitle() {
		// TODO: CHANGE RETURN VALUE AFTER CREATING TABLE
		return null;
		// return roles;
	}
}
