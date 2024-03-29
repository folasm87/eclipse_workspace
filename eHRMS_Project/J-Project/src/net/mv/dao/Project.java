package net.mv.dao;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Project")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long ID;
	
	@Column(name="PROJ_ID")
	private String proj_id;
	
	
	@Column
	private String name;
	private String commissioner;
	private String desc;
	private String category;
	private String objective;
	private String issues;
	private double cost;
	private String startDate;
	private String endDate;
	private String duration;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID")
	private Set<Resource> resources;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID")
	private Set<Task> tasks;
	
	@ManyToOne
	@JoinColumn(name="contract", referencedColumnName="ID")
	private Contract contract; //= new Contract();
	
	@ManyToOne
	@JoinColumn(name="user", referencedColumnName="ID")
	private User user;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getProj_id() {
		return proj_id;
	}

	public void setProj_id(String proj_id) {
		this.proj_id = proj_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCommissioner() {
		return commissioner;
	}

	public void setCommissioner(String commissioner) {
		this.commissioner = commissioner;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getIssues() {
		return issues;
	}

	public void setIssues(String issues) {
		this.issues = issues;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Project [ID=" + ID + ", proj_id=" + proj_id + ", name=" + name
				+ ", commissioner=" + commissioner + ", desc=" + desc
				+ ", category=" + category + ", objective=" + objective
				+ ", issues=" + issues + ", cost=" + cost + ", startDate="
				+ startDate + ", endDate=" + endDate + ", duration=" + duration
				+ ", resources=" + resources + ", tasks=" + tasks
				+ ", contract=" + contract + ", user=" + user + "]";
	}

	
	
	
	

}
