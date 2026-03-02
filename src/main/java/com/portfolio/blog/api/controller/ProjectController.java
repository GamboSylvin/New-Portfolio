package com.portfolio.blog.api.controller;

import com.portfolio.blog.api.model.ProjectDTO;
import com.portfolio.blog.api.service.IProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    private final IProjectService projectService;

    ProjectController(IProjectService projectService){
        this.projectService = projectService;
    }
    @GetMapping("api/projects")
    Page<ProjectDTO> getAllProjects(Pageable pageable){
        return projectService.getProjects(pageable);
    }

    @PostMapping("api/project")
    ResponseEntity<ProjectDTO> saveNewProject(@RequestBody ProjectDTO dto){
        ProjectDTO newDto = projectService.saveProject(dto);
        return ResponseEntity.ok(newDto);
    }
}
