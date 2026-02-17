package com.portfolio.blog.api.model;

import java.util.List;

public class PostDTO {

    private String title;
    private String content;
    private int id;
    private String author;

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public int getId(){ return id; }
    public String getAuthor(){ return author; }

    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setAuthor(String author){
        this.author = author;
    }

}
