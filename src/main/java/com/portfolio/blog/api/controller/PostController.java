package com.portfolio.blog.api.controller;

import com.portfolio.blog.api.model.PostDTO;
import com.portfolio.blog.api.service.IAdminService;
import com.portfolio.blog.api.service.IPostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class PostController {

    private final IPostService postService;
    private final IAdminService adminService;

    PostController(IPostService postService, IAdminService adminService){
        this.adminService = adminService;
        this.postService = postService;
    }

    @GetMapping("/api/post")
    public PostDTO getSinglePost(@RequestParam int id){
        return postService.getPostById(id);
    }

    @GetMapping("api/posts")
    public Page<PostDTO> allPosts(Pageable pageable){
        return postService.getAllPosts(pageable);
    }

    @PostMapping("api/post")
    public ResponseEntity<PostDTO> addSinglePost(@Valid @RequestBody PostDTO dto){
        PostDTO responseDTO = adminService.addPost(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseDTO);
    }

    @PostMapping("api/posts")
    public ResponseEntity<List<PostDTO>> addListOfPosts(@RequestBody @Valid @NotEmpty List<PostDTO> DTOs){
        List<PostDTO> responseDTOs = adminService.addAllPosts(DTOs);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(responseDTOs);
    }

    @DeleteMapping("api/post")
    public ResponseEntity<PostDTO> deleteSinglePost(@RequestParam @Min(1) int id){
        PostDTO dto = adminService.deletePost(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("api/post")
    public ResponseEntity<PostDTO> updateSinglePost(@RequestParam @Min(1) int id, @RequestBody PostDTO dto){
        PostDTO updatedDto = adminService.updatePost(id, dto);
        return ResponseEntity.ok(updatedDto);
    }

}
