package com.portfolio.blog.api.service;

import com.portfolio.blog.api.model.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPostService {
    PostDTO getPostById(int id);
    Page<PostDTO> getAllPosts(Pageable pageable);
}
