package net.mv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.validation.constraints.DecimalMin;
//import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
//import org.hibernate.validator.constraints.Range;

@Entity
public class User {
	@Id
	@NotNull
	private String username;
	
	
	@Column
	@NotEmpty
	private String password;


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
