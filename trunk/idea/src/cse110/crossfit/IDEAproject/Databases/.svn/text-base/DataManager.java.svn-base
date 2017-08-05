package cse110.crossfit.IDEAproject.Databases;

import android.content.Context;

import cse110.crossfit.IDEAproject.ModelsData.WODsC;
import cse110.crossfit.IDEAproject.ModelsData.benchmarkC;
import cse110.crossfit.IDEAproject.ModelsData.exerciseC;
import cse110.crossfit.IDEAproject.ModelsData.noteC;
import cse110.crossfit.IDEAproject.ModelsData.weightC;
import cse110.crossfit.IDEAproject.ModelsData.workoutC;

public class DataManager {
	
	/*
	 * Author: Alan
	 * Function Name: recordWeight()
	 * Description:  Passes the weight to the DAO method.
	 * Parameters: 
	 * 		int weight - The User's weight to be recorded
	 * 		String date - The date that the User's weight is recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordWeight(int weight, String date, Context context) {
		return DataDAO.recordWeight(weight, date, context);
	}
	
	/*
	 * Author: Akin
	 * Function Name: updateWeight()
	 * Description:  Passes the weight to the DAO method.
	 * Parameters: 
	 * 		weightC newWeight - The User's weight to be updated
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean updateWeight(weightC newWeight, Context context) {
		return DataDAO.updateWeight(newWeight, context);
	}	
	
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: getWeight()
	 * Description: Calls DAO's getWeight method to get the weight from the database.
	 * Parameters:
	 * 		int id - The id to get the correct weight with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: weightC weight
	 */
	public static weightC getWeight(int id, Context context) {
		return DataDAO.getWeight(id, context);
	}
	
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: getWeight()
	 * Description: Calls DAO's getWeight method to get the weight from the database.
	 * Parameters:
	 * 		String weight_date - The date to get the correct weight with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: weightC weight
	 */
	public static weightC getWeight(String weight_date, Context context) {
		return DataDAO.getWeight(weight_date, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: getWeightCount()
	 * Description: Gets the weight count from the database.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None.
	 * Return Value: int
	 */
	public static int getWeightCount(Context context) {
		return DataDAO.getWeightCount(context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordTimedWorkout()
	 * Description: Passes the statistics for a Timed Benchmark Workout to the DAO method.
	 * Parameters: 
	 * 		benchmarkC myBenchmarkC - The benchmark performed by the User
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */	
	public static boolean recordTimedWorkout(benchmarkC myBenchmarkC, Context context) {
		return DataDAO.recordTimedWorkout(myBenchmarkC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: recordAMRAPWorkout()
	 * Description: Passes the statistics for an AMRAP Benchmark Workout to the DAO method.
	 * Parameters: 
	 * 		benchmarkC myBenchmarkC - The benchmark performed by the User
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordAMRAPWorkout(benchmarkC myBenchmarkC, Context context) {
		return DataDAO.recordAMRAPWorkout(myBenchmarkC, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordBenchmark()
	 * Description: Passes the benchmark to the DAO method.
	 * Parameters: 
	 * 		workoutC myWorkoutC - The workout to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordBenchmark(workoutC myWorkoutC, Context context) {
		return DataDAO.recordBenchmark(myWorkoutC, context);
	}

	/*
	 * Author: Alan
	 * Function Name: getAllBenchmarkNames()
	 * Description: Calls DAO's getAllBenchmarkNames method to retrieve the name of all the Benchmarks.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: String[]
	 */
	public static String[] getAllBenchmarkNames(Context context) {
		return DataDAO.getAllBenchmarkNames(context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: getBenchmark()
	 * Description: Calls DAO's getBenchmark method to get the benchmark from the database.
	 * Parameters:
	 * 		String name - The name to get the correct benchmark with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: workoutC
	 */
	public static workoutC getBenchmark(String name, Context context) {
		return DataDAO.getBenchmark(name, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: getBenchmark()
	 * Description: Calls DAO's getBenchmark method to get the benchmark from the database.
	 * Parameters:
	 * 		int myID - The ID to get the correct benchmark with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: workoutC
	 */
	public static workoutC getBenchmark(int myID, Context context) {
		return DataDAO.getBenchmark(myID, context);
	}

	/*
	 * Author: Alan
	 * Function Name: getExercise()
	 * Description: Calls DAO's getExercise method to get the exercise from the database.
	 * Parameters:
	 * 		int key - The key to get the correct exercise with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: exerciseC
	 */
	public static exerciseC getExercise(int key, Context context) {
		return DataDAO.getExercise(key, context);
	}
	
	/*
	 * Author: Carter
	 * Modified by: Alan
	 * Function Name: getAllExerciseNames()
	 * Description: Calls DAO's getAllExerciseNames method to retrieve the name of all the Exercises.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: String[]
	 */
	public static String[] getAllExerciseNames(Context context) {
		return DataDAO.getAllExerciseNames(context);
	}
	
	/*
	 * Author: Carter
	 * Modified by: Alan
	 * Function Name: getAllNoteNames()
	 * Description: Calls DAO's getAllNoteNames method to retrieve the name of all the Notes.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: String[]
	 */
	public static String[] getAllNoteNames(Context context) {
	    return DataDAO.getAllNoteNames(context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: getNote()
	 * Description: Calls DAO's getNote method to get the note from the database.
	 * Parameters:
	 * 		String name - The name to get the correct note with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: noteC
	 */
	public static noteC getNote(String name, Context context) {
		return DataDAO.getNote(name, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordNote()
	 * Description: Passes the note to DAO method.
	 * Parameters: 
	 * 		myNoteC - The Note to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordNote(noteC myNoteC, Context context) {
		return DataDAO.recordNote(myNoteC, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: deleteNote()
	 * Description: Calls DAO's deleteNote method to delete the note from the database.
	 * Parameters:
	 * 		int myID - The ID of the Note to delete
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean deleteNote(int myID, Context context) {
		return DataDAO.deleteNote(myID, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: updateNote()
	 * Description: Calls DAO's updateNote method to update the recorded note in the database.
	 * Parameters: 
	 * 		int myID - The ID of the Note to update
	 * 		String myTitle - The updated title of the Note
	 * 		String myBody - The updated body of the Note
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean updateNote(int myID, String myTitle, String myBody, Context context) {
		return DataDAO.updateNote(myID, myTitle, myBody, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: getHistoryCount()
	 * Description: Calls DAO's getHistoryCount method to get the history count from the database.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: int
	 */
	public static int getHistoryCount(Context context) {
		return DataDAO.getHistoryCount(context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: getHistory()
	 * Description: Calls DAO's getHistory method to get the history  from the database.
	 * Parameters:
	 * 		int myID - The ID to get the correct history with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: benchmarkC
	 */
	public static benchmarkC getHistory(int myID, Context context) {
		return DataDAO.getHistory(myID, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: getWODCount()
	 * Description: Calls DAO's getWODCount method to get the WOD count from the database.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: int
	 */
	public static int getWODCount(Context context) {
		return DataDAO.getWODCount(context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: getWODID()
	 * Description: Calls DAO's getWODID method to get the WOD's ID from the database.
	 * Parameters:
	 * 		int myID - The ID to get the correct WOD ID with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: int
	 */
	public static int getWODID(int myID, Context context) {
		return DataDAO.getWODID(myID, context);
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordWOD()
	 * Description: Passes the WOD to the DAO method.
	 * Parameters: 
	 * 		WODsC myWODC - The WOD to be recorded
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordWOD(WODsC myWODC, Context context) {
		return DataDAO.recordWOD(myWODC, context);
	}
	
	/*
	 * Author: Carter
	 * Modified by: Alan
	 * Function Name: createDatabase()
	 * Description: Calls DAO's createDatabase method to put all the data into the database.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: None
	 */
	public static void createDatabase(Context context) {
		DataDAO.createDatabase(context);
	}
	
}
