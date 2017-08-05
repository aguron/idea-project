/**
 * 
 */
package cse110.crossfit.IDEAproject.Utilities;

import java.util.Date;

/**
 * @author Akin
 *
 */
public class DateDifference {
//	public static void main(String args[]){
//		 DateDifference difference = new DateDifference();
//		 }
//		 DateDifference() {
//		 Calendar cal1 = new GregorianCalendar();
//		 Calendar cal2 = new GregorianCalendar();
//
//		 cal1.set(2008, 8, 1); 
//		 cal2.set(2008, 9, 31);
//		 System.out.println("Days= " + daysBetween(cal1.getTime(),cal2.getTime()));
//		 }
	
	public static long DAY_MILLISECONDS = 1000L * 60L * 60L * 24L;
	
	public static long setToStartOfDay(long timeMilliseconds) {
		return (timeMilliseconds / DAY_MILLISECONDS) * DAY_MILLISECONDS;
	}
	
	public static int daysBetween(Date d1, Date d2){
		int numDays = (int) ((d2.getTime() - d1.getTime()) / DAY_MILLISECONDS); 
		return ((numDays >= 0) ? numDays : -numDays);
	}
}
