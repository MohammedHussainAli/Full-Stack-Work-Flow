package com.workflow.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkFlow {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id;
	   private String category;
	   private String workFlowName;
	   private String workFlowDescription;
	   private String workFlowStatus;
	   
	

	public WorkFlow(int id, String category, String workFlowName, String workFlowDescription, String workFlowStatus) {
		super();
		this.id = id;
		this.category = category;
		this.workFlowName = workFlowName;
		this.workFlowDescription = workFlowDescription;
		this.workFlowStatus = workFlowStatus;
	}

	
	public WorkFlow() {
		super();
	}


	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWorkFlowName() {
		return workFlowName;
	}

	public void setWorkFlowName(String workFlowName) {
		this.workFlowName = workFlowName;
	}

	public String getWorkFlowDescription() {
		return workFlowDescription;
	}

	public void setWorkFlowDescription(String workFlowDescription) {
		this.workFlowDescription = workFlowDescription;
	}

	public String getWorkFlowStatus() {
		return workFlowStatus;
	}

	public void setWorkFlowStatus(String workFlowStatus) {
		this.workFlowStatus = workFlowStatus;
	}
}
