package com.multivision.ehrms.business;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Update: Added JPA(JSR 317) support for Hibernate to get rid of HBM files.
 * @version 2.0
 * @author Zubair Shaikh
 */

@Entity
@Table(name="Seed_Parent_Menu_Management")
public class ParentMenuManagement implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 62734509232l;

	/** The code. */
	@Id
	@GeneratedValue
	private int id;

	/** The name. */
	@Column(name="pname")
	private String name = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
