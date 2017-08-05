package cse110.crossfit.IDEAproject.Databases;

import android.content.Context;
import cse110.crossfit.IDEAproject.ModelsData.WODsC;
import cse110.crossfit.IDEAproject.ModelsData.benchmarkC;
import cse110.crossfit.IDEAproject.ModelsData.noteC;
import cse110.crossfit.IDEAproject.ModelsData.weightC;
import cse110.crossfit.IDEAproject.ModelsData.workoutC;

public class DataDispatch {

	/*
	 * Author: Alan
	 * Modified by: Akin 06/03/2012
	 * Function Name: recordWeight()
	 * Description: Performs error checking with database access. There can only be one weight entered per day.
	 * 				If a weight was entered already, the new weight will overwrite the old weight. 
	 * 				Passes the weight to the manager method.
	 * Parameters: 
	 * 		int weight - The User's weight to be recorded
	 * 		String date - The date that the User's weight is recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordWeight(int weight, String date, Context context) {
		//Checks to see if the User already weighed in today
		weightC oldWeight = DataManager.getWeight(date, context);
		
		if (oldWeight == null) {
			//Calls the Manager method for recording
			return DataManager.recordWeight(weight, date, context);
		}
		
		else {
			// Calls the Manager method for updating
			weightC newWeight = oldWeight;
			newWeight.setWeight(new Double[] { (double) weight });
			return DataManager.updateWeight(newWeight, context);
		}
		
	}

	/*
	 * Author: Alan
	 * Function Name: recordTimedWorkout()
	 * Description: Passes the statistics for a Timed Benchmark Workout to the manager method.
	 * Parameters: 
	 * 		benchmarkC myBenchmarkC - The benchmark performed by the User
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */	
	public static boolean recordTimedWorkout(benchmarkC myBenchmarkC, Context context) {
		return DataManager.recordTimedWorkout(myBenchmarkC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: recordAMRAPWorkout()
	 * Description: Passes the statistics for an AMRAP Benchmark Workout to the manager method.
	 * Parameters: 
	 * 		benchmarkC myBenchmarkC - The benchmark performed by the User
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordAMRAPWorkout(benchmarkC myBenchmarkC, Context context) {
		return DataManager.recordAMRAPWorkout(myBenchmarkC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: recordBenchmark()
	 * Description: Passes the benchmark to the manager method.
	 * Parameters: 
	 * 		workoutC myWorkoutC - The benchmark to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordBenchmark(workoutC myWorkoutC, Context context) {
		return DataManager.recordBenchmark(myWorkoutC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: recordWOD()
	 * Description: Passes the WOD to the manager method.
	 * Parameters: 
	 * 		WODsC myWODC - The WOD to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordWOD(WODsC myWODC, Context context) {
		return DataManager.recordWOD(myWODC, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordNote()
	 * Description: Passes the Note to the manager method.
	 * Parameters: 
	 * 		myNoteC - The Note to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordNote(noteC myNoteC, Context context) {
		return DataManager.recordNote(myNoteC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: updateNote()
	 * Description: Passes the updated Note to the manager method.
	 * Parameters: 
	 * 		int myID - The ID of the Note to update
	 * 		String myTitle - The updated title of the Note
	 * 		String myBody - The updated body of the Note
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean updateNote(int myID, String myTitle, String myBody, Context context) {
		return DataManager.updateNote(myID, myTitle, myBody, context);
	}

}
