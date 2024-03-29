package com.multivision.ehrms.business;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Resources")
public class Resource implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="resource_id")
	private String resourceId;
	
	@Column
	private String name;
	
	@Column
	private double cost;
	

	
	@ManyToOne
	@JoinColumn(name="project", referencedColumnName="id")
	private Project project;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getResourceId() {
		return resourceId;
	}


	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}




	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}



	
	

}
