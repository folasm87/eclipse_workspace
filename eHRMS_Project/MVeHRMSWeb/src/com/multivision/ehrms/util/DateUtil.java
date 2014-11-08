package com.multivision.ehrms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertDate(String dateString) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		Date convertedDate = dateFormat.parse(dateString);
		return convertedDate;
	}

}
