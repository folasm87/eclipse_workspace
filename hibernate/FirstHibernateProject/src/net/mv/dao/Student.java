package net.mv.dao;

import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//tell the compiler that this can be persisted
@Entity 
//let this be cached
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STUD_ID")
	private long sid;
	
	@Column(name="STUD_FIRSTNAME")
	private String fname;
	
	@Column(name="STUD_LASTNAME")
	private String lname;
	
	@Column(name="STUD_EMAIL")
	private String email;
	
	@Column(name="STUD_AGE")
	private int age;
	
	
	

	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", fname=" + fname + ", lname=" + lname
				+ ", email=" + email + ", age=" + age + "]";
	}

}
