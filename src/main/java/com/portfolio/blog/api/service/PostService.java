package com.portfolio.blog.api.service;

import com.portfolio.blog.api.model.Post;
import com.portfolio.blog.api.model.PostDTO;
import com.portfolio.blog.api.model.PostMapper;
import com.portfolio.blog.api.model.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostDTO getPostById(int id){
        return PostMapper.convertToDTO(postRepository.findById(id).orElse(new Post("default post","Lorem Ipsum")));
    }

    public Page<PostDTO> getAllPosts(Pageable pageable){
        return postRepository.findAll(pageable)
                .map(PostMapper::convertToDTO);
    }
}
