package com.lamtran.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lamtran.springmvc.dao.UserProfileDao;
import com.lamtran.springmvc.model.UserProfile;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private UserProfileDao dao;
	

	public void saveUserProfile(UserProfile userProfile) {
		dao.saveUserProfile(userProfile);
	}


	public UserProfile getUserProfileById(int id) {
		return dao.getById(id);
	}

	public List<UserProfile> getAllUserProfile() {
		return dao.getAll();
		
	}

	public void updateUserProfile(UserProfile userProfile) {
		UserProfile pro = dao.getById(userProfile.getId());
		if (pro != null) {
			pro.setType(userProfile.getType());
		}
		
	}

	public void deleteUserProfileById(int id) {
		dao.deleteUserProfileById(id);
		
	}
	
}
