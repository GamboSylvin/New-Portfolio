package com.portfolio.blog.api.service;

import com.portfolio.blog.api.Exceptions.ResourceNotFoundException;
import com.portfolio.blog.api.model.Post;
import com.portfolio.blog.api.model.PostDTO;
import com.portfolio.blog.api.model.PostMapper;
import com.portfolio.blog.api.model.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PostService implements IPostService{
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public PostDTO getPostById(int id){
        if(!postRepository.existsById(id))
            throw new ResourceNotFoundException("The post with id: " + id +" is not found");
        return PostMapper.toDTO(postRepository.findById(id).orElse(new Post("default post","Lorem Ipsum")));
    }

    public Page<PostDTO> getAllPosts(Pageable pageable){
        return postRepository.findAll(pageable)
                .map(PostMapper::toDTO);
    }

}
