package com.portfolio.blog.api.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class PostDTO {
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String content;
    private int id;
    private String author;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createdAt;
    private String imageUrl;

    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public int getId(){ return id; }
    public String getAuthor(){ return author; }
    public LocalDateTime getCreatedAt(){ return createdAt; }

    public String getImageUrl() {
        return imageUrl;
    }

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

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
