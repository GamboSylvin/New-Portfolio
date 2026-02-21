package com.portfolio.blog.api.model;

public class PostMapper {
    public static PostDTO toDTO(Post post){
        if(post == null)
            throw new NullPointerException("Invalid value for a post");
        PostDTO DTO = new PostDTO();
        DTO.setTitle(post.getTitle());
        DTO.setContent(post.getContent());
        DTO.setId(post.getId());
        DTO.setAuthor(post.getAuthor());
        DTO.setCreatedAt(post.getCreatedAt());

        return DTO;
    }

    public static Post toPost(PostDTO dto){
        if(dto == null)
            throw new NullPointerException("Invalid value for a postDTO");
        Post post = new Post(dto.getTitle(), dto.getContent());
        post.setAuthor(dto.getAuthor());

        return post;
    }
}
