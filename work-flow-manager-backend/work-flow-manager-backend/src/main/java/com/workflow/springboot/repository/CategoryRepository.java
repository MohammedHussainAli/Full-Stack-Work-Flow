package com.workflow.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workflow.springboot.model.Category;
import com.workflow.springboot.model.WorkFlow;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Integer> {

	Category findByCategoryName(String category);
     
//	public Category getByCategoryName(Category wf);
}
