package com.example.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Work;

public interface WorkRepository extends JpaRepository<Work, Integer> {

}
