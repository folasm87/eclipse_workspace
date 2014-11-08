package com.multivision.imm.action.form;

import org.apache.struts.validator.ValidatorForm;

public class AddNewItemForm extends ValidatorForm {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1047861785111601233L;
	
	private String itemName;
	private String itemCost;
	private String itemDescription;
	private String itemCategory;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCost() {
		return itemCost;
	}
	public void setItemCost(String itemCost) {
		this.itemCost = itemCost;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	
	
	
	

}