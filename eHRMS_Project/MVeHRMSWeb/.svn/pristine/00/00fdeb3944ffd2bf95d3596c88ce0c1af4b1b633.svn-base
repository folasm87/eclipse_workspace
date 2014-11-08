package com.multivision.imm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.multivision.imm.action.form.AddNewItemForm;
import com.multivision.imm.business.BusDelegate;
import com.multivision.imm.business.interfaces.IBusDelegate;

public class AddNewItemAction extends Action {

	BusDelegate bd;
	
	public void setBusinessdel(BusDelegate bd){
		
		this.bd = bd;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		AddNewItemForm addNewItemForm = (AddNewItemForm) form;
		String itemName = addNewItemForm.getItemName();
		String itemCost = addNewItemForm.getItemCost();
		String itemDescription = addNewItemForm.getItemDescription();
		String itemCategory = addNewItemForm.getItemCategory();
		
		String[] itemData = {itemName, itemCost, itemDescription, itemCategory};
		
		IBusDelegate bd = new BusDelegate();
		
		try {
			bd.addItem(itemData);
			return mapping.findForward("success");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ERROR - ITEM NOT ADDED TO THE DATABASE");
			return mapping.getInputForward();
		}
		
		
		
		
		
	}
	
	
}
