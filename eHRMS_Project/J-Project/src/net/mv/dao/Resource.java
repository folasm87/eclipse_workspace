package net.mv.dao;


import javax.persistence.*;

@Entity
@Table(name="Resource")
public class Resource {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long ID;
	
	@Column(name="RESOURCE_ID")
	private String resource_id;
	
	
	@Column
	private String name;
	private double cost;
	
	@ManyToOne
	@JoinColumn(name="project", referencedColumnName="ID")
	private Project project;// = new Project();

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
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

	@Override
	public String toString() {
		return "Resource [ID=" + ID + ", resource_id=" + resource_id
				+ ", name=" + name + ", cost=" + cost + ", project=" + project
				+ "]";
	}
	
	

}