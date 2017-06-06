package com.lamtran.springmvc.service;


import java.util.List;
 
import com.lamtran.springmvc.model.User;
 
 
public interface UserService {
     
    User getById(int id);
     
    User getByUsername(String username);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(int id);
 
    List<User> getAllUser(); 
     
    boolean isUsernameUnique(String username);
 
}