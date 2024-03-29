package net.mv.dao;

//import java.util.Set;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long ID;
	
	@Column(name="USER_ID")
	private String user_id;
	
	
	@Column
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String role;
	private String email;
	private String phone;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ID")
	private Set<Project> projects;
	
	@ManyToOne
	@JoinColumn(name="contract", referencedColumnName="ID")
	private Contract contract;
	

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", user_id=" + user_id + ", username="
				+ username + ", password=" + password + ", fname=" + fname
				+ ", lname=" + lname + ", role=" + role + ", email=" + email
				+ ", phone=" + phone + ", projects=" + projects + ", contract="
				+ contract + "]";
	}

	

	

	
	
	
	
	
	
	

}
