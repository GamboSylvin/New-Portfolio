package com.portfolio.blog.api.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private String author;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Post(){}

    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Post(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }

    public String getAuthor(){
        return author;
    }

    public int getId(){ return id;}

    public LocalDateTime getCreatedAt(){ return createdAt;}
}
