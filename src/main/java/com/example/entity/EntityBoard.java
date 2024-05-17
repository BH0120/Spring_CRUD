package com.example.entity;

import jakarta.persistence.*;

@Entity
public class EntityBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    int id;
    @Column
    String title;

    @Column
    String content;

    @Column
    String userId;



    public EntityBoard(){}

    public EntityBoard(int id, String title, String content, String userId) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
