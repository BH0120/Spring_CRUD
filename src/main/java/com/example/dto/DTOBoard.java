package com.example.dto;


import com.example.entity.EntityBoard;

public class DTOBoard {

    public String Title;
    public String Author;
    public String Content;
    public String Date;

    public DTOBoard(String title, String author,  String content, String date){
        super();
        Title = title;
        Author = author;
        Content = content;
        Date = date;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public EntityBoard ToEntity(){
        return new EntityBoard(-1, Title, Author, Content, Date);
    }

    @Override
    public String toString() {
        return "DTOBoard {" +
                "Title='" + Title + '\'' +
                ", Author=" + Author + '\'' +
                ", Content=" + Content + '\'' +
                ", Date=" + Date + '\'' +
                '}';
    }
}
