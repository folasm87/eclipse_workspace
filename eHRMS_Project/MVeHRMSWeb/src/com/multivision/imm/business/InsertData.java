package com.multivision.imm.business;

import com.multivision.imm.service.data.ItemDataService;
import com.multivision.imm.service.data.interfaces.IItemDataService;

public class InsertData {

	public void createItem(String[] str) throws Exception {
		
		Item itm = new Item();
		IItemDataService ids = new ItemDataService();
		
		itm.setName(str[0]);
		itm.setCost(Double.parseDouble(str[1]));
		itm.setLevel("high");
		itm.setDescription(str[2]);
		itm.setCategory(str[3]);
		ids.insertItem(itm);
		
		
	}

}