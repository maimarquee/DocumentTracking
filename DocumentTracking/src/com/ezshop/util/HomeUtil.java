package com.ezshop.util;

public class HomeUtil {
	
	public String getMonthString(int currentMonth) {
		String monthString = "";
		switch(currentMonth) {
		case 1: monthString = "JANUARY";
		break;
		case 2: monthString = "FEBRUARY";
				break;
		case 3: monthString = "MARCH";
				break;
		case 4: monthString = "APRIL";
				break;
		case 5: monthString = "MAY";
				break;
		case 6: monthString = "JUNE";
				break;
		case 7: monthString = "JULY";
				break;
		case 8: monthString = "AUGUST";
				break;
		case 9: monthString = "SEPTEMBER";
				break;
		case 10: monthString = "OCTOBER";
				break;
		case 11: monthString = "NOVEMBER";
				break;
		case 12: monthString = "DECEMBER";
		}
		return monthString;
	}

}
