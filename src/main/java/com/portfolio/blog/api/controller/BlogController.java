package com.portfolio.blog.api.controller;

import com.portfolio.blog.api.model.PostDTO;
import com.portfolio.blog.api.service.IPostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {

    private final IPostService postService;

    BlogController(IPostService postService){
        this.postService = postService;
    }

    @GetMapping("/api/post")
    public PostDTO singlePost(@RequestParam int id){
        return postService.getPostById(id);
    }

    @GetMapping("api/posts")
    public Page<PostDTO> allPosts(Pageable pageable){
        return postService.getAllPosts(pageable);
    }
}
