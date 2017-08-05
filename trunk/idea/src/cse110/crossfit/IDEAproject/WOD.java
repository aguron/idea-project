package cse110.crossfit.IDEAproject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import cse110.crossfit.IDEAproject.Databases.DataForm;
import cse110.crossfit.IDEAproject.ModelsData.benchmarkC;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.content.DialogInterface;
import android.content.Intent;

//Activity for Timed Workout Screen
public class WOD extends Activity implements OnClickListener{
	
	private Button timed_done; //Done button
	private Button timed_start; //Start button
	private Button timed_pause; //Pause button
	private Button timed_resume; //Resume button
	Intent nextActivity; //Next activity
	Chronometer mChronometer; //Chronometer
	AlertDialog.Builder done; //Pop Up Box
	private long lastPause; //Time when the Stopwach is paused
	private boolean started = false; //Whether the User started the workout or not
	private boolean paused = false; //Whether the User paused the workout or not
	int workoutID; //ID of the Workout
	 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wod);
		
		//Sets the View for the chronometer and buttons
		mChronometer = (Chronometer) findViewById(R.id.chronometer);
		timed_done = (Button) findViewById(R.id.timed_done);
		timed_start = (Button) findViewById(R.id.timed_start);
		timed_pause = (Button) findViewById(R.id.timed_pause);
		timed_resume = (Button) findViewById(R.id.timed_resume);
		
		//Adds listeners to the buttons
		timed_start.setOnClickListener(this);
		timed_pause.setOnClickListener(this);
		timed_resume.setOnClickListener(this);
		timed_done.setOnClickListener(this);
		
		//Initializes the Pop Up Box
		done = new AlertDialog.Builder(this);
	        
		//Gets the ID of the Workout
		Intent intent = this.getIntent();
		Bundle bundle = intent.getExtras();
		workoutID = bundle.getInt("key");
	}
	 
	@Override
	public void onClick(View v) {
		switch(v.getId()) {

			//The Done button was pressed
			case R.id.timed_done: {
				
				//Pauses the stopwatch and processes time
		 		paused = true;
				lastPause = SystemClock.elapsedRealtime();
				mChronometer.stop();
				
				//If the workout was started
				if (started == true) {
					//Prepares the statistics of this workout for storage
					long temp = lastPause - mChronometer.getBase();
					String time = String.valueOf(temp);
					
			        Calendar cal = Calendar.getInstance();
			        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			        String date = dateFormat.format(cal.getTime());

			        //Records the statistics of this workout
			        benchmarkC myBenchmarkC = new benchmarkC(workoutID, 0, time, date);
					DataForm.recordTimedWorkout(myBenchmarkC, WOD.this);
					 
					//Starts up the Main Menu Screen
					nextActivity = new Intent(WOD.this, IdeaActivity.class);   
					startActivity(nextActivity);
				}
				
				//If the workout was not started
				else {
					done.setCancelable(false)
					.setMessage("Quit?") //show benchmark description
					
					//Creates the Yes button and its logic
					.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							//Goes to the Main Menu Screen
							nextActivity = new Intent(WOD.this, IdeaActivity.class);   
							startActivity(nextActivity);
						}
					})
					
					//Creates the No button and its logic
					.setNegativeButton("No",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							//Closes the Pop Up Box
		                	dialog.cancel(); 
						}
					});

					//Finishes creating the Pop Up Box and displays it
					AlertDialog alert = done.create();
					alert.show();
				}
				
			}//End done case
			break;
		 	
			//The Start button was pressed
			case R.id.timed_start:
				//Starts or restarts the stopwatch
				started = true;
				paused = false;
				mChronometer.setBase(SystemClock.elapsedRealtime());
			    mChronometer.start();
			    break;
			
			//The Resume button was pressed
			case R.id.timed_resume:
				//If the workout was started and then paused
				if(paused && started) {
					paused = false;
					mChronometer.setBase(mChronometer.getBase() + SystemClock.elapsedRealtime() - lastPause);
					mChronometer.start();
				}
				break;
			
			//The Pause button was pressed
			case R.id.timed_pause:
				if (started && (!paused)){
				paused = true;
				lastPause = SystemClock.elapsedRealtime();
				mChronometer.stop();}
			    break;
			    
		 }//End switch
		
	 }//End onClick method
	
}//End WOD class

