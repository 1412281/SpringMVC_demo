package com.lamtran.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamtran.springmvc.dao.UserDao;
import com.lamtran.springmvc.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public void saveUser(User user) {
		dao.saveUser(user);
	}

	@Override
	public User getById(int id) {
		return dao.getById(id);
	}
	@Override
	public List<User> getAllUser() {
		return dao.getAll();
		
	}
	@Override
	public void updateUser(User user) {
		User pro = dao.getById(user.getId());
		if (pro != null) {
			pro.setUsername(user.getUsername());
			pro.setPassword(user.getPassword());
			pro.setFullname(user.getFullname());
			pro.setEmail(user.getEmail());			
		}
		
	}
	@Override
	public void deleteUserById(int id) {
		dao.deleteUserById(id);
	}

	@Override
	public User getByUsername(String username) {
		return dao.getUserByUsername(username);
	}
	
	@Override
	public boolean isUsernameUnique(String username) {
		User user = getByUsername(username);
		if (user != null)
			return false;
		return true;
	}

	
}
