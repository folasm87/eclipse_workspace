package com.multivision.ehrms.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Update: Added JPA(JSR 317) support for Hibernate to get rid of HBM files.
 * @version 2.0
 * @author Zubair Shaikh
 */

@Entity
@Table(name="Role_Menu_Access")
public class RoleMenuAccess implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 62734509232l;

	/** The code. */
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	@JoinColumn(name="system_id", referencedColumnName="id")
	private SystemRole systemRole = new SystemRole();
	
	@ManyToOne
	@JoinColumn(name="subMenu_id", referencedColumnName="id")
	private SubMenuManagement subMenuManagement = new SubMenuManagement();
	@Transient
	private ParentMenuManagement parentMenuManagement = new ParentMenuManagement();

	public ParentMenuManagement getParentMenuManagement() {
		return parentMenuManagement;
	}

	public void setParentMenuManagement(
			ParentMenuManagement parentMenuManagement) {
		this.parentMenuManagement = parentMenuManagement;
	}
	@Transient
	private char accessType = 'W';

	public char getAccessType() {
		return accessType;
	}

	public void setAccessType(char accessType) {
		this.accessType = accessType;
	}

	public SystemRole getSystemRole() {
		return systemRole;
	}

	public void setSystemRole(SystemRole systemRole) {
		this.systemRole = systemRole;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SubMenuManagement getSubMenuManagement() {
		return subMenuManagement;
	}

	public void setSubMenuManagement(SubMenuManagement subMenuManagement) {
		this.subMenuManagement = subMenuManagement;
	}

}
