package com.portfolio.blog.api.model;

public class ProjectDTO {
    private int id;
    private String name;
    private String overview;
    private String category;
    private String[] technologies;
    private String imageUrl;

    public ProjectDTO(){}

    public ProjectDTO(String name, String overview){
        this.name = name;
        this.overview = overview;
    }

    public void setTechnologies(String[] technologies) {
        this.technologies = technologies;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getOverview() {
        return overview;
    }

    public String[] getTechnologies() {
        return technologies;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
