package com.portfolio.blog.api.service;

import com.portfolio.blog.api.model.Project;
import com.portfolio.blog.api.model.ProjectDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IProjectService {
    Page<ProjectDTO> getProjects (Pageable pageable);
    ProjectDTO saveProject(ProjectDTO dto);
}
