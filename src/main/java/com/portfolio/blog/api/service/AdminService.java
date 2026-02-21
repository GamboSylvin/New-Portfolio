package com.portfolio.blog.api.service;

import com.portfolio.blog.api.Exceptions.ResourceNotFoundException;
import com.portfolio.blog.api.model.Post;
import com.portfolio.blog.api.model.PostDTO;
import com.portfolio.blog.api.model.PostMapper;
import com.portfolio.blog.api.model.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class AdminService implements IAdminService{

    private final PostRepository postRepository;

    public AdminService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @Transactional
    public PostDTO addPost(PostDTO dto){
        Post post = PostMapper.toPost(dto);
        post = postRepository.save(post);
        return PostMapper.toDTO(post);
    }

    @Transactional
    public List<PostDTO> addAllPosts(List<PostDTO> DTOs){
        List<Post> posts = DTOs
                .stream()
                .map(PostMapper::toPost)
                .toList();
        posts = postRepository.saveAll(posts);
        return posts
                .stream()
                .map(PostMapper::toDTO)
                .toList();
    }

    @Transactional
    public PostDTO deletePost(int id){
        Post post = postRepository.findById(id).orElse(new Post("Default post","No content"));
        if(post.getTitle().equals("Default post"))
            throw new ResourceNotFoundException("The post with id "+ id + " was not found");
        postRepository.delete(post);
        return PostMapper.toDTO(post);
    }

    @Transactional
    public PostDTO updatePost(int id, PostDTO dto){
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("The post with id "+ id +" was not found"));
        post.setTitle(dto.getTitle());
        post.setAuthor(dto.getAuthor());
        post.setContent(dto.getContent());
        return PostMapper.toDTO(post);
    }

}
