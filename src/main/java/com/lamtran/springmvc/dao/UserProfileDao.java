package com.lamtran.springmvc.dao;

import java.util.List;

import com.lamtran.springmvc.model.UserProfile;

public interface UserProfileDao {

	UserProfile getById(int id);
	
	List<UserProfile> getAll();
	
	void deleteUserProfileById(int id);
	

	void saveUserProfile(UserProfile userProfile);
}
