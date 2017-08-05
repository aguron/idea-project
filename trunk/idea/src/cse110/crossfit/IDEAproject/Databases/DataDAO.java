package cse110.crossfit.IDEAproject.Databases;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import cse110.crossfit.IDEAproject.ModelsData.WODsC;
import cse110.crossfit.IDEAproject.ModelsData.benchmarkC;
import cse110.crossfit.IDEAproject.ModelsData.exerciseC;
import cse110.crossfit.IDEAproject.ModelsData.noteC;
import cse110.crossfit.IDEAproject.ModelsData.weightC;
import cse110.crossfit.IDEAproject.ModelsData.workoutC;

public class DataDAO {
	
	/*
	 * Author: Alan
	 * Function Name: recordWeight()
	 * Description:  Records the weight in the database.
	 * Parameters: 
	 * 		int weight - The User's weight to be recorded
	 * 		String date - The date that the User's weight is recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordWeight(int weight, String date, Context context) {
		final databaseHelper data = new databaseHelper(context);

		Double[] tempWeight = new Double[1];
		tempWeight[0] = (double) weight;
		
		weightC newWeight = new weightC(tempWeight, date);
		data.addWeight(newWeight);
		
		data.close();
		return true;
	}
	
	/*
	 * Author: Akin
	 * Function Name: updateWeight()
	 * Description: Updates the weight in the database.
	 * Parameters: 
	 * 		weightC newWeight - The User's weight to be updated
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean updateWeight(weightC newWeight, Context context) {
		final databaseHelper data = new databaseHelper(context);
		data.updateWeight(newWeight);
		
		data.close();
		return true;
	}	
	
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: getWeight()
	 * Description: Gets the weight from the database.
	 * Parameters:
	 * 		int id - The id to get the correct weight with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: weightC weight
	 */
	public static weightC getWeight(int id, Context context) {
		final databaseHelper data = new databaseHelper(context);
		weightC mWeightC = data.getWeight(id);
		
		data.close();
		return mWeightC;
	}
	
	/*
	 * Author: Akinyinka Omigbodun
	 * Function Name: getWeight()
	 * Description: Gets the weight from the database.
	 * Parameters:
	 * 		String weight_date - The date to get the correct weight with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: weightC weight
	 */
	public static weightC getWeight(String weight_date, Context context) {
		final databaseHelper data = new databaseHelper(context);
		weightC mWeightC = data.getWeight(weight_date);
		
		data.close();
		return mWeightC;
	}
	
