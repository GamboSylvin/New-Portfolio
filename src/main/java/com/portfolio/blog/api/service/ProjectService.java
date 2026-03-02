package com.portfolio.blog.api.service;

import com.portfolio.blog.api.model.Project;
import com.portfolio.blog.api.model.ProjectDTO;
import com.portfolio.blog.api.model.ProjectMapper;
import com.portfolio.blog.api.model.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IProjectService {
    private final ProjectRepository projectRepository;

    ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public Page<ProjectDTO> getProjects(Pageable pageable){
        Page<Project> projects = projectRepository.findAll(pageable);
        return projects.map(ProjectMapper::toDto);
    }

    @Override
    @Transactional
    public ProjectDTO saveProject(ProjectDTO dto) {
        Project project = ProjectMapper.toProject(dto);
        return ProjectMapper.toDto(projectRepository.save(project));
    }
}
