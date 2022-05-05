package com.workflow.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workflow.springboot.model.WorkFlow;

@Repository
public interface WorkFlowRepository extends JpaRepository <WorkFlow, Integer> {

	public List<WorkFlow> findByCategory(String category);
	public void deleteByCategory(String category);
}
