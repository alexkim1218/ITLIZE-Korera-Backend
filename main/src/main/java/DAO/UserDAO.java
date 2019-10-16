package DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	
	public User findByUserName(String userName);
}
