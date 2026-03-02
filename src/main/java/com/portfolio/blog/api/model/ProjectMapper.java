package com.portfolio.blog.api.model;

public class ProjectMapper {
    public static ProjectDTO toDto(Project project){
        ProjectDTO dto = new ProjectDTO(project.getName(), project.getOverview(), project.getLink());
        dto.setCategory(project.getCategory());
        dto.setId(project.getId());
        dto.setTechnologies(project.getTechnologies());
        dto.setImageUrl(project.getImageUrl());
        return dto;
    }
    public static Project toProject(ProjectDTO dto){
        Project project = new Project(dto.getName(), dto.getOverview(), dto.getLink());
        project.setCategory(dto.getCategory());
        project.setImageUrl(dto.getImageUrl());
        project.setTechnologies(dto.getTechnologies());
        return project;
    }
}
