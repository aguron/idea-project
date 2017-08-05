package cse110.crossfit.IDEAproject.Databases;

import android.content.Context;

import cse110.crossfit.IDEAproject.ModelsData.WODsC;
import cse110.crossfit.IDEAproject.ModelsData.benchmarkC;
import cse110.crossfit.IDEAproject.ModelsData.noteC;
import cse110.crossfit.IDEAproject.ModelsData.workoutC;

public class DataForm {
	
	/*
	 * Author: Alan
	 * Function Name: recordWeight()
	 * Description: Records the User's weight. Performs error checking without database access. 
	 * 				Converts the string to an int and passes it to the action method if there are no errors.
	 * Parameters: 
	 * 		String weight - The User's weight to be recorded. This string must contain only characters 0-9
	 * 		String date - The date that the User's weight is recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: 
	 * 		The String weight contains a character that is not 0-9
	 * 		The weight is either 0 or greater than 1000
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordWeight(String weight, String date, Context context) {
		//Checks if there are any characters that are not 0-9
		for (int pos = 0; pos < weight.length(); pos++) {
			
			//If the ASCII decimal value of the char at pos is less than 48 (ASCII decimal value for 0)
			if (weight.charAt(pos) < 48)
				return false;
			
			//If the ASCII decimal value of the char at pos is greater than 57 (ASCII decimal value for 9)
			if (weight.charAt(pos) > 57)
				return false;
		}
			
		//Converts the string to an Integer and then to an int
		Integer temp = new Integer(weight);
		int myWeight = temp.intValue();
			
		//Checks if the weight is 0 (Nobody should weight 0 pounds)
		if (myWeight == 0)
			return false;
			
		//Checks if the weight is 1000 or more (Nobody should weigh more than a 1000 pounds)
		if (myWeight >= 1000)
			return false;
			
		//Passes the weight to the action method
		return DataAction.recordWeight(myWeight, date, context);
	}

	/*
	 * Author: Alan
	 * Function Name: recordTimedWorkout()
	 * Description: Passes the statistics for a Timed Benchmark Workout to the action method.
	 * Parameters: 
	 * 		benchmarkC myBenchmarkC - The benchmark performed by the User
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */	
	public static boolean recordTimedWorkout(benchmarkC myBenchmarkC, Context context) {
		return DataAction.recordTimedWorkout(myBenchmarkC, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordAMRAPWorkout()
	 * Description: Passes the statistics for an AMRAP Benchmark Workout to the action method.
	 * Parameters: 
	 * 		benchmarkC myBenchmarkC - The benchmark performed by the User
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */	
	public static boolean recordAMRAPWorkout(benchmarkC myBenchmarkC, Context context) {
		return DataAction.recordAMRAPWorkout(myBenchmarkC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: recordBenchmark()
	 * Description: Passes the benchmark to the action method.
	 * Parameters: 
	 * 		workoutC myWorkoutC - The benchmark to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordBenchmark(workoutC myWorkoutC, Context context) {	
		return DataAction.recordBenchmark(myWorkoutC, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordWOD()
	 * Description:  Passes the WOD to the action method.
	 * Parameters: 
	 * 		WODsC myWODC - The WOD to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordWOD(WODsC myWODC, Context context) {	
		return DataAction.recordWOD(myWODC, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordNote()
	 * Description: Passes the Note to the action method.
	 * Parameters: 
	 * 		myNote - The Note to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordNote(noteC myNoteC, Context context) {	
		return DataAction.recordNote(myNoteC, context);
	}
		
	/*
	 * Author: Alan
	 * Function Name: updateNote()
	 * Description: Passes the updated Note to the action method.
	 * Parameters: 
	 * 		int myID - The ID of the Note to update
	 * 		String myTitle - The updated title of the Note
	 * 		String myBody - The updated body of the Note
	 *		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean updateNote(int myID, String myTitle, String myBody, Context context) {	
		return DataAction.updateNote(myID, myTitle, myBody, context);
	}

}
