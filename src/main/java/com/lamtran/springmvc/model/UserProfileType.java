package com.lamtran.springmvc.model;
 
import java.io.Serializable;
 
public enum UserProfileType implements Serializable{
    MANAGER("MANAGER"),
    STAFF("STAFF");
     
    String userProfileType;
     
    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType(){
        return userProfileType;
    }
     
}