package com.portfolio.blog.api.controller;

import com.portfolio.blog.api.model.ProjectDTO;
import com.portfolio.blog.api.service.IProjectService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@Validated
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
    ResponseEntity<ProjectDTO> saveNewProject(@RequestBody @Valid @NotEmpty ProjectDTO dto){
        ProjectDTO newDto = projectService.saveProject(dto);
        return ResponseEntity.ok(newDto);
    }
}
