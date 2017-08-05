package cse110.crossfit.IDEAproject.ModelsData;

import android.text.format.Time;

/*
 * exercise constructor  
 */
public class exerciseC {
	int exercise_id;
	String _exerciseName;
	String _descrption;
	
	//empty constructor
	public exerciseC(){
		
	}
	
	public exerciseC(int exercise_id, String _exerciseName, String _description ){
		this.exercise_id = exercise_id;
		this._exerciseName = _exerciseName;

		this._descrption = _description;
	}
	public exerciseC(String _exercise, String _description){
		this._exerciseName = _exercise;

		this._descrption = _description;

	}
	public exerciseC(String _exercise){
		this._exerciseName = _exercise;
	

	}
	 
    // getting ID
    public int getExerciseID(){
        return this.exercise_id;
    }
 
    // setting id
    public void setExerciseID(int exercise_id){
        this.exercise_id = exercise_id;
    } 
    //getting exercise
    public String getExerciseName(){
    	return this._exerciseName;
    }
    //setting exercise
    public void setExerciseName(String _exerciseName){
    	this._exerciseName =_exerciseName;
    }
  
   
    //getting description
    public String getDescription(){
    	return this._descrption;
    }
    //setting description 
    public void setDescription(String _description)
    {
    	this._descrption = _description;
    }
  


}
