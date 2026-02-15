package com.portfolio.blog.api.controller;

import com.portfolio.blog.api.model.PostDTO;
import com.portfolio.blog.api.service.IPostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    private final IPostService postService;

    BlogController(IPostService postService){
        this.postService = postService;
    }

    @GetMapping("/api/posts")
    public PostDTO data(){
        return postService.getfirstPost();
    }
}
