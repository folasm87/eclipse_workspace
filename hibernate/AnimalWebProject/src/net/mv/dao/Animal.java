package net.mv.dao;

import javax.persistence.*;

//tell the compiler that this can be persisted
@Entity 
public class Animal {
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STUD_ID")
	private long sid;
	
	*/
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ANIMAL_ID")
	private long ANIMAL_ID;
	@Column(name="NAME")
	private String NAME;
	@Column(name="DIET")
	private String DIET;
	@Column(name="AGE")
	private int AGE;
	@Column(name="OWNER")
	private String OWNER;
	@Column(name="LIMBS")
	private int LIMBS;
	@Column(name="TYPE")
	private String TYPE;
	
	
	public String getName() {
		return NAME;
	}
	public void setName(String name) {
		this.NAME = name;
	}
	public String getDiet() {
		return DIET;
	}
	public void setDiet(String diet) {
		this.DIET = diet;
	}
	public int getAge() {
		return AGE;
	}
	public void setAge(int age) {
		this.AGE = age;
	}
	public String getOwner() {
		return OWNER;
	}
	public void setOwner(String owner) {
		this.OWNER = owner;
	}
	public int getLimbs() {
		return LIMBS;
	}
	public void setLimbs(int appendages) {
		this.LIMBS = appendages;
	}
	public String getType() {
		return TYPE;
	}
	public void setType(String environment) {
		this.TYPE = environment;
	}
	
	public long getANIMAL_ID() {
		return ANIMAL_ID;
	}
	public void setANIMAL_ID(long aNIMAL_ID) {
		ANIMAL_ID = aNIMAL_ID;
	}
	@Override
	public String toString() {
		return "Animal [ANIMAL_ID=" + ANIMAL_ID + ", NAME=" + NAME + ", DIET="
				+ DIET + ", AGE=" + AGE + ", OWNER=" + OWNER + ", LIMBS="
				+ LIMBS + ", TYPE=" + TYPE + "]";
	}
	
	

	
	

}
