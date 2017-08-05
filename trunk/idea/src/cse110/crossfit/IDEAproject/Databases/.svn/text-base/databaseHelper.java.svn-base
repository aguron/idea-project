package cse110.crossfit.IDEAproject.Databases;

import java.util.ArrayList;
import java.util.List;

import cse110.crossfit.IDEAproject.ModelsData.WODsC;
import cse110.crossfit.IDEAproject.ModelsData.benchmarkC;
import cse110.crossfit.IDEAproject.ModelsData.exerciseC;
import cse110.crossfit.IDEAproject.ModelsData.noteC;
import cse110.crossfit.IDEAproject.ModelsData.weightC;
import cse110.crossfit.IDEAproject.ModelsData.workoutC;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseHelper  extends SQLiteOpenHelper {
	
	public static final int VERSION = 17;
	public static final String DATABASENAME = "database.db";
	//table name
	public static final String TABLE_HISTORY = "history_table";
	public static final String TABLE_NOTES = "notes_table";
	public static final String TABLE_WEIGHT = "weights_table";
	public static final String TABLE_WODS = "WODS_table";
	public static final String TABLE_EXERCISE = "exercise_table";
	public static final String TABLE_WORKOUT = "workout_table";
	
	// ID!!
	public static final String KEY_ID = "_id";
	//benchmark 
	public static final String KEY_BENCHMARK_ID = "benchmark_id";
	public static final String KEY_BENCHMARK_DATE = "benchmark_date";
	public static final String KEY_BENCHMARK_TEXT = "benchmark_text";
	public static final String KEY_BENCHMARK_TIMED = "time";
	public static final String KEY_BENCHMARK_WORKOUT_ID = "workout_id";
	public static final String KEY_REPS = "reps";
	//exercise
	public static final String KEY_EXERCISE_ID = "exercise_id";
	public static final String KEY_EXERCISE_NAME = "exercise_name";
	public static final String KEY_EXERICSE_DESCRIPTION = "exercise_description";
	//wod
	public static final String KEY_WOD_ID = "wod_id";
	public static final String KEY_WOD_REP = "wod_rep";
	public static final String KEY_WOD_WEIGHTS = "wod_weight";
	public static final String KEY_WOD_EXERCISE_NAME = "wod_exercise_name";
	//workout
	public static final String KEY_WORKOUT_ID = "workout_id";
	public static final String KEY_WORKOUT_NAME = "workout_name";
	public static final String KEY_WORKOUT_TEXT = "workout_text";
	public static final String KEY_WORKOUT_TIMED = "workout_timed";
	public static final String KEY_WORKOUT_AMRAP = "workout_amrap";
	public static final String KEY_WORKOUT_DESCRIPTION = "workout_description";
	public static final String KEY_WORKOUT_TIMELIMIT = "time_limit";
	//notes
	public static final String KEY_NOTES_ID = "notes_id";
	public static final String KEY_NOTES_TEXT = "notes_text";
	public static final String KEY_NOTES_DATE = "notes_date";
	public static final String KEY_NOTES_TITLE = "notest_title";
	//weight
	public static final String KEY_WIEGHT_ID = "weight_id";
	public static final String KEY_WEIGHT = "weight";
	public static final String KEY_WEIGHT_DATE = "weight_date";
	
	//benchmark create table textnote
	public static final String HISTORY_ONCREATE = "CREATE TABLE " + TABLE_HISTORY + "("
            + KEY_BENCHMARK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_BENCHMARK_WORKOUT_ID + " int,"
            + KEY_REPS + " int, "  + KEY_BENCHMARK_TIMED + " TEXT," + 
             KEY_BENCHMARK_DATE + " TEXT" +" )";
	
	//exercise create table text
	public static final String EXERCISE_ONCREATE = "CREATE TABLE " + TABLE_EXERCISE + "("
            + KEY_EXERCISE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_EXERCISE_NAME + " text,"
            + KEY_EXERICSE_DESCRIPTION + " TEXT)";
	
	//wod create table text
	
	public static final String WOD_ONCREATE = "CREATE TABLE " + TABLE_WODS + "(" +
			KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_WOD_ID + " int," + KEY_WOD_EXERCISE_NAME + " TEXT,"
            + KEY_WOD_REP + " TEXT," +  KEY_WOD_WEIGHTS + " TEXT)";
	
	//workout create table text
	public static final String WORKOUT_ONCREATE = "CREATE TABLE " + TABLE_WORKOUT + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  KEY_WORKOUT_ID + " int," + KEY_WORKOUT_TEXT + " TEXT,"
            + KEY_WORKOUT_NAME + " TEXT," +  KEY_WORKOUT_DESCRIPTION + " TEXT," + KEY_WORKOUT_TIMED  + " int," 
            + KEY_WORKOUT_AMRAP + " int," +  KEY_WORKOUT_TIMELIMIT +" int)";
	
	//weight create table text
	public static final String WEIGHT_ONCREATE = "CREATE TABLE " + TABLE_WEIGHT + "("
            + KEY_WIEGHT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_WEIGHT + " real,"
            + KEY_WEIGHT_DATE + " TEXT)";

	//note create table text
	public static final String NOTE_ONCREATE = "CREATE TABLE " + TABLE_NOTES + "("
            + KEY_NOTES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_NOTES_TITLE + " TEXT,"
            + KEY_NOTES_TEXT + " TEXT," + KEY_NOTES_DATE + " TEXT)";
	

	//create a databse file which call database.db
	public databaseHelper(Context context) {
		super(context, DATABASENAME, null, VERSION);
	}

	// created those table
	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println(" success database");
	    db.execSQL(HISTORY_ONCREATE);
	    db.execSQL(WEIGHT_ONCREATE);
	    db.execSQL(EXERCISE_ONCREATE);
	    db.execSQL(WOD_ONCREATE);
	    db.execSQL(WORKOUT_ONCREATE);
	    db.execSQL(NOTE_ONCREATE);
	}
	//if the database exists then do the updrage
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		System.out.println("ON Benchmark upgrade HELPER");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
		db.execSQL("DROP TABLE IF EXISTS " + WEIGHT_ONCREATE);
	    db.execSQL("DROP TABLE IF EXISTS " + EXERCISE_ONCREATE);
	    db.execSQL("DROP TABLE IF EXISTS " + WOD_ONCREATE);
	    db.execSQL("DROP TABLE IF EXISTS " + WORKOUT_ONCREATE);
	    db.execSQL("DROP TABLE IF EXISTS " + NOTE_ONCREATE);
		
		onCreate(db);
	}
	
	//add BenchMark
	public void addBenchMark(benchmarkC BM)
	{
		 SQLiteDatabase db = this.getWritableDatabase();
		 ContentValues cv = new ContentValues();	
		 cv.put(KEY_BENCHMARK_WORKOUT_ID, BM.getWorkoutID());
		 cv.put(KEY_REPS,BM.getReps());
		
		 cv.put(KEY_BENCHMARK_TIMED, BM.getTime());
		 cv.put(KEY_BENCHMARK_DATE, BM.getBenchmarkDate());
		
		 db.insert(TABLE_HISTORY, null, cv);
		 db.close();		
	}
	//get benchmark
	public benchmarkC getBenchmark(int id){
		 SQLiteDatabase db = this.getWritableDatabase();
		 Cursor cursor = db.query(TABLE_HISTORY, new String[] { KEY_BENCHMARK_ID,
				 KEY_BENCHMARK_WORKOUT_ID, KEY_REPS, 
				KEY_BENCHMARK_TIMED,KEY_BENCHMARK_DATE}, KEY_BENCHMARK_ID + "=?",
	                new String[] { String.valueOf(id) }, null, null, null, null);
		 benchmarkC temp = new benchmarkC();
		 if(cursor.moveToNext())
		 {
			 temp.setBenchmarkID(cursor.getInt(0));
			 temp.setWorkoutID(cursor.getInt(1));
			 temp.setReps(cursor.getInt(2));
			 temp.setTime(cursor.getString(3));
			 temp.setBenchmarkDate(cursor.getString(4));
			 return temp;
		
		 }
		cursor.close();
		return null;
	}
	//get benchmark
		public benchmarkC getBenchmark(String date){
			 SQLiteDatabase db = this.getWritableDatabase();
			 Cursor cursor = db.query(TABLE_HISTORY, new String[] { KEY_BENCHMARK_ID,
					 KEY_BENCHMARK_WORKOUT_ID, KEY_REPS, 
					KEY_BENCHMARK_TIMED,KEY_BENCHMARK_DATE}, KEY_BENCHMARK_DATE + "=?",
		                new String[] { date }, null, null, null, null);
			 benchmarkC temp = new benchmarkC();
			 
			
			 if(cursor.moveToNext())
			 {
				 temp.setBenchmarkID(cursor.getInt(0));
				 temp.setWorkoutID(cursor.getInt(1));
				 temp.setReps(cursor.getInt(2));
				 temp.setTime(cursor.getString(3));
				 temp.setBenchmarkDate(cursor.getString(4));
				 return temp;
			
			 }
			cursor.close();
			return null;
		}
	
	//add Exercise
	public void  addExercise(exerciseC ex)
	{
		 SQLiteDatabase db = this.getWritableDatabase();
		 ContentValues cv = new ContentValues();
		 cv.put(KEY_EXERCISE_NAME, ex.getExerciseName());
		 cv.put(KEY_EXERICSE_DESCRIPTION, ex.getDescription());
		 db.insert(TABLE_EXERCISE, null, cv);
		 db.close();
	}
	
	//get exercise
	public exerciseC getExercise(int id){
		
		SQLiteDatabase db = this.getReadableDatabase(); 
		Cursor cursor = db.query(TABLE_EXERCISE, new String[] { KEY_EXERCISE_ID,
				KEY_EXERCISE_NAME, KEY_EXERICSE_DESCRIPTION }, KEY_EXERCISE_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
	        while(cursor.moveToNext()){	        	
		       exerciseC temp = new exerciseC();
		       temp.setExerciseID(cursor.getInt(cursor.getColumnIndex(KEY_EXERCISE_ID)));
		       temp.setExerciseName(cursor.getString(1));
		       temp.setDescription(cursor.getString(2));
		       return temp;
		 
	        }
	      
		 //return the exercise
	        cursor.close();
		 return null;
	}
	
	//get count for exercise
	public int getExerciseCount(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery("select count(*) from " + TABLE_EXERCISE, null);
		
		cursor.moveToFirst();
		int count = cursor.getInt(0);
		cursor.close();
		return count;
	}

	
	//add workout
	public void addWorkOut(workoutC wo)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		 ContentValues cv = new ContentValues();
		   workoutC tempEx = new workoutC();
		 	List<String> temps = null;
		 	String temp =  "";
		
		       Cursor cursor = db.query(TABLE_WODS, new String[] { KEY_ID, KEY_WOD_ID,
		        		KEY_WOD_EXERCISE_NAME, KEY_WOD_REP, KEY_WOD_WEIGHTS }, KEY_WOD_ID + "=?",
		        		new String[] { String.valueOf(wo.getWODID()) }, null,  null, KEY_WOD_ID + " DESC");	
		     
		       
		        while(cursor.moveToNext()){
		        	if(cursor.getString(3).length() == 0)
		        		temp = cursor.getString(2) ;
		        	else
		        		temp = cursor.getString(2) + ", ";
			       if(cursor.getString(4).length() == 0)
			    	   temp += cursor.getString(3);
			       else
			    	   temp += cursor.getString(3) +", " +cursor.getString(4);       
			       	 cv.put(KEY_WORKOUT_ID, wo.getWODID());
			       	 cv.put(KEY_WORKOUT_TEXT, temp);
					 cv.put(KEY_WORKOUT_NAME, wo.getWorkoutName());
					 cv.put(KEY_WORKOUT_DESCRIPTION, wo.getWorkoutDescription());
					 cv.put(KEY_WORKOUT_TIMED, wo.getTime());
					 cv.put(KEY_WORKOUT_AMRAP, wo.getAMRAP());
					 cv.put(KEY_WORKOUT_TIMELIMIT, wo.getWorkoutTimeLimit());
					 db.insert(TABLE_WORKOUT, null, cv);
					 temp = "";
			       
		        }	
		 db.close();
	}
	
	//getting workout
     public workoutC getWorkOut(int id){
                
                 SQLiteDatabase db = this.getWritableDatabase();
                
                   Cursor cursor = db.query(TABLE_WORKOUT, new String[] { KEY_ID, KEY_WORKOUT_ID,
                                   KEY_WORKOUT_TEXT, KEY_WORKOUT_NAME, KEY_WORKOUT_DESCRIPTION, KEY_WORKOUT_TIMED,
                                   KEY_WORKOUT_AMRAP, KEY_WORKOUT_TIMELIMIT}, KEY_WORKOUT_ID + "=?",
                                new String[] { String.valueOf(id) }, null,  null, null);
                   
                workoutC temp = new workoutC();
                List<String> workoutTexts = new ArrayList<String> ();
                String workoutText = "";
                if(cursor.moveToNext()){
                      
                   do{
                           workoutText = cursor.getString(2);
                           workoutTexts.add(workoutText);
                           temp.setWorkoutID(cursor.getInt(1));
                           temp.setWorkoutName(cursor.getString(3));
                           temp.setWorkoutDescription(cursor.getString(4));
                           temp.setTimed(cursor.getInt(5));
                           temp.setAMRAP(cursor.getInt(6));
                           temp.setWorkoutTimeLimit(cursor.getInt(7));
                           
                       }while(cursor.moveToNext());
                   String[] tempworkoutText = workoutTexts.toArray(new String[workoutTexts.size()]);;
           
               
                       
                       workoutTexts.toArray(tempworkoutText);
                
               
                   temp.setWorkOutText(tempworkoutText);
                             
                   return temp;
                }
                cursor.close();
                 return null;
        }
	
     
     //get workout by name
     public workoutC getWorkOut(String workoutName){
         
         SQLiteDatabase db = this.getWritableDatabase();
       
           Cursor cursor = db.query(TABLE_WORKOUT, new String[] { KEY_ID, KEY_WORKOUT_ID,
                           KEY_WORKOUT_TEXT, KEY_WORKOUT_NAME, KEY_WORKOUT_DESCRIPTION, KEY_WORKOUT_TIMED,
                           KEY_WORKOUT_AMRAP, KEY_WORKOUT_TIMELIMIT}, KEY_WORKOUT_NAME + "=?",
                        new String[] { workoutName }, null,  null, null);
           
        workoutC temp = new workoutC();
        List<String> workoutTexts = new ArrayList<String> ();
        String workoutText = "";
        if(cursor.moveToNext()){
               
           do{
                   workoutText = cursor.getString(2);
                   workoutTexts.add(workoutText);
                   temp.setWorkoutID(cursor.getInt(1));
                   temp.setWorkoutName(cursor.getString(3));
                   temp.setWorkoutDescription(cursor.getString(4));
                   temp.setTimed(cursor.getInt(5));
                   temp.setAMRAP(cursor.getInt(6));
                   temp.setWorkoutTimeLimit(cursor.getInt(7));
                   
               }while(cursor.moveToNext());
           String[] tempworkoutText = workoutTexts.toArray(new String[workoutTexts.size()]);;
   
     
               
               workoutTexts.toArray(tempworkoutText);
        
       
           temp.setWorkOutText(tempworkoutText);
                     
           return temp;
        }
        cursor.close();
         return null;
}
     
     //get workout by name
     public workoutC getWorkOutByPK(int id){
         
         SQLiteDatabase db = this.getWritableDatabase();
        
           Cursor cursor = db.query(TABLE_WORKOUT, new String[] { KEY_ID, KEY_WORKOUT_ID,
                           KEY_WORKOUT_TEXT, KEY_WORKOUT_NAME, KEY_WORKOUT_DESCRIPTION, KEY_WORKOUT_TIMED,
                           KEY_WORKOUT_AMRAP, KEY_WORKOUT_TIMELIMIT}, KEY_ID + "=?",
                        new String[] { String.valueOf(id) }, null,  null, null);
           
        workoutC temp = new workoutC();
        List<String> workoutTexts = new ArrayList<String> ();
        String workoutText = "";
        if(cursor.moveToNext()){
                
           do{
                   workoutText = cursor.getString(2);
                   workoutTexts.add(workoutText);
                   temp.setWorkoutID(cursor.getInt(1));
                   temp.setWorkoutName(cursor.getString(3));
                   temp.setWorkoutDescription(cursor.getString(4));
                   temp.setTimed(cursor.getInt(5));
                   temp.setAMRAP(cursor.getInt(6));
                   temp.setWorkoutTimeLimit(cursor.getInt(7));
                   
               }while(cursor.moveToNext());
           String[] tempworkoutText = workoutTexts.toArray(new String[workoutTexts.size()]);;
   
         
               
               workoutTexts.toArray(tempworkoutText);
        
   
           temp.setWorkOutText(tempworkoutText);
                     
           return temp;
        }
        cursor.close();
         return null;
}
	//count workout
	public int getWorkOutCount(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery("select count(*) from " + TABLE_WORKOUT, null);
		
		cursor.moveToFirst();
		int count = cursor.getInt(0);
		cursor.close();
		return count;
	}
	//get the wods id according the primary key
    	public int getWorkOutid(int id){
			SQLiteDatabase db = this.getReadableDatabase();
			Cursor cursor = db.query(TABLE_WORKOUT, new String[] { KEY_ID,
					KEY_WORKOUT_ID}, KEY_ID + "=?",
	                new String[] { String.valueOf(id) }, null, null, null, null);
		    
		        
		        if(cursor.moveToNext()){
		        	return cursor.getInt(cursor.getColumnIndex(KEY_WORKOUT_ID));
		        }
		        
		        return 0;
			
		}
	
	
	//add weight
	public void addWeight(weightC w){
		SQLiteDatabase db = this.getWritableDatabase();
		 ContentValues cv = new ContentValues();
		 cv.put(KEY_WEIGHT, w.getWeight()[0]);
		 cv.put(KEY_WEIGHT_DATE, w.getWeightDate());
		 db.insert(TABLE_WEIGHT, null, cv);
		 db.close();
	}

	
	public boolean updateWeight(weightC w) {
		SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(KEY_WEIGHT, w.getWeight()[0]);
        args.put(KEY_WEIGHT_DATE, w.getWeightDate());
        boolean retval = db.update(TABLE_WEIGHT, args, KEY_WIEGHT_ID + "=" + w.getWieghtID(), null) > 0;
        db.close();
        return retval;
    }
    	


	//get weight
	public weightC getWeight(int id){
		
		SQLiteDatabase db = this.getWritableDatabase();	
	
		Cursor cursor = db.query(TABLE_WEIGHT, new String[] {
				KEY_WIEGHT_ID, KEY_WEIGHT, KEY_WEIGHT_DATE}, KEY_WIEGHT_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

		weightC tempWeight = new weightC();
		if(cursor.moveToNext())
		{	
			tempWeight.setWieghtID(cursor.getInt(0));
			Double[] temp = {cursor.getDouble(1)};
			tempWeight.setWeight(temp);
			tempWeight.setWeightDate(cursor.getString(2));
			
			return tempWeight;
		}
		cursor.close();
		return null;
	}
	
	//get weight by date
	public weightC getWeight(String date){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(TABLE_WEIGHT, new String[] {
				KEY_WIEGHT_ID, KEY_WEIGHT, KEY_WEIGHT_DATE}, KEY_WEIGHT_DATE + "=?",
                new String[] { date }, null, null, null, null);
		weightC temp = new weightC();
		List<Double> tempWeight= new ArrayList<Double>(); 
		if(cursor.moveToNext())
		{
			do{
			temp.setWieghtID(cursor.getInt(0));
			tempWeight.add(cursor.getDouble(1));
			
			temp.setWeightDate(cursor.getString(2));	
		
			}while(cursor.moveToNext());
			 Double[] tempArrWeight = tempWeight.toArray(new Double[tempWeight.size()]);
			 temp.setWeight(tempArrWeight);
			return temp;
		}
		
		
		 cursor.close();
		 return null;	
		
	}
	
	//get weight count (primary key)
		public int getWeightCount(){
			SQLiteDatabase db = this.getReadableDatabase();
			Cursor cursor = db.rawQuery("select count(*) from " + TABLE_WEIGHT, null);		
			cursor.moveToFirst();
			int count = cursor.getInt(0);
			cursor.close();
			return count;
		}
		
	
	
	
	//add note
	
	public void addNote(noteC note){
		SQLiteDatabase db = this.getWritableDatabase();
		 ContentValues cv = new ContentValues();
		 cv.put(KEY_NOTES_TITLE, note.getNotesTitle());
		 cv.put(KEY_NOTES_TEXT, note.getNotesText());
		 cv.put(KEY_NOTES_DATE, note.getNotesDate());
		 db.insert(TABLE_NOTES, null, cv);
		 db.close();
	}
	
	//get note
	public noteC getNote(int id){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(TABLE_NOTES, new String[] { KEY_NOTES_ID,
				KEY_NOTES_TITLE, KEY_NOTES_TEXT, KEY_NOTES_DATE}, KEY_NOTES_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
		noteC temp = new noteC();
		
		if(cursor.moveToNext())
		{
			temp.setNotesID(cursor.getInt(0));
			temp.setNotesTitle(cursor.getString(1));
			temp.setNotesText(cursor.getString(2));
			temp.setNotesDate(cursor.getString(3));
			return temp;
		}
		cursor.close();
		return null;
		
	}
	
	// get note by title
	public noteC getNote(String title){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.query(TABLE_NOTES, new String[] { KEY_NOTES_ID,
				KEY_NOTES_TITLE, KEY_NOTES_TEXT, KEY_NOTES_DATE}, KEY_NOTES_TITLE + "=?",
                new String[] { title }, null, null, null, null);
		noteC temp = new noteC();
		
		if(cursor.moveToNext())
		{
			temp.setNotesID(cursor.getInt(0));
			temp.setNotesTitle(cursor.getString(1));
			temp.setNotesText(cursor.getString(2));
			temp.setNotesDate(cursor.getString(3));
			return temp;
		}
		cursor.close();
		return null;
		
	}
	
	//delete note by id
	public void deleteNote(int id){
		
		SQLiteDatabase db = this.getWritableDatabase();
		//db.delete(TABLE_NOTES, KEY_NOTES_ID + "=?", new String[]{String.valueOf(id)});
		
	    db.delete(TABLE_NOTES, KEY_NOTES_ID+"="+id, null);
	}
	
	//delete note by date
	public void deleteNote(String title){
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_NOTES, KEY_NOTES_TITLE + "=?", new String[]{title});
	}
	
	//get all the note and return the List<noteC>
	public List<noteC> getAllnote(){
		SQLiteDatabase db = this.getWritableDatabase();
		List<noteC> tempList = new ArrayList<noteC>();		
		
		Cursor cr = db.query(TABLE_NOTES, new String[] { KEY_NOTES_ID,
				KEY_NOTES_TITLE, KEY_NOTES_TEXT, KEY_NOTES_DATE}, null, null, null, null, null, null );
	
		while(cr.moveToNext()){ 
			noteC tempNote = new noteC();
		
		tempNote.setNotesTitle(cr.getString(1));
		tempNote.setNotesText(cr.getString(2));
		tempNote.setNotesDate(cr.getString(3));
		tempList.add(tempNote);
		System.out.println("in while");
		}
		System.out.println("after while");
		cr.close();
		return tempList;
	}
	
	//updateNote
	public boolean updateNote(int id, String title, String body) {
		SQLiteDatabase db = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put(KEY_NOTES_TITLE, title);
        args.put(KEY_NOTES_TEXT, body);
        boolean retval = db.update(TABLE_NOTES, args, KEY_NOTES_ID + "=" + id, null) > 0;
        db.close();
        return retval;
    }
	
	//get note count (primary key)
		public int getNoteCount(){
			SQLiteDatabase db = this.getReadableDatabase();
			Cursor cursor = db.rawQuery("select count(*) from " + TABLE_NOTES, null);
			
			cursor.moveToFirst();
			int count = cursor.getInt(0);
			cursor.close();
			return count;
		}
	
	
	//add wod
	public void addWOD(WODsC wod){
		
		 SQLiteDatabase db = this.getWritableDatabase();
		 ContentValues cv = new ContentValues();
		 String exerciseName = "";
		 // getting exerciseC
		 String selectQuery = "select " + KEY_EXERCISE_ID + "," +
					KEY_EXERCISE_NAME + ","  + KEY_EXERICSE_DESCRIPTION + " from "
					+ TABLE_EXERCISE + " where "  + KEY_EXERCISE_ID + "=?";
	
		 int[] tempGroupInt = wod.getExerciseID();
		 exerciseC tempEx = new exerciseC();
		 for(int i = 0; i < tempGroupInt.length; i++) { 	
				int tempInt = tempGroupInt[i];
		        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(tempInt)});    
		        if(cursor.moveToNext()){
			       tempEx.setExerciseID(cursor.getInt(cursor.getColumnIndex(KEY_EXERCISE_ID)));
			       tempEx.setExerciseName(cursor.getString(1));
			       tempEx.setDescription(cursor.getString(2));     
		        }    
		         cv.put(KEY_WOD_ID, wod.getWODID());
				 cv.put(KEY_WOD_EXERCISE_NAME, cursor.getString(1));
				 cv.put(KEY_WOD_REP, wod.getWODRep()[i]);
				 cv.put(KEY_WOD_WEIGHTS, wod.getWODWieght()[i]);
				 db.insert(TABLE_WODS, null, cv);
	    }
		 db.close();
	}
	
	//get wods by the wodsID
	public WODsC getWOD(int id){
		 SQLiteDatabase db = this.getWritableDatabase();
		 String selectQuery = "select " + KEY_ID + "," +  KEY_WOD_ID + "," +
				 KEY_WOD_EXERCISE_NAME + ","  + KEY_WOD_REP + "," +  KEY_WOD_WEIGHTS + " from "
					+ TABLE_WODS + " where "  + KEY_WOD_ID + "=?";
		 
	    
	        Cursor cursor = db.rawQuery(selectQuery, new String[]{String.valueOf(id)});
	        WODsC temp = new WODsC();
	        List<String> exerciseNames = new ArrayList<String> ();
	        List<String> wod_reps= new ArrayList<String> ();
	        List<String> wod_weights= new ArrayList<String> ();
	       
	        String exerciseName = "";
	        String wod_rep = "";
	        String wod_weight = "";        
	        if(cursor.moveToNext()){
	        	
	           do{
	        	   
	           temp.setWODID(cursor.getInt(cursor.getColumnIndex(KEY_WOD_ID)));
		       exerciseName = cursor.getString(2);
		       exerciseNames.add(exerciseName);
		       wod_rep = cursor.getString(3);
		       wod_reps.add(wod_rep);
		       wod_weight = cursor.getString(4);
		       wod_weights.add(wod_weight);
		       
		       }while(cursor.moveToNext());
	           String[] tempExercise = exerciseNames.toArray(new String[exerciseNames.size()]);;
	           String[] tempRep = wod_reps.toArray( new String[wod_reps.size()]);
	           String[] tempWeight = wod_weights.toArray( new String[wod_weights.size()]);
		      
		       
	           exerciseNames.toArray(tempExercise);
	           wod_reps.toArray(tempRep);
	           wod_weights.toArray(tempWeight);
	         
	         
	           temp.setExerciseName(tempExercise);
	           temp.setWODRep(tempRep);
	           temp.setWODWieght(tempWeight);
	           
	           
	           return temp;
	        }
	        
	        cursor.close();
		 return null;
	}
	
	//get wods count (primary key)
	public int getWODSCount(){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery("select count(*) from " + TABLE_WODS, null);
		
		cursor.moveToFirst();
		int count = cursor.getInt(0);
		cursor.close();
		return count;
	}
	
	//get the wods id according the primary key
	public int getWODSwodid(int id){
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_WODS, new String[] { KEY_ID,
				KEY_WOD_ID}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
	    
	        
	        if(cursor.moveToNext()){
	        	return cursor.getInt(cursor.getColumnIndex(KEY_WOD_ID));
	        }
	        
	        return 0;
		
	}
	//get the Histerory table Count
	  public int getHistoryCount(){
          SQLiteDatabase db = this.getReadableDatabase();
          Cursor cursor = db.rawQuery("select count(*) from " + TABLE_HISTORY, null);
          
          cursor.moveToFirst();
          int count = cursor.getInt(0);
          cursor.close();
          return count;
  }
	
}
