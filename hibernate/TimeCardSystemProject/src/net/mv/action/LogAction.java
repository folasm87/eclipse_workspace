package net.mv.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.dao.DAO;
import net.mv.dao.T_User;

import org.apache.struts.action.*;
import org.apache.struts.validator.DynaValidatorForm;

public class LogAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		DynaValidatorForm dform = (DynaValidatorForm) form;
		
		
		String month2 = dform.getString("month");
		final int month = Integer.parseInt(month2);
		
		String day2 = dform.getString("day");
		final int day = Integer.parseInt(day2);
		
		String year2 = dform.getString("year");
		final int year = Integer.parseInt(year2);
		
		String start_hour2 = dform.getString("start_hour");
		final int start_hour = Integer.parseInt(start_hour2);
		
		String start_min2 = dform.getString("start_min");
		final int start_min = Integer.parseInt(start_min2);
		
		String end_hour2 = dform.getString("end_hour");
		final int end_hour = Integer.parseInt(end_hour2);
		
		String end_min2 = dform.getString("end_min");
		final int end_min = Integer.parseInt(end_min2);
		
		
		HttpSession sess = req.getSession();
		final T_User user = (T_User) sess.getAttribute("user");
		
		System.out.println("Logging as " + user.getT_USERNAME());
		
		boolean inserted = DAO.insertTimesheet(month, day, year, start_hour, start_min, end_hour, end_min, user);
		
		/*
		//final String password = dform.getString("password");
		
		//DAO dao = new DAO();
		User user = DAO.retrieveUser(uname, password);
		
		if(user != null){
			
			if(user.isSuper_user()){
				return mapping.findForward("Login_Super");
			}
			return mapping.findForward("Login_Success");
		}
		
		*/
		
		if(user != null && inserted){
			System.out.println("Logged Your Hours AND User not null");
			if(user.getSuper_user().toLowerCase().equals("true")){
				return mapping.findForward("Log_Success_Super");
			}
			return mapping.findForward("Log_Success");
		}
		
		return mapping.findForward("Log_Failure");
		
		
		
		
		
	}

}
