package net.mv.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.dao.Dao;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class InsertAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DynaActionForm dform  = (DynaActionForm) form;
		
		final String name = dform.getString("name");
		final String type = dform.getString("type");
		final String time = dform.getString("time");
		final String servings = dform.getString("servings");
		final String ingredients = dform.getString("ingredients");
		final String directions = dform.getString("directions");
		
		System.out.println(name + ", " + type + ", " + servings);
		
		Dao dao = new Dao();
		
		dao.insertRecord(name, type, time, servings, ingredients, directions);
		
		return mapping.findForward("insertSuccess");
	}
	

}
