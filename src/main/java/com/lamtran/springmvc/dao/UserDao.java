package com.lamtran.springmvc.dao;

import java.util.List;

import com.lamtran.springmvc.model.User;

public interface UserDao {

	User getById(int id);
	
	User getUserByUsername(String username);
	
	List<User> getAll();
	
	void deleteUserById(int id);
	

	void saveUser(User user);
}
