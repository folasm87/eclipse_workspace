package com.multivision.ehrms.business;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="Tasks")
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	private long id;
	@Column(name="task_id")
	private String taskId;
	
	@Column
	private String name;
	
	@Column(name="estimated_hours")
	private String estimatedHours;
	
	@ManyToOne
	@JoinColumn(name="project", referencedColumnName="id")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="task_handler", referencedColumnName="id")
	private Employee taskHandler;




	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(String estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public Employee getTaskHandler() {
		return taskHandler;
	}

	public void setTaskHandler(Employee taskHandler) {
		this.taskHandler = taskHandler;
	}

	
	
	


	
	
	
	
	
}
