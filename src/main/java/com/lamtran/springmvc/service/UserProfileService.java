package com.lamtran.springmvc.service;

import java.util.List;


import com.lamtran.springmvc.model.UserProfile;
/**
 *
 * @author LAMTRAN
 */
public interface UserProfileService {
	
    UserProfile getUserProfileById(int id);
    
    List<UserProfile> getAllUserProfile();
    
    void updateUserProfile(UserProfile userProfile);
    
    void saveUserProfile(UserProfile userProfile);
    
    void deleteUserProfileById(int id);
}
