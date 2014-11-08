package net.mv.dao;

import javax.persistence.*;



@Entity
@Table(name="UserToProject")
public class UserToProject {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long ID;
	
	@ManyToOne
	@JoinColumn(name="user", referencedColumnName="ID")
	private User user;// = new User();
	@ManyToOne
	@JoinColumn(name="project", referencedColumnName="ID")
	private Project project;// = new Project();
	
	@Column
	private double chargedHours;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public double getChargedHours() {
		return chargedHours;
	}

	public void setChargedHours(double chargedHours) {
		this.chargedHours = chargedHours;
	}

	@Override
	public String toString() {
		return "UserToProject [ID=" + ID + ", user=" + user + ", project="
				+ project + ", chargedHours=" + chargedHours + "]";
	}

	
	

}
