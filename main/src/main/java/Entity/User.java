package Entity;


import org.springframework.data.annotation.Id;



import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.hibernate.annotations.NaturalId;
import org.springframework.context.support.BeanDefinitionDsl.Role;

public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long user_id;

	@NotBlank
	private String first_name;

	@NotBlank
	private String last_name;

	@NaturalId
	@NotBlank
	@Email
	private String email;

	@NotBlank
	private String password;

	// TODO: CREATE MANY-TO-MANY TABLE

	public User() {}

	public User (String first_name, String last_name, String email, String password) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}

	public Long getId () {
		return user_id;
	}

	public void setId (Long ser_id) {
		this.user_id = ser_id;
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

	public String getEmail () {
		return email;
	}

	public void setEmail (String email) {
		this.email = email;
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
