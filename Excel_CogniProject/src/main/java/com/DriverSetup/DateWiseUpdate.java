package com.DriverSetup;

import java.util.Date;


//To get the date and add as the current date to the screenshots taken
public class DateWiseUpdate {
		public static String getTimeStamp()
		{
			Date date = new Date();
			return (date.toString().replaceAll(":","_").replaceAll(" ", "_"));
		}
}
