package com.example.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
