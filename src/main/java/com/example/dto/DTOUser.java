package com.example.dto;

import com.example.entity.EntityUser;

public class DTOUser {

    public String UserName;
    public String UserAge;

    public DTOUser(){
        UserName = UserAge = "";
    };

    public DTOUser(String userName, String userAge) {
        super();
        UserName = userName;
        UserAge = userAge;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserAge() {
        return UserAge;
    }

    public void setUserAge(String userAge) {
        UserAge = userAge;
    }

    public EntityUser ToEntity(){
        return new EntityUser(-1, this.UserName, this.UserAge);
    }

    @Override
    public String toString() {
        return "DTOUser{" +
                "UserName='" + UserName + '\'' +
                ", UserAge='" + UserAge + '\'' +
                '}';
    }
}
