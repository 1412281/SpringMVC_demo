package com.lamtran.springmvc.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lamtran.springmvc.model.UserProfile;

@Repository("userProfilesDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao{

	
	public void deleteUserProfileById(int id) {
		Query query = getSession().createSQLQuery("delete from user_profile where proId = :id");
        query.setString("id", String.valueOf(id));
        query.executeUpdate();
	}


	public UserProfile getById(int id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<UserProfile> getAll() {
		Criteria criteria = createEntityCriteria();
        return (List<UserProfile>) criteria.list();
		
	}


	public void saveUserProfile(UserProfile userProfile) {
		persist(userProfile);
	}



	
}
