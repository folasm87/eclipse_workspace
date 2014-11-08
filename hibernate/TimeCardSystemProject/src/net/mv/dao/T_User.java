package net.mv.dao;

import java.util.Set;

import javax.persistence.*;

//tell the compiler that this can be persisted
@Entity 
public class T_User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="T_USER_ID")
	private long T_USER_ID;
	
	@Column(name="T_USERNAME")
	private String T_USERNAME;
	
	@Column(name="PASSWORD")
	private String PASSWORD;
	
	@Column(name="FNAME")
	private String FNAME;
	
	@Column(name="LNAME")
	private String LNAME;
	
	@Column(name="HOURS")
	private double HOURS;
	
	@Column(name="SUPER_USER")
	private String super_user;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="T_USER_ID")
	private Set<Timesheet> timesheets;
	
	
	public long getT_USER_ID() {
		return T_USER_ID;
	}
	public void setT_USER_ID(long t_USER_ID) {
		T_USER_ID = t_USER_ID;
	}
	public String getT_USERNAME() {
		return T_USERNAME;
	}
	public void setT_USERNAME(String t_USERNAME) {
		T_USERNAME = t_USERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getFNAME() {
		return FNAME;
	}
	public void setFNAME(String nAME) {
		FNAME = nAME;
	}
	public String getLNAME() {
		return LNAME;
	}
	public void setLNAME(String nAME) {
		LNAME = nAME;
	}
	public double getHOURS() {
		return HOURS;
	}
	public void setHOURS(double hOURS) {
		HOURS = hOURS;
	}
	
	
	public String getSuper_user() {
		return super_user;
	}
	public void setSuper_user(String super_user) {
		this.super_user = super_user;
	}
	public Set<Timesheet> getTimesheets() {
		return timesheets;
	}
	public void setTimesheets(Set<Timesheet> timesheets) {
		this.timesheets = timesheets;
	}
	@Override
	public String toString() {
		return "T_User [T_USER_ID=" + T_USER_ID + ", T_USERNAME=" + T_USERNAME
				+ ", PASSWORD=" + PASSWORD + ", FNAME=" + FNAME + ", LNAME="
				+ LNAME + ", HOURS=" + HOURS + ", super_user=" + super_user
				+ ", timesheets=" + timesheets + "]";
	}
	
	
	

	
	


	
	
	
	

	
	

}
