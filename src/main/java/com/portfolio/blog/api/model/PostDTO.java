package com.portfolio.blog.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

public class PostDTO {
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String content;
    private int id;
    private String author;
    private LocalDateTime createdAt;
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public int getId(){ return id; }
    public String getAuthor(){ return author; }
    public LocalDateTime getCreatedAt(){ return createdAt; }

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
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

}
