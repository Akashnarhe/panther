package com.example.services;

import java.util.List;

import com.example.tos.WorkTo;

public interface WorkService {
	public WorkTo getWork(int id);
	public List<WorkTo> getAllWork();
}
