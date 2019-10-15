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
	private Long user_id;

	@NaturalId
	@NotBlank
	private String username;

	@NotBlank
	private String first_name;

	@NotBlank
	private String last_name;

	@NotBlank
	private String password;

	// TODO: CREATE MANY-TO-MANY TABLE

	public User() {}

	public User (String username, String first_name, String last_name, String password) {
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
	}

	public Long getId () {
		return user_id;
	}

	public void setId (Long ser_id) {
		this.user_id = ser_id;
	}

	public String getUsername () {
		return username;
	}

	public void setUsername (String username) {
		this.username = username;
	}

	public String getFirst_name () {
		return first_name;
	}

	public void setFirst_name (String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name () {
		return last_name;
	}

	public void setLast_name (String last_name) {
		this.last_name = last_name;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		// TODO: CHANGE RETURN VALUE AFTER CREATING TABLE
		return null;
		// return roles;
	}

	public void setRoles(Set<Role> roles) {
		// TODO: ADD RETURN VALUE AFTER CREATING TABLE
		// this.roles = roles;
	}
}