	/*
	 * Author: Alan
	 * Function Name: getWeightCount()
	 * Description: Gets the weight count from the database.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: int
	 */
	public static int getWeightCount(Context context) {
		final databaseHelper data = new databaseHelper(context);
		int count = data.getWeightCount();
		
		data.close();
		return count;
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordTimedWorkout()
	 * Description: Records statistics for a Timed Benchmark Workout in the database.
	 * Parameters: 
	 * 		benchmarkC myBenchmarkC - The benchmark performed by the User
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */	
	public static boolean recordTimedWorkout(benchmarkC myBenchmarkC, Context context) {
		final databaseHelper data = new databaseHelper(context);
		int benchmarkID = data.getHistoryCount() + 1;
		myBenchmarkC.setBenchmarkID(benchmarkID);
		data.addBenchMark(myBenchmarkC);
		
		data.close();
		return true;
	}

	/*
	 * Author: Alan
	 * Function Name: recordAMRAPWorkout()
	 * Description: Records the statistics for an AMRAP Benchmark Workout in the database.
	 * Parameters: 
	 * 		benchmarkC myBenchmarkC - The benchmark performed by the User
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordAMRAPWorkout(benchmarkC myBenchmarkC, Context context) {
		final databaseHelper data = new databaseHelper(context);
		int benchmarkID = data.getHistoryCount() + 1;
		myBenchmarkC.setBenchmarkID(benchmarkID);
		data.addBenchMark(myBenchmarkC);
		
		data.close();
		return true;
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordBenchmark()
	 * Description: Records the benchmark in the database.
	 * Parameters: 
	 * 		workoutC myWorkoutC - The workout to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordBenchmark(workoutC myWorkoutC, Context context) {
		final databaseHelper data = new databaseHelper(context);
		data.addWorkOut(myWorkoutC);
		
		data.close();
		return true;
	}

	/*
	 * Author: Alan
	 * Function Name: getAllBenchmarkNames()
	 * Description: Retrieves the name of all the Benchmarks.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: String[]
	 */
	public static String[] getAllBenchmarkNames(Context context) {
		final databaseHelper data = new databaseHelper(context);
		int workoutCount = data.getWorkOutCount(); 
		List<Integer> workoutIDList = new ArrayList<Integer>();
		List<String> workoutNameList = new ArrayList<String>();
		
		int preWorkoutID = -1;
	       
		for(int i =1 ; i <= workoutCount; i++) {
			int tempWorkoutId = data.getWorkOutByPK(i).getWorkoutID();
	        	
			if(tempWorkoutId != preWorkoutID) {
				workoutIDList.add(tempWorkoutId);
				preWorkoutID = tempWorkoutId; 
				//System.out.println("workout ID " + tempWorkoutId);
				workoutNameList.add(data.getWorkOut(tempWorkoutId).getWorkoutName());
			}
		}
		
		String[] workoutNameArr = workoutNameList.toArray(new String[workoutNameList.size()]);
		workoutNameList.toArray();		
		
		data.close();
		return workoutNameArr;
	}
	
	/*
	 * Author: Alan
	 * Function Name: getBenchmark()
	 * Description: Gets the benchmark from the database.
	 * Parameters:
	 * 		String name - The name to get the correct benchmark with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: workoutC
	 */
	public static workoutC getBenchmark(String name, Context context) {
		final databaseHelper data = new databaseHelper(context);
		workoutC myWorkoutC = data.getWorkOut(name);
		
		data.close();
		return myWorkoutC;
	}
	
	/*
	 * Author: Alan
	 * Function Name: getBenchmark()
	 * Description: Gets the benchmark from the database.
	 * Parameters:
	 * 		int myID - The ID to get the correct benchmark with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: workoutC
	 */
	public static workoutC getBenchmark(int myID, Context context) {
		final databaseHelper data = new databaseHelper(context);
		workoutC myWorkoutC = data.getWorkOut(myID);
		
		data.close();
		return myWorkoutC;
	}	

	/*
	 * Author: Alan
	 * Function Name: getExercise()
	 * Description: Gets the exercise from the database.
	 * Parameters:
	 * 		int key - The key to get the correct exercise with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: exerciseC
	 */
	public static exerciseC getExercise(int key, Context context) {
		final databaseHelper data = new databaseHelper(context);
		exerciseC myExerciseC = data.getExercise(key);
		
		data.close();
		return myExerciseC;
	}
	
	/*
	 * Author: Carter
	 * Modified by: Alan
	 * Function Name: getAllExerciseNames()
	 * Description: Retrieves the name of all the Exercises.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: String[]
	 */
	public static String[] getAllExerciseNames(Context context) {
		final databaseHelper data = new databaseHelper(context);	
		ArrayList<String> names =  new  ArrayList<String>();
		
		for(int i = 1; i <= data.getExerciseCount(); i++) {
			names.add( data.getExercise(i).getExerciseName() );
		}
		
		String[] namesArray = new String[ names.size() ];
		namesArray = names.toArray(namesArray);
		
		data.close();
		return namesArray;
	}
	
	/*
	 * Author: Carter
	 * Modified by: Alan
	 * Function Name: getAllNoteNames()
	 * Description: Retrieves the name of all the Notes.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: String[]
	 */
	public static String[] getAllNoteNames(Context context) {
	    final databaseHelper data = new databaseHelper(context);	
	    
	    List<noteC> notesList =  new ArrayList<noteC>();
	    notesList  = data.getAllnote();
	    
	    List<String> notesNameList = new ArrayList<String>();
	    
		for(int i = 0; i < notesList.size(); i++) {
			notesNameList.add(notesList.get(i).getNotesTitle());
		}
		
		String[] notesNameArray = notesNameList.toArray(new String[notesNameList.size()]);
		notesNameList.toArray(notesNameArray);
		
		data.close();
		return notesNameArray;
	}
	
	/*
	 * Author: Alan
	 * Function Name: getNote()
	 * Description: Gets the note from the database.
	 * Parameters:
	 * 		String name - The name to get the correct note with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: noteC
	 */
	public static noteC getNote(String name, Context context) {
		final databaseHelper data = new databaseHelper(context);
		noteC myNoteC = data.getNote(name);
		
		data.close();
		return myNoteC;
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordNote()
	 * Description: Records the Note in the database.
	 * Parameters: 
	 * 		myNoteC - The Note to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordNote(noteC myNoteC, Context context) {
		final databaseHelper data = new databaseHelper(context);
		data.addNote(myNoteC);
		
		data.close();
		return true;
	}
	
	/*
	 * Author: Alan
	 * Function Name: deleteNote()
	 * Description: Deletes the note from the database.
	 * Parameters:
	 * 		int myID - The ID of the Note to delete
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: exerciseC
	 */
	public static boolean deleteNote(int myID, Context context) {
		final databaseHelper data = new databaseHelper(context);
		data.deleteNote(myID);
		
		data.close();
		return true;
	}
	
	/*
	 * Author: Alan
	 * Function Name: updateNote()
	 * Description: Updates the recorded note in the database.
	 * Parameters: 
	 * 		int myID - The ID of the Note to update
	 * 		String myTitle - The updated title of the Note
	 * 		String myBody - The updated body of the Note
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean updateNote(int myID, String myTitle, String myBody, Context context) {
		final databaseHelper data = new databaseHelper(context);
		data.updateNote(myID, myTitle, myBody);
		
		data.close();
		return true;
	}
	
	/*
	 * Author: Alan
	 * Function Name: getHistoryCount()
	 * Description: Gets the history count from the database.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: int
	 */
	public static int getHistoryCount(Context context) {
		final databaseHelper data = new databaseHelper(context);
		int count = data.getHistoryCount();
		
		data.close();
		return count;
	}
	
	/*
	 * Author: Alan
	 * Function Name: getHistory()
	 * Description: Gets the history from the database.
	 * Parameters:
	 * 		int myID - The ID to get the correct history with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: benchmarkC
	 */
	public static benchmarkC getHistory(int myID, Context context) {
		final databaseHelper data = new databaseHelper(context);
		benchmarkC myBenchmarkC = data.getBenchmark(myID);
		
		data.close();
		return myBenchmarkC;
	}
	
	/*
	 * Author: Alan
	 * Function Name: getWODCount()
	 * Description: Gets the WOD count from the database.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: int
	 */
	public static int getWODCount(Context context) {
		final databaseHelper data = new databaseHelper(context);
		int count = data.getWODSCount();
		
		data.close();
		return count;
	}
	
	/*
	 * Author: Alan
	 * Function Name: getWODID()
	 * Description: Gets the WOD's ID from the database.
	 * Parameters:
	 * 		int myID - The ID to get the correct WOD ID with
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: int
	 */
	public static int getWODID(int myID, Context context) {
		final databaseHelper data = new databaseHelper(context);
		int wodID = data.getWODSwodid(myID);
		
		data.close();
		return wodID;
	}
	
	/*
	 * Author: Alan
	 * Function Name: recordWOD()
	 * Description: Records the WOD in the database.
	 * Parameters: 
	 * 		WODsC myWODC - The WOD to be recorded
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: True indicating success, False indicating failure
	 */
	public static boolean recordWOD(WODsC myWODC, Context context) {
		final databaseHelper data = new databaseHelper(context);
		data.addWOD(myWODC);
		
		data.close();
		return true;
	}
	
	/*
	 * Author: Carter
	 * Modified by: Alan
	 * Function Name: createDatabase()
	 * Description: Puts all the data into the database.
	 * Parameters:
	 * 		Context context - The context to use for the database
	 * Error Conditions: None
	 * Return Value: None
	 */
	public static void createDatabase(Context context) {
		final databaseHelper db = new databaseHelper(context);
	
		// exercise start 80
		//public exerciseC(String _exercise, String _description)
		db.addExercise( new exerciseC("air squats", "Move from standing position to a squatting position with the hips below the knees, and back to standing."));
		db.addExercise( new exerciseC("back extensions","Using a GHD (Glute Ham Developer) machine, move from an L-shaped position with the head directly below the pelvis to an extended horizontal position" ));
		db.addExercise( new exerciseC("ball slams", "With a D-Ball, throw the ball to the ground from the outstretched “C” of the launch"));
		db.addExercise( new exerciseC("box jumps","From a standing position on the floor, jump and land with both feet on top of a box and fully extend the legs before returning to the floor"));
		db.addExercise( new exerciseC("burpee","Begin in a standing position; drop to the floor with feet extending backward, making contact to the floor with the chest; pull legs forward, landing in a solid squatting position before standing up; finish with a small jump while extending arms overhead"));
		db.addExercise( new exerciseC("double-unders","Most common variation is the “double under” where the jump rope makes two revolutions for each jump"));
		db.addExercise( new exerciseC("handstand push-ups","Begin in a standing position; drop to the floor with feet extending backward, making contact to the floor with the chest; pull legs forward, landing in a solid squatting position before standing up; finish with a small jump while extending arms overhead"));
		db.addExercise( new exerciseC("jump rope","Most common variation is the “double under” where the jump rope makes two revolutions for each jump"));
		db.addExercise( new exerciseC("knees-to-elbows","Hanging from a bar, starting in an extended position, raise knees until they make contact with elbows"));
		db.addExercise( new exerciseC("L-sit","With the body supported on gymnastics rings or parallettes, hold the feet at or above hip level with legs straight"));
		db.addExercise( new exerciseC("lunge","Take a large step forward; bend the forward knee until the back knee makes contact with the ground; rise"));
		db.addExercise( new exerciseC("muscle-up","Hanging from gymnastics rings or a bar, pull up and over the rings or bar, ending with arms straight and hands below the hips"));
		db.addExercise( new exerciseC("ring dip","Start with the body supported on the rings with straight vertical arms; bend arms, lowering the body until the shoulder drops below the elbow; straighten arms"));
		db.addExercise( new exerciseC("pistols","Using one leg, move from standing position to a squatting position with the hips below the knees, and back to standing"));
		db.addExercise( new exerciseC("pull-ups","Start from a hanging position with straight arms; pull up until the chin is over the bar"));
		db.addExercise( new exerciseC("strict pull-ups","Start from a hanging position with straight arms; pull up until the chin is over the bar. No swinging is allowed"));
		db.addExercise( new exerciseC("kipping","Start from a hanging position with straight arms; pull up until the chin is over the bar. Momentum is used to help complete the movement."));
		db.addExercise( new exerciseC("weighted pull-ups","Start from a hanging position with straight arms; pull up until the chin is over the bar. Extra weight is hung on the athlete"));
		db.addExercise( new exerciseC("chest-to-bar pull-ups","Start from a hanging position with straight arms; pull up until the chin is over the bar and the chest makes contact with the bar"));
		db.addExercise( new exerciseC("jumping pull-ups","Start from a hanging position with straight arms; pull up until the chin is over the bar. Use legs to help propel upwards."));
		db.addExercise( new exerciseC("elastic pull-ups","Start from a hanging position with straight arms; pull up until the chin is over the bar. An elastic band is used to help complete the movement with less weight."));
		db.addExercise( new exerciseC("push-ups","Start in a plank position with arms straight; lower until the chest makes contact with the ground, keeping body straight throughout; push back up into plank position"));
		db.addExercise( new exerciseC("weighted push-ups","Start in a plank position with arms straight; lower until the chest makes contact with the ground, keeping body straight throughout; push back up into plank position. Weights are stacked on the athlete's shoulders."));
		db.addExercise( new exerciseC("rope climb","Starting from the ground, climb a rope and touch a point at a designated height, often 15 feet"));
		db.addExercise( new exerciseC("L-sit rope climb","Starting from the ground, climb a rope and touch a point at a designated height, often 15 feet. Feet are held above hip-level during the climb"));
		db.addExercise( new exerciseC("sit-ups","Start laying face-up with shoulders on the ground; move into a sitting position with the shoulders over the hips. The feet may sometimes be anchored"));
		db.addExercise( new exerciseC("toes-to-bar","Hanging from a bar in an extended position, bring feet upward until they make contact with the bar"));
		db.addExercise( new exerciseC("run","Run for distances ranging from 200 meters to 1 mile"));
		db.addExercise( new exerciseC("row","Use a rowing machine for distances ranging from 500 meters to 2000 meters"));
		db.addExercise( new exerciseC("deadlift","Barbell is lifted from the ground until the athlete reaches an upright standing position"));
		db.addExercise( new exerciseC("clean","Barbell (or dumbbells) is lifted from the ground into a “rack position” in front of the athlete’s neck; end in a standing position"));
		db.addExercise( new exerciseC("kettlebell swing","A kettlebell is swung from between the legs to overhead"));
		db.addExercise( new exerciseC("press","Barbell is moved from “rack position” into overhead position"));
		db.addExercise( new exerciseC("strict press","Barbell is moved from “rack position” into overhead position while the lower body remains stationary"));
		db.addExercise( new exerciseC("push press","Barbell is moved from “rack position” into overhead position. The bar is then “jumped” off the body using a “dip and drive” motion"));
		db.addExercise( new exerciseC("push jerk","Barbell is moved from “rack position” into overhead position. The bar is then “jumped” off the body using a “dip and drive” motion. A re-bed of the knees to allow the athlete to drop under the bar and receive it with straight arms"));
		db.addExercise( new exerciseC("split jerk","Barbell is moved from “rack position” into overhead position. The bar is then “jumped” off the body using a “dip and drive” motion. A re-bed of the knees to allow the athlete to drop under the bar and receive it with straight arms. One leg goes forward and the other backward when the athlete drops under the bar"));
		db.addExercise( new exerciseC("snatch","Barbell is raised from the floor to the overhead position in one motion"));
		db.addExercise( new exerciseC("squat snatch","Receive the bar in a squatting position and stand to finish the lift"));
		db.addExercise( new exerciseC("power clean","Receive the bar in a partial squat"));
		db.addExercise( new exerciseC("back squats","From a standing position with a wider-than-shoulder width stance, bend the knees until the hips are below the knees; then stand, keeping heels on the floor. Barbell is supported on upper back"));
		db.addExercise( new exerciseC("front squats","From a standing position with a wider-than-shoulder width stance, bend the knees until the hips are below the knees; then stand, keeping heels on the floor. Barbell is supported in rack position"));
		db.addExercise( new exerciseC("overhead squats","From a standing position with a wider-than-shoulder width stance, bend the knees until the hips are below the knees; then stand, keeping heels on the floor. Barbell is supported in overhead position"));
		db.addExercise( new exerciseC("sumo deadlift high pulls","With a wide stance, a barbell or kettlebell is lifted from the ground to a position just under the chin"));
		db.addExercise( new exerciseC("thrusters","Start with the barbell in rack position; squat with hips below knees and then stand, driving the barbell overhead"));
		db.addExercise( new exerciseC("squats",""));
		db.addExercise( new exerciseC("1-legged squats"," "));
		db.addExercise( new exerciseC("jerk"," "));
		db.addExercise( new exerciseC("wall ball shots"," "));
		db.addExercise( new exerciseC("benchpress"," "));
		db.addExercise( new exerciseC("run backwards"," "));
		db.addExercise( new exerciseC("dumbbell squat clean"," "));
		db.addExercise( new exerciseC("stiff legged deadlift"," "));
		db.addExercise( new exerciseC("overhead walk"," "));
		db.addExercise( new exerciseC("Turkish get-ups"," "));
		db.addExercise( new exerciseC("bear crawl"," "));
		db.addExercise( new exerciseC("broad-jump"," "));
		db.addExercise( new exerciseC("walking lunge"," "));
		db.addExercise( new exerciseC("carry"," "));
		db.addExercise( new exerciseC("farmer walk"," "));
		db.addExercise( new exerciseC("sprint"," "));
		db.addExercise( new exerciseC("toes through rings"," "));
		db.addExercise( new exerciseC("clean and jerk"," "));
		db.addExercise( new exerciseC("rest"," "));
		db.addExercise( new exerciseC("hand-release push-ups"," "));
		db.addExercise( new exerciseC("L pull-ups"," "));
		db.addExercise( new exerciseC("power snatch"," "));
		db.addExercise( new exerciseC("split clean"," "));
		db.addExercise( new exerciseC("glute-ham sit-ups"," "));
		db.addExercise( new exerciseC("hang power clean"," "));
		db.addExercise( new exerciseC("ring push-ups"," "));
		db.addExercise( new exerciseC("hang split snatch"," "));
		db.addExercise( new exerciseC("ring row"," "));
		db.addExercise( new exerciseC("hang squat clean"," "));
		db.addExercise( new exerciseC("squat clean"," "));
		db.addExercise( new exerciseC("shoulder press"," "));
	
		//add wods
		//public WODsC( int wod_id, int[] exercise_id , String[] wod_rep, String[] wod_weights )
		db.addWOD(new WODsC(101, new int[]{15,22,26,46},new String[]{"100","100","100","100"}, new String[]{"","","","" }));
		db.addWOD(new WODsC(102, new int[]{15,22,26,46},new String[]{"20","30","40","50"}, new String[]{"","","",""  }));
		db.addWOD(new WODsC(103, new int[]{15,22,46},new String[]{"5","10","15"}, new String[]{"","","",""  }));
		db.addWOD(new WODsC(104, new int[]{15,22,46},new String[]{"5","10","15"}, new String[]{"","","",""  }));
		db.addWOD(new WODsC(105, new int[]{30,7},new String[]{"",""}, new String[]{"225 lbs",""  }));
		db.addWOD(new WODsC(106, new int[]{31,13},new String[]{"",""}, new String[]{"135 lbs",""  }));
		db.addWOD(new WODsC(107, new int[]{45,15},new String[]{"",""}, new String[]{"95 lbs",""  }));
		db.addWOD(new WODsC(108, new int[]{31,48},new String[]{"",""}, new String[]{"135 lbs","135 lbs"  }));
		db.addWOD(new WODsC(109, new int[]{28,32,15},new String[]{"400 m","21","12"}, new String[]{"","","1.5 pood"  }));
		db.addWOD(new WODsC(110, new int[]{38},new String[]{""}, new String[]{"135 lbs" }));
		db.addWOD(new WODsC(111, new int[]{29,45,15},new String[]{"1000 m","50","30"}, new String[]{"","45 lbs",""  }));
		db.addWOD(new WODsC(112, new int[]{49},new String[]{"150"}, new String[]{""}));
		db.addWOD(new WODsC(113, new int[]{30,50,31},new String[]{"","",""}, new String[]{"1.5x bodyweight","bodyweight","0.75x bodyweight"  }));
		db.addWOD(new WODsC(114, new int[]{7,47,15},new String[]{"5","10","15"}, new String[]{"","",""  }));
		db.addWOD(new WODsC(115, new int[]{28,43},new String[]{"400 m","15"}, new String[]{"",""  }));
		db.addWOD(new WODsC(116, new int[]{6,26},new String[]{"",""}, new String[]{"",""  }));
		db.addWOD(new WODsC(117, new int[]{28,32,15},new String[]{"800 m","30","30"}, new String[]{"","2 pood",""  }));
		db.addWOD(new WODsC(118, new int[]{28,4,49},new String[]{"400 m","30","30"}, new String[]{"","","20 lb ball"  }));
		db.addWOD(new WODsC(119, new int[]{50,15},new String[]{"",""}, new String[]{"bodyweight",""  }));
		db.addWOD(new WODsC(120, new int[]{28,15},new String[]{"400 m","max reps"}, new String[]{"",""  }));
		db.addWOD(new WODsC(121, new int[]{12,38},new String[]{"",""}, new String[]{"","135/95 lbs"  }));
		db.addWOD(new WODsC(201, new int[]{7,13,22},new String[]{"","",""}, new String[]{"","",""  }));
		db.addWOD(new WODsC(202, new int[]{28,2,26},new String[]{"800 m","50","50"}, new String[]{"","",""  }));
		db.addWOD(new WODsC(203, new int[]{28,15,22,46,28},new String[]{"1 mile","100","200","300","1 mile"}, new String[]{"","","","",""  }));
		db.addWOD(new WODsC(204, new int[]{15,28,45,28,45,28,15},new String[]{"50","400","21","800","21","400","50"}, new String[]{"","","95 lbs","","95 lbs","",""  }));
		db.addWOD(new WODsC(205, new int[]{43,15,43,15,43,15},new String[]{"21","42","15","30","9","18"}, new String[]{"","","","","95 lbs",""  }));
		db.addWOD(new WODsC(206, new int[]{46,12,46,12,46,12,46,12},new String[]{"100","5","75","10","50","15","25","20"}, new String[]{"","","","","","","","" }));
		db.addWOD(new WODsC(207, new int[]{46,15,28},new String[]{"30","30","800"}, new String[]{"95 lbs","",""  }));
		db.addWOD(new WODsC(208, new int[]{39,66,39,66},new String[]{"21","21","21","21"}, new String[]{"40 lbs","","40 lbs",""  }));
		db.addWOD(new WODsC(209, new int[]{12,7,32},new String[]{"2","4","8"}, new String[]{"","","2 pood"  }));
		db.addWOD(new WODsC(210, new int[]{67},new String[]{"75"}, new String[]{""  }));
		db.addWOD(new WODsC(211, new int[]{45,24,45,24,45,24},new String[]{"21","12","15","9","9","6"}, new String[]{"115 lbs","","115 lbs","","115 lbs",""  }));
		db.addWOD(new WODsC(212, new int[]{28,51,28,51},new String[]{"800 m","400 m","800 m","400 m"}, new String[]{"","","",""  }));
		db.addWOD(new WODsC(213, new int[]{12,5},new String[]{"7","21"}, new String[]{"",""  }));
		db.addWOD(new WODsC(214, new int[]{68,15},new String[]{"15","21"}, new String[]{"40 lbs",""  }));
		db.addWOD(new WODsC(215, new int[]{28,69,30},new String[]{"400 m","30","15"}, new String[]{"","","250 lbs"  }));
		db.addWOD(new WODsC(216, new int[]{30,70,36},new String[]{"12","9","6"}, new String[]{"155 lbs","155 lbs","155 lbs"  }));
		db.addWOD(new WODsC(217, new int[]{4,35,15},new String[]{"30","20","30"}, new String[]{"","115 lbs",""  }));
		db.addWOD(new WODsC(218, new int[]{32,5,69},new String[]{"30","30","30"}, new String[]{"2 pood","",""  }));
		db.addWOD(new WODsC(219, new int[]{12,44},new String[]{"7","21"}, new String[]{"","95 lbs"  }));
		db.addWOD(new WODsC(220, new int[]{30,28,32,28,43,28,5,28,19,28,4,28,52,28},new String[]{"20","400 m","20","400m","20","400m","20","400 m","20","400 m","20","400 m","20","400 m","20","400 m"}, new String[]{"275 lbs","","2 pood", "","115 lbs", "","","","","","","","45 lbs","","45 lbs",""  }));
		db.addWOD(new WODsC(221, new int[]{69,2,9,53},new String[]{"","","",""}, new String[]{"","","", "95 lbs"  }));
		db.addWOD(new WODsC(222, new int[]{46,7,66},new String[]{"75","25","25"}, new String[]{"","",""  }));
		db.addWOD(new WODsC(223, new int[]{12,46,69},new String[]{"25","100","35"}, new String[]{"","",""  }));
		db.addWOD(new WODsC(224, new int[]{30,22,4},new String[]{"5","13","9"}, new String[]{"275 lbs","",""  }));
		db.addWOD(new WODsC(225, new int[]{6,9,54},new String[]{"50","35","20 yards"}, new String[]{"","","185 lbs"  }));
		db.addWOD(new WODsC(226, new int[]{28,29,28},new String[]{"1 mile","2 km"," 1 mile"}, new String[]{"","",""}));
		db.addWOD(new WODsC(227, new int[]{7,30,4,15,49,6,28},new String[]{"10","15","25","50","100","200","400"}, new String[]{"","250 lbs","","","20 lbs","","45 lb plate"}));
		db.addWOD(new WODsC(228, new int[]{55,55,43,32,43,32,55},new String[]{"21","50","21","50","21","50","21"}, new String[]{"","","","","","",""}));
		db.addWOD(new WODsC(229, new int[]{7,45,9,30,5,32,15},new String[]{"7","7","7","7","7","7","7"}, new String[]{"","135 lbs","","245 lbs","","2 pood",""}));
		db.addWOD(new WODsC(230, new int[]{28,24,22},new String[]{"800","5","50"}, new String[]{"","",""}));
		db.addWOD(new WODsC(231, new int[]{28,12,46},new String[]{"1 km","10","100"}, new String[]{"","",""}));
		db.addWOD(new WODsC(232, new int[]{30,12,52},new String[]{"9","8","9"}, new String[]{"245 lbs","","155 lbs"}));
		db.addWOD(new WODsC(233, new int[]{30,4,15},new String[]{"15","20","25"}, new String[]{"225 lbs","",""}));
		db.addWOD(new WODsC(234, new int[]{30,4,49,50,4,49,31},new String[]{"24","24","24","24","24","24","24"}, new String[]{"295 lbs","","","195 lbs","","20 lbs","145 lbs"}));
		db.addWOD(new WODsC(235, new int[]{45,71},new String[]{"10","10"}, new String[]{"95 lbs",""}));
		db.addWOD(new WODsC(236, new int[]{16,22,28},new String[]{"50","100","5 km"}, new String[]{"","",""}));
		db.addWOD(new WODsC(237, new int[]{28,52,5},new String[]{"800 m","30","30"}, new String[]{"","50 lbs",""}));
		db.addWOD(new WODsC(238, new int[]{35,32,4},new String[]{"10","10","10"}, new String[]{"115 lbs","1.5 pood",""}));
		db.addWOD(new WODsC(239, new int[]{66,27,5,28},new String[]{"20","30","40","800 m"}, new String[]{"","","",""}));
		db.addWOD(new WODsC(240, new int[]{28,19,42,7},new String[]{"150 m","7","7","7"}, new String[]{"","","135 lbs",""}));
		db.addWOD(new WODsC(241, new int[]{56,57,5},new String[]{"100 feet","100 feet","3 after every 5 broad-jumps"}, new String[]{"","",""}));
		db.addWOD(new WODsC(242, new int[]{58,4,49,7},new String[]{"100 feet","30","20","10"}, new String[]{"45 lb plate overhead","","20 lb ball",""}));
		db.addWOD(new WODsC(243, new int[]{59,35,4,44},new String[]{"400 m","12","12","12"}, new String[]{"50 lb sandbag","115 lbs","","95 lbs"}));
		db.addWOD(new WODsC(244, new int[]{24,41,60},new String[]{"","29","10 m"}, new String[]{"","95 lbs","135 lb"}));
		db.addWOD(new WODsC(245, new int[]{32,4,28,5,49},new String[]{"22","22","400 m","22","22"}, new String[]{"2 pood","","","","20 lb ball"}));
		db.addWOD(new WODsC(246, new int[]{6,43,15,28},new String[]{"200","50","50","1 mile"}, new String[]{"","135 lbs","",""}));
		db.addWOD(new WODsC(247, new int[]{30,5,32,28},new String[]{"6","7","10","200 m"}, new String[]{"225 lbs","","2 pood",""}));
		db.addWOD(new WODsC(248, new int[]{45,15,61},new String[]{"5","10","100 m"}, new String[]{"115 lbs","",""}));
		db.addWOD(new WODsC(249, new int[]{7,62,31},new String[]{"5","10","15"}, new String[]{"","","20 lbs"}));
		db.addWOD(new WODsC(250, new int[]{32,40,4},new String[]{"15","15","15"}, new String[]{"1.5 pood","95 lbs",""}));
		db.addWOD(new WODsC(251, new int[]{12,5,15,28},new String[]{"9","15","21","800 m"}, new String[]{"","","",""}));
		db.addWOD(new WODsC(252, new int[]{66,22,19,22,15,22},new String[]{"10","15","15","15","20","15"}, new String[]{"","","","","",""}));
		db.addWOD(new WODsC(253, new int[]{28,63,28,63,28},new String[]{"1 mile","21","800 m","21","1 mile"}, new String[]{"","155 lbs","","155 lbs",""}));
		db.addWOD(new WODsC(254, new int[]{40,42,48,15},new String[]{"5","10","5","20"}, new String[]{"135 lbs","135 lbs","135 lbs",""}));
		db.addWOD(new WODsC(255, new int[]{24,28,7},new String[]{"","400 m","max reps"}, new String[]{"","",""}));
		db.addWOD(new WODsC(256, new int[]{46,13},new String[]{"50","25"}, new String[]{"",""}));
		db.addWOD(new WODsC(257, new int[]{72,24,72,24},new String[]{"10","","10",""}, new String[]{"40 lbs","","40 lbs", ""}));
		//some problem in 258 or 259
	    //db.addWOD(new WODsC(258, new int[]{29,5,4,28},new String[]{"1000 m","50","50","800 m"}, new String[]{"","","",""}));	    
		
	    //db.addWOD(new WODsC(259, new int[]{49,4,32},new String[]{"","",""}, new String[]{"20 lb ball","","1.5 pood"}));
		db.addWOD(new WODsC(260, new int[]{28,41},new String[]{"400 m","29"}, new String[]{"","135 lbs"}));
		db.addWOD(new WODsC(261, new int[]{42,71},new String[]{"5","26"}, new String[]{"185 lbs",""}));
		db.addWOD(new WODsC(262, new int[]{61,15,61,5,64},new String[]{"100 m","10","100 m","10","30 seconds"}, new String[]{"","","","",""}));
		db.addWOD(new WODsC(263, new int[]{12,13,7,73,71},new String[]{"20","25","30","35","40"}, new String[]{"","","","",""}));
		db.addWOD(new WODsC(264, new int[]{74,15,40,7},new String[]{"18","18","10","10"}, new String[]{"35 lbs","","135 lbs",""}));
		db.addWOD(new WODsC(265, new int[]{56,75,6,30,4},new String[]{"50","","","",""}, new String[]{"","95 lbs","","185 lbs",""}));
		db.addWOD(new WODsC(266, new int[]{7,30,15,6},new String[]{"3","6","12","24"}, new String[]{"","225 lbs","",""}));
		db.addWOD(new WODsC(267, new int[]{24,27,58,28},new String[]{"3","10","21","400 m"}, new String[]{"","","45 lbs",""}));
		db.addWOD(new WODsC(268, new int[]{75,61,30,5,48},new String[]{"1 minute","1 minute of 20 feet sprints (20 feet forward + 20 feet backward = 1 rep)","1 minute","1 minute","1 minute"}, new String[]{"155 lbs","","245 lbs","","155 lbs"}));
		db.addWOD(new WODsC(269, new int[]{28,5,44,45},new String[]{"400 m","10","10","10"}, new String[]{"","","95 lbs","95 lbs"}));
		db.addWOD(new WODsC(270, new int[]{28,64,75,4,58,4,74,64,28},new String[]{"2 mile","2 minute","20","20","20","20","20","2 minute","2 mile"}, new String[]{"","","135 lbs","","45 lbs","","135 lbs","",""}));
		db.addWOD(new WODsC(271, new int[]{15,30,35},new String[]{"10","5","8"}, new String[]{"","75 lbs","135 lbs"}));
		db.addWOD(new WODsC(272, new int[]{28,24,45},new String[]{"800 m","3","12"}, new String[]{"45 lb barbell","","135lbs"}));
		db.addWOD(new WODsC(273, new int[]{30,15,63,9},new String[]{"12","20","12","20"}, new String[]{"225 lbs","","135 lbs",""}));
		db.addWOD(new WODsC(274, new int[]{4,45,5},new String[]{"12","6","6"}, new String[]{"","95 lbs",""}));
		db.addWOD(new WODsC(275, new int[]{19,30,7},new String[]{"6","11","10"}, new String[]{"","315 lbs",""}));
		db.addWOD(new WODsC(276, new int[]{4,5,75},new String[]{"27","20","11"}, new String[]{"","","145 lbs"}));
		db.addWOD(new WODsC(277, new int[]{42,15,30,27,36,65},new String[]{"5","18","5","18","5","18"}, new String[]{"165 lbs","","225 lbs","","165 lbs",""}));
		db.addWOD(new WODsC(278, new int[]{75,7,75,7,75,7,75,7,75,7,75,7,75,7,75,7,75,7,75,7},new String[]{"1","10","2","9","3","8","4","7","5","6","6","5","7","4","8","3","9","2","10","1"}, new String[]{"185 lbs","","185 lbs","","185 lbs","","185 lbs","","185 lbs","","185 lbs","","185 lbs","","185 lbs","","185 lbs","","185 lbs",""}));
		db.addWOD(new WODsC(279, new int[]{28,32,16,63,16,28},new String[]{"800 m","28","28","28","28","800 m"}, new String[]{"","2 pood","","2 pood","",""}));
		db.addWOD(new WODsC(280, new int[]{24,41},new String[]{"5","25"}, new String[]{"","185 lbs"}));
		db.addWOD(new WODsC(301, new int[]{49,44,4,35,29},new String[]{"","","","",""}, new String[]{"","75","","75",""}));
		db.addWOD(new WODsC(302, new int[]{29,46,15,22,26},new String[]{"","","","",""}, new String[]{"","","","",""}));
		db.addWOD(new WODsC(303, new int[]{15,22,26,46},new String[]{"","","",""}, new String[]{"","","",""}));
		db.addWOD(new WODsC(304, new int[]{46,32,15},new String[]{"80-64-50-32-16-8","40-32-25-16-8-4","20-16-12-8-4-2"}, new String[]{"","1.5/1 pood",""}));
		db.addWOD(new WODsC(305, new int[]{41,76,30},new String[]{"","",""}, new String[]{"","",""}));
		db.addWOD(new WODsC(306, new int[]{46,12,70},new String[]{"50","7","10"}, new String[]{"","","135/95 lbs"}));
		db.addWOD(new WODsC(307, new int[]{29,7,45,66},new String[]{"750 m","20","20","20"}, new String[]{"","","115/80 lbs",""}));
		db.addWOD(new WODsC(308, new int[]{4,20,32,58,9,35,2,49,5,6},new String[]{"50","50","50","50 steps","50","50","50","50","50","50"}, new String[]{"","","","","","45/35 lbs","","20 lb ball","",""}));
		db.addWOD(new WODsC(309, new int[]{40,42,35,41,35},new String[]{"","","","",""}, new String[]{"","","","",""}));
		
		
		//add workout table
		//public workoutC(int wod_id, String workout_name, String workout_description , int timed, int AMRAP)
		// accroding the wods table
		db.addWorkOut(new workoutC(101,"Angie","for time; complete all reps of each exercise before moving on to the next",1,0,0) );
		db.addWorkOut(new workoutC(102,"Barbara","5 rounds, each for time. Rest three minutes between each round",1,0,0) );
		db.addWorkOut(new workoutC(103,"Chelsea","each minute on the minute for 30 minutes",0,1,30) );
		db.addWorkOut(new workoutC(104,"Cindy","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(105,"Diane","21-15-9 reps for time",1,0,0) );
		db.addWorkOut(new workoutC(106,"Elizabeth","21-15-9 reps for time",1,0,0) );
		db.addWorkOut(new workoutC(107,"Fran","21-15-9 reps for time",1,0,0) );
		db.addWorkOut(new workoutC(108,"Grace","30 reps for time",1,0,0) );
		db.addWorkOut(new workoutC(109,"Helen","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(110,"Isabel","30 reps for time",1,0,0) );
		db.addWorkOut(new workoutC(111,"Jackie","for time",1,0,0) );
		db.addWorkOut(new workoutC(112,"Karen","for time",1,0,0) );
		db.addWorkOut(new workoutC(113,"Linda","10/9/8/7/6/5/4/3/2/1 rep rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(114,"Mary","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(115,"Nancy","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(116,"Annie","50/40/30/20/10 rep rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(117,"Eva","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(118,"Kelly","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(119,"Lynne","5 rounds for max reps",1,0,0) );
		db.addWorkOut(new workoutC(120,"Nicole","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(121,"Amanda","9-7-5 reps for time",1,0,0) );
		db.addWorkOut(new workoutC(201,"JT","21-15-9 reps for time",1,0,0) );
		db.addWorkOut(new workoutC(202,"Michael","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(203,"Murph","for time; partition the pull-ups, push-ups, and squats as needed and start and finish with a mile run",1,0,0) );
		db.addWorkOut(new workoutC(204,"Daniel","for time",1,0,0) );
		db.addWorkOut(new workoutC(205,"Josh","for time",1,0,0) );
		db.addWorkOut(new workoutC(206,"Jason","for time",1,0,0) );
		db.addWorkOut(new workoutC(207,"Badger","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(208,"Joshie","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(209,"Nate","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(210,"Randy","for time",1,0,0) );
		db.addWorkOut(new workoutC(211,"Tommy V","for time",1,0,0) );
		db.addWorkOut(new workoutC(212,"Griff","for time",1,0,0) );
		db.addWorkOut(new workoutC(213,"Ryan","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(214,"Erin","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(215,"Mr. Joshua","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(216,"DT","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(217,"Danny","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(218,"Hansen","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(219,"Tyler","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(220,"Lumberjack 20","for time",1,0,0) );
		db.addWorkOut(new workoutC(221,"Stephen","30-25-20-15-10-5 rep rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(222,"Garret","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(223,"War Frank","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(224,"McGhee","AMRAP in 30 minutes",0,1,30) );
		db.addWorkOut(new workoutC(225,"Paul","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(226,"Jerry","for time",1,0,0) );
		db.addWorkOut(new workoutC(227,"Nutts","for time",1,0,0) );
		db.addWorkOut(new workoutC(228,"Arnie","for time, with a single 2 pood kettlebell",1,0,0) );
		db.addWorkOut(new workoutC(229,"The Seven","7 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(230,"RJ","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(231,"Luce","3 rounds for time while wearing a 20 lb vest",1,0,0) );
		db.addWorkOut(new workoutC(232,"Johnson","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(233,"Roy","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(234,"AdamBrown","2 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(235,"Coe","10 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(236,"Severin","for time while wearing a 20 lb vest",1,0,0) );
		db.addWorkOut(new workoutC(237,"Helton","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(238,"Jackie","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(239,"Forrest","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(240,"Bulger","10 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(241,"Brenton","5 rounds for time while wearing a 20 lb vest",1,0,0) );
		db.addWorkOut(new workoutC(242,"Blake","4 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(243,"Colin","6 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(244,"Thompson","10 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(245,"Whitten","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(246,"Bull","2 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(247,"Rankel","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(248,"Holbrook","10 rounds, each round for time; 1 minute rest after each round",1,0,0) );
		db.addWorkOut(new workoutC(249,"Ledesma","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(250,"Wittman","7 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(251,"McCluskey","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(252,"Weaver","4 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(253,"Abbate","for time",1,0,0) );
		db.addWorkOut(new workoutC(254,"Hammer","5 rounds, each round for time; rest 90 seconds between each round",1,0,0) );
		db.addWorkOut(new workoutC(255,"Moore","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(256,"Wilmot","6 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(257,"Moon","7 rounds for time; alternate feet in the split snatch sets",1,0,0) );
		db.addWorkOut(new workoutC(258,"Small","for time",1,0,0) );
		db.addWorkOut(new workoutC(259,"Morrison","50-40-30-20-10 rep rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(260,"Manion","7 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(261,"Gator","8 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(262,"Bradley","10 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(263,"Meadows","for time",1,0,0) );
		db.addWorkOut(new workoutC(264,"Santiago","7 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(265,"Carse","21-18-15-12-9-6-3 reps for time",1,0,0) );
		db.addWorkOut(new workoutC(266,"Bradshaw","10 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(267,"White","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(268,"Santora","3 rounds for reps; 1 minute rest after each round",1,0,0) );
		db.addWorkOut(new workoutC(269,"Wood","5 rounds for time; 1 minute rest after each round",1,0,0) );
		db.addWorkOut(new workoutC(270,"Hildago","for time while wearing a 20 lb vest",1,0,0) );
		db.addWorkOut(new workoutC(271,"Ricky","AMRAP in 20 minutes",0,1,20) );
		db.addWorkOut(new workoutC(272,"Dae Han","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(273,"Desforges","5 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(274,"Rahoi","AMRAP in 12 minutes",0,1,12) );
		db.addWorkOut(new workoutC(275,"Zimmerman","AMRAP in 25 minutes",0,1,25) );
		db.addWorkOut(new workoutC(276,"Klepto","4 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(277,"Pheezy","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(278,"JJ","for time",1,0,0) );
		db.addWorkOut(new workoutC(279,"Jag 28","for time",1,0,0) );
		db.addWorkOut(new workoutC(280,"Brian","for time",1,0,0) );
		db.addWorkOut(new workoutC(301,"Fight Gone Bad","move from each station after 1 minute; 5 minute round for 3 to 5 rounds; 1 minute break between each round",0,0,0) );//missing bool values here
		db.addWorkOut(new workoutC(302,"Tabatha This","Tabata intervals: 20 sec work / 10 sec rest x8; 1 minute rest between stations",0,1,30) );//what is time for this one?
		db.addWorkOut(new workoutC(303,"Tabatha Something Else","32 intervals of 20 sec work / 10 sec rest; clock does not stop",0,1,16) );
		db.addWorkOut(new workoutC(304,"Jonesworthy","6 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(305,"Crossfit Total","the sum of the best of three attempts",0,0,0) );//what is this one for?
		db.addWorkOut(new workoutC(306,"Nasty Girls","3 rounds for time",1,0,0) );
		db.addWorkOut(new workoutC(307,"Twins","2 rounds, for each couplet, for time",1,0,0) );
		db.addWorkOut(new workoutC(308,"Filthy Fifty","for time",1,0,0) );
		db.addWorkOut(new workoutC(309,"The Bear","7 sets of the sequence; 5 rounds with a rest between rounds to load up; work up to max load on 5th round",1,0,0) );
		
		db.close();
	}
	
}
