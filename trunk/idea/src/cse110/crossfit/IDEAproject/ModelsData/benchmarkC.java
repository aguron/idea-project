package cse110.crossfit.IDEAproject.ModelsData;

/*
 * benchmark constructor 
 */
public class benchmarkC {

	int benchmark_id;
	int workout_id;
	String benchmark_date;
	int reps;
	String timed;

	//empty constructor
	public benchmarkC(){
		
	}
	
	public benchmarkC(int benchmark_id, int workout_id, int reps, String timed, String benchmark_date){
		this.benchmark_id = benchmark_id;
		this.workout_id = workout_id;
		this.reps = reps;
	
		this.benchmark_date = benchmark_date;
		this.timed = timed;
	}
	
	public benchmarkC( int workout_id, int reps, String timed, String benchmark_date){
	
		this.workout_id = workout_id;
		this.reps = reps;
		this.benchmark_date = benchmark_date;
		this.timed = timed;
	}

    // getting BenchmarkID
    public int getBenchmarkID(){
        return this.benchmark_id;
    }
 
    // setting BenchmarkID
    public void setBenchmarkID(int benchmark_id){
        this.benchmark_id = benchmark_id;
    } 
    
    //getting WorkoutID
    public int getWorkoutID(){
    	return this.workout_id;
    }
    
    //setting WorkoutID
    public void setWorkoutID(int workout_id){
    	this.workout_id =workout_id;
    }
    
    //getting reps
    public int getReps(){
    	return this.reps;
    }
    
    // setting reps
    public void setReps(int reps){
    	this.reps = reps;
    }
  
    //getting time
    public String getTime(){
    	return this.timed;
    }
    //setting time
    public void setTime(String timed){
    	this.timed = timed;
    }
    
    //getting date
    public String getBenchmarkDate(){
    	return this.benchmark_date;
    }
    
   //setting date
    public void setBenchmarkDate(String benchmark_date) {
    	this.benchmark_date = benchmark_date;
    }
	
}


