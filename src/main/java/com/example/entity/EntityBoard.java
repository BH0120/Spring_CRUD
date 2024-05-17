package com.example.entity;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpSession;

@Entity
public class EntityBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idx;

    @Column
    String title;

    @Column
    String author;

    @Column
    String userId;

    @Column
    String content;

    @Column
    String date;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public EntityBoard() {
        this.idx = -1;
        this.title = "";
        this.author = "";
        this.content = "";
        this.date = "";
    }
    public EntityBoard(int idx,String title,String author,String content,String date) {
        super();
        this.idx = idx;
        this.title = title;
        this.author = author;
        this.content = content;
        this.date = date;
    }

    @Override
    public String toString() {
        return "EntityBoard {" +
                "idx='" + idx +
                ", title='" + title + '\'' +
                ", author='" + author +'\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
