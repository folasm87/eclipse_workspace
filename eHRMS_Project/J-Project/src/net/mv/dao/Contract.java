package net.mv.dao;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Contract")
public class Contract {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long ID;
	
	@Column(name="CONTRACT_ID")
	private String contract_id;
	
	
	@Column
	private String name;
	private String client;
	private double funding;
	private double chargedHours;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID")
	private Set<Project> projects;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID")
	private Set<User> users;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public double getFunding() {
		return funding;
	}

	public void setFunding(double funding) {
		this.funding = funding;
	}

	public double getChargedHours() {
		return chargedHours;
	}

	public void setChargedHours(double chargedHours) {
		this.chargedHours = chargedHours;
	}

	/*@Override
	public String toString() {
		return "Contract [ID=" + ID + ", contract_id=" + contract_id
				+ ", name=" + name + ", client=" + client + ", funding="
				+ funding + ", chargedHours=" + chargedHours + "]";
	}*/
	
	

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}


	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Contract [ID=" + ID + ", contract_id=" + contract_id
				+ ", name=" + name + ", client=" + client + ", funding="
				+ funding + ", chargedHours=" + chargedHours + ", projects="
				+ projects + "]";
	}
	
	

}
