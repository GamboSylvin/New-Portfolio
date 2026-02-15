package com.portfolio.blog.api.service;

import com.portfolio.blog.api.model.Post;
import com.portfolio.blog.api.model.PostDTO;
import com.portfolio.blog.api.model.PostMapper;
import com.portfolio.blog.api.model.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostDTO getfirstPost(){
        return PostMapper.convertToDTO(postRepository.findById(1).orElse(new Post("default post","Lorem Ipsum")));
    }

}
