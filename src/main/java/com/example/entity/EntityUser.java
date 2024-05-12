package com.example.entity;

import jakarta.persistence.*;

@Entity
public class EntityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column
    String username;

    @Column
    String userage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        username = userName;
    }

    public String getUserAge() {
        return userage;
    }

    public void setUserAge(String userAge) {
        userage = userAge;
    }

    public EntityUser(){
        this.id = -1;
        this.username = "";
        this.userage = "";
    }

    public EntityUser(int id , String UserName , String UserAge) {
        super();
        this.id = id;
        this.username = UserName;
        this.userage = UserAge;
    }

    @Override
    public String toString() {
        return "EntityUser{" +
                "UserName='" + username + '\'' +
                ", id=" + id +
                ", UserAge='" + userage + '\'' +
                '}';
    }
}
