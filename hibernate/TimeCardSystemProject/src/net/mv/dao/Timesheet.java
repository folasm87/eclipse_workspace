package net.mv.dao;


import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

@Entity
public class Timesheet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOG_ID")
	private long LOG_ID;
	
	@Column(name="MONTH")
	private int MONTH;
	
	@Column(name="DAY")
	private int DAY;
	
	@Column(name="YEAR")
	private int YEAR;
	
	@Column(name="START_HOUR")
	private int START_HOUR;
	
	@Column(name="START_MIN")
	private int START_MIN;
	
	@Column(name="END_HOUR")
	private int END_HOUR;
	
	@Column(name="END_MIN")
	private int END_MIN;
	
	@ManyToOne
	@JoinColumn(name="T_USER_ID")
	private T_User user;

	public long getLOG_ID() {
		return LOG_ID;
	}

	public void setLOG_ID(long lOG_ID) {
		LOG_ID = lOG_ID;
	}

	public int getMONTH() {
		return MONTH;
	}

	public void setMONTH(int mONTH) {
		MONTH = mONTH;
	}

	public int getDAY() {
		return DAY;
	}

	public void setDAY(int dAY) {
		DAY = dAY;
	}

	public int getYEAR() {
		return YEAR;
	}

	public void setYEAR(int yEAR) {
		YEAR = yEAR;
	}

	public int getSTART_HOUR() {
		return START_HOUR;
	}

	public void setSTART_HOUR(int sTART_HOUR) {
		START_HOUR = sTART_HOUR;
	}

	public int getSTART_MIN() {
		return START_MIN;
	}

	public void setSTART_MIN(int sTART_MIN) {
		START_MIN = sTART_MIN;
	}

	public int getEND_HOUR() {
		return END_HOUR;
	}

	public void setEND_HOUR(int eND_HOUR) {
		END_HOUR = eND_HOUR;
	}

	public int getEND_MIN() {
		return END_MIN;
	}

	public void setEND_MIN(int eND_MIN) {
		END_MIN = eND_MIN;
	}

	public T_User getUser() {
		return user;
	}

	public void setUser(T_User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Timesheet [LOG_ID=" + LOG_ID + ", MONTH=" + MONTH + ", DAY="
				+ DAY + ", YEAR=" + YEAR + ", START_HOUR=" + START_HOUR
				+ ", START_MIN=" + START_MIN + ", END_HOUR=" + END_HOUR
				+ ", END_MIN=" + END_MIN + "]";
	}

	
	
	
	
	

}
