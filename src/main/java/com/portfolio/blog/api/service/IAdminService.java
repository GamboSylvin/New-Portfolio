package com.portfolio.blog.api.service;

import com.portfolio.blog.api.model.PostDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public interface IAdminService {
    PostDTO addPost(@NotNull @Valid PostDTO dto);
    List<PostDTO> addAllPosts (@Valid @NotEmpty List<PostDTO> DTOs);
    PostDTO deletePost(@NotNull @Min(1) int id);
    PostDTO updatePost(@NotNull @Min(1) int id, @NotNull @Valid PostDTO dto);
}
