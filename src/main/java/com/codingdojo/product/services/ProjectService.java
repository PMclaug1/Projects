package com.codingdojo.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.product.models.Project;
import com.codingdojo.product.models.User;
import com.codingdojo.product.repositories.ProjectRepository;

@Service
public class ProjectService {
	private final ProjectRepository projectRepo;
	
	public ProjectService(ProjectRepository projectRepo) {
		this.projectRepo = projectRepo;
	}
	
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
	
	public List<Project> getAssignedProjects(User user){
		return projectRepo.findAllByUsers(user);
	}
	
	public List<Project> getUnassignedProjects(User user){
		return projectRepo.findByUsersNotContains(user);
	}
	
	public Project addProject(Project project) {
		return projectRepo.save(project);
	}
	
	public void deleteProject(Project project) {
		projectRepo.delete(project);
	}
	
	public Project findById(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}else {
			return null;
		}
	}
	
}
