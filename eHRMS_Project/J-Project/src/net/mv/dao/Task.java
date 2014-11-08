package net.mv.dao;


import javax.persistence.*;

@Entity
@Table(name="Task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long ID;
	
	@Column(name="TASK_ID")
	private String task_id;
	
	
	@Column
	private String name;
	private double duration;
	
	@ManyToOne
	@JoinColumn(name="project", referencedColumnName="ID")
	private Project project;// = new Project();

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Task [ID=" + ID + ", task_id=" + task_id + ", name=" + name
				+ ", duration=" + duration + ", project=" + project + "]";
	}
	
	

}