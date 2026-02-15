package com.portfolio.blog.api.service;

import com.portfolio.blog.api.model.PostDTO;

import java.util.List;

public interface IPostService {
    PostDTO getPostById(int id);
    List<PostDTO> getAllPosts();
}
