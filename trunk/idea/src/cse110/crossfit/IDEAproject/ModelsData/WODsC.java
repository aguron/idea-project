package cse110.crossfit.IDEAproject.ModelsData;

// wods table constructor
public class WODsC {
	int wod_id;
	int[] exercise_id;
	String[] exercise_name;
	String[] wod_rep;
	String[] wod_weights;
	//empty
	public WODsC(){
		
	}
	//full constructor 
	public WODsC(int wod_id, int[] exercise_id , String[] exercise_name, String[] wod_rep, String[] wod_weights ){
		this.wod_id = wod_id;
		this.exercise_id = exercise_id;
		this.exercise_name = exercise_name;
		this.wod_weights = wod_weights;
		this.wod_rep = wod_rep;
	}
	//not wod id
	public WODsC( int wod_id, int[] exercise_id , String[] wod_rep, String[] wod_weights ){
		this.wod_id = wod_id;
		this.exercise_id = exercise_id;
		this.wod_rep = wod_rep;
		this.wod_weights = wod_weights;
		
	}
	//wods not wods id and int[] exercise id
	public WODsC(String[] exercise_name, String[] wod_rep, String[] wod_weights){
		this.exercise_name = exercise_name;
		this.wod_weights = wod_weights;
		this.wod_rep = wod_rep;
	}
	//not exerciseid
	public WODsC(int wod_id, String[] exercise_name, String[] wod_rep, String[] wod_weights ){
		this.wod_id = wod_id;
		this.exercise_name = exercise_name;
		this.wod_weights = wod_weights;
		this.wod_rep = wod_rep;
	}
	
	 
    // getting ID
    public int getWODID(){
        return this.wod_id;
    }
 
    // setting id
    public void setWODID(int wod_id){
        this.wod_id = wod_id;
    } 
    //getting exercise
    public int[] getExerciseID(){
    	return this.exercise_id;
    }
    //setting exercise
    public void setExerciseID(int[] exercise_id){
    	this.exercise_id = exercise_id;
    }
    //getting exercise text
    public String[] getExerciseName(){
    	return this.exercise_name;
    }
    //setting exercise text
    public void setExerciseName(String[] exercise_name)
    {
    	this.exercise_name = exercise_name;
    }
  //getting wod_rep
    public String[] getWODRep(){
    	return this.wod_rep;
    }
    //setting wod_rep
    public void setWODRep(String[] wod_rep){
    	this.wod_rep = wod_rep;
    }
    //getting wod_weight
    public String[] getWODWieght(){
    	return this.wod_weights;
    }
    //setting wod_weight
    public void setWODWieght(String[] wod_weights){
    	this.wod_weights = wod_weights;
    }
  
  


}
