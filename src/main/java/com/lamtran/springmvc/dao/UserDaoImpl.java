package com.lamtran.springmvc.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lamtran.springmvc.model.User;

@Repository("usersDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{
	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public void deleteUserById(int id) {
		Query query = getSession().createSQLQuery("delete from users where proId = :id");
        query.setString("id", String.valueOf(id));
        query.executeUpdate();
	}


	public User getById(int id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAll() {
		Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
		
	}


	public void saveUser(User user) {
		persist(user);
	}


	@Override
	public User getUserByUsername(String username) {
		logger.info("USERNAME : {}", username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        User user = (User)crit.uniqueResult();
        if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }
        return user;
	}



	
}
