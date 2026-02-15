package com.portfolio.blog.api.model;

public class PostMapper {
    public static PostDTO convertToDTO(Post post){
        PostDTO DTO = new PostDTO();
        DTO.setTitle(post.getTitle());
        DTO.setContent(post.getContent());

        return DTO;
    }
}
