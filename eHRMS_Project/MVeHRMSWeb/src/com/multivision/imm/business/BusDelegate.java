package com.multivision.imm.business;

import com.multivision.imm.business.interfaces.IBusDelegate;
import com.multivision.imm.business.InsertData;

public class BusDelegate implements IBusDelegate {

	@Override
	public void addItem(String[] str) throws Exception {
		InsertData idt = new InsertData();
		idt.createItem(str);

	}

}
