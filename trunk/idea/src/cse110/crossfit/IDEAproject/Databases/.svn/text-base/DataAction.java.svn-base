package cse110.crossfit.IDEAproject.Databases;

import android.content.Context;
import cse110.crossfit.IDEAproject.ModelsData.WODsC;
import cse110.crossfit.IDEAproject.ModelsData.benchmarkC;
import cse110.crossfit.IDEAproject.ModelsData.noteC;
import cse110.crossfit.IDEAproject.ModelsData.workoutC;

public class DataAction {

	/*
	 * Author: Alan
	 * Function Name: recordWeight()
	 * Description: Passes the weight to the dispatch method
	 * Parameters: 
	 * 		int weight - The User's weight to be recorded
	 * 		String date - The date that the User's weight is recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordWeight(int weight, String date, Context context) {
		return DataDispatch.recordWeight(weight, date, context);
	}

	/*
	 * Author: Alan
	 * Function Name: recordTimedWorkout()
	 * Description: Passes the statistics for a Timed Benchmark Workout to the dispatch method.
	 * Parameters: 
	 * 		benchmarkC myBenchmarkC - The benchmark performed by the User
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */	
	public static boolean recordTimedWorkout(benchmarkC myBenchmarkC, Context context) {
		return DataDispatch.recordTimedWorkout(myBenchmarkC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: recordAMRAPWorkout()
	 * Description: Passes the statistics for an AMRAP Benchmark Workout to the dispatch method.
	 * Parameters: 
	 * 		benchmarkC myBenchmarkC - The benchmark performed by the User
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordAMRAPWorkout(benchmarkC myBenchmarkC, Context context) {
		//Passes the data to the dispatch method
		return DataDispatch.recordAMRAPWorkout(myBenchmarkC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: recordBenchmark()
	 * Description: Passes the benchmark to the dispatch method.
	 * Parameters: 
	 * 		workoutC myWorkoutC - The benchmark to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordBenchmark(workoutC myWorkoutC, Context context) {
		return DataDispatch.recordBenchmark(myWorkoutC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: recordWOD()
	 * Description: Passes the WOD to the dispatch method.
	 * Parameters: 
	 * 		WODsC myWODC - The WOD to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordWOD(WODsC myWODC, Context context) {
		return DataDispatch.recordWOD(myWODC, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordNote()
	 * Description: Passes the Note to the dispatch method.
	 * Parameters: 
	 * 		myNoteC - The Note to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordNote(noteC myNoteC, Context context) {
		return DataDispatch.recordNote(myNoteC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: updateNote()
	 * Description: Passes the updated Note to the dispatch method.
	 * Parameters: 
	 * 		int myID - The ID of the Note to update
	 * 		String myTitle - The updated title of the Note
	 * 		String myBody - The updated body of the Note
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean updateNote(int myID, String myTitle, String myBody, Context context) {
		return DataDispatch.updateNote(myID, myTitle, myBody, context);
	}

}
