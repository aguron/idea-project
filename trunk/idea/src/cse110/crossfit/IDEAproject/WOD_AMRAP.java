package cse110.crossfit.IDEAproject;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import cse110.crossfit.IDEAproject.Databases.DataForm;
import cse110.crossfit.IDEAproject.Databases.DataManager;
import cse110.crossfit.IDEAproject.ModelsData.benchmarkC;
import cse110.crossfit.IDEAproject.ModelsData.workoutC;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//Activity for the AMRAP Workout Screen
public class WOD_AMRAP extends Activity implements OnClickListener{
	 
	Intent nextActivity; //Next activity
	private MalibuCountDownTimer countDownTimer; //Timer
	private boolean started = false; //Whether the User started the workout or not
	private boolean paused = true; //Whether the User paused the workout or not
	private boolean finished = false; //Whether the User finished the workout or not
	private Button amrap_start; //Start button
	private Button amrap_pause; //Pause button
	private Button amrap_resume; //Resume button
	private Button amrap_stop; //Stop button
	private TextView text; //TextView
	long lastpause; //Time when the Timer is paused
	long pausedtime; //Time when the Timer is paused
	AlertDialog.Builder done; //Pop Up Box
	String time; //Time limit of the Workout
	
	private long startTime; //The start time for the Workout
	private long interval = 1000; //Interval
	long startMinutes; //The Start minute for the Workout
	long startSeconds; //The Start second for the Workout
	int workoutID; //The ID of the Workout
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wod_amrap);
		
		//Sets the View for the buttons
		amrap_stop = (Button) findViewById(R.id.amrap_stop);
		amrap_start = (Button) this.findViewById(R.id.amrap_start);
		amrap_pause = (Button) this.findViewById(R.id.amrap_pause);
		amrap_resume = (Button) this.findViewById(R.id.amrap_resume);
		
		//Adds listeners to the buttons
		amrap_start.setOnClickListener(this);
		amrap_pause.setOnClickListener(this);
		amrap_resume.setOnClickListener(this);
		amrap_stop.setOnClickListener(this);
		
		//Initializes the Pop Up Box
		done = new AlertDialog.Builder(this);
		
		//Gets the ID of the Workout
		Intent intent = this.getIntent();
		Bundle bundle = intent.getExtras();
		workoutID = bundle.getInt("key");

		workoutC workout = DataManager.getBenchmark(workoutID, WOD_AMRAP.this);
		
		//Computes the time
		startTime = workout.getWorkoutTimeLimit()*1000*60;
		time = String.valueOf(workout.getWorkoutTimeLimit());
		
		System.out.println("in timer start time " + startTime);

		//Converts the time into minutes and seconds
		startMinutes = (startTime / (1000*60));
		startSeconds = ((startTime % (1000*60*60)) % (1000*60)) / 1000;
		
		//Sets the TextView for the Timer
		text = (TextView) this.findViewById(R.id.timer);
		
		if( (String.valueOf(startMinutes).trim().length() > 1) && (String.valueOf(startSeconds).trim().length() > 1) )		
			text.setText(startMinutes + ":" + startSeconds);
		
		if( (String.valueOf(startMinutes).trim().length() > 1) && (String.valueOf(startSeconds).trim().length() <= 1) )
			text.setText(startMinutes + ":0" + startSeconds);
		
		if( (String.valueOf(startMinutes).trim().length() <= 1) && (String.valueOf(startSeconds).trim().length() > 1) )
			text.setText("0" + startMinutes + ":" + startSeconds);
		
		if( (String.valueOf(startMinutes).trim().length() <= 1) && (String.valueOf(startSeconds).trim().length() <= 1) )
			text.setText("0" + startMinutes + ":0" + startSeconds);
	}

	@Override
	public void onClick(View v) {
		switch( v.getId() ) {
		
			//The stop button was pressed
			case R.id.amrap_stop: {
				
				//If the workout was started and finished
			 	if (started && finished) {
			 		countDownTimer.cancel();
			 		paused = true;
			 		
			 		//Prepares the Pop Up Box for display
			 		LayoutInflater inflater = getLayoutInflater();
					final View layout = inflater.inflate(R.layout.rnd_input,(ViewGroup) findViewById(R.id.Rnd));
					final EditText diaInput=(EditText) layout.findViewById(R.id.amrap_num); 
					AlertDialog.Builder round_input = new AlertDialog.Builder(WOD_AMRAP.this);
					round_input.setCancelable(false)
					.setTitle("Please enter the number of rounds completed.").setView(layout)
					
					//Creates the Ok button and its logic
				    .setPositiveButton("Ok",  new DialogInterface.OnClickListener() { 
				        public void onClick(DialogInterface dialog, int id) { 		
				        	
				        	//If there was input from the User
				        	if(String.valueOf( diaInput.getText() ).trim().length() > 0) {
				        		//System.out.println("# of rounds" + diaInput.getText());
									
				        		//Prepares the statistics of this workout for storage
				        		//String time = String.valueOf(startTime);
									 
				        		String tempString = String.valueOf( diaInput.getText() );
				        		Integer tempInt = Integer.valueOf(tempString);
				        		int numReps = tempInt.intValue();
									 
				        		//Toast.makeText(getApplicationContext(), "Reps did: " + numReps, Toast.LENGTH_SHORT).show();
									 
				        		Calendar cal = Calendar.getInstance();
				        		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				        		String date = dateFormat.format(cal.getTime());
									 
				        		benchmarkC myBenchmarkC = new benchmarkC(workoutID, numReps, time, date);
				        		
								DataForm.recordAMRAPWorkout(myBenchmarkC, WOD_AMRAP.this);
								//Toast.makeText(getApplicationContext(), "Bool: " + test, Toast.LENGTH_SHORT).show();
									 
				        	    nextActivity = new Intent(WOD_AMRAP.this, IdeaActivity.class);   
								startActivity(nextActivity);
								dialog.dismiss();
				        	}
				        	
				        	//If there was no input from the User
				        	else {
				        		//Displays a message prompting the User to enter the number of rounds completed.
				        	    Toast toast = Toast.makeText(getApplicationContext() , "Please enter the number of rounds completed.", Toast.LENGTH_SHORT);
			        	    	toast.show();
				        	}
				        }
				    })
				    
				    //Creates the Cancel button and its logic
					.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int buttonId) {
							//Closes the Pop Up Box
                         	dialog.dismiss(); 
                    	}
					}); 
					
					//Finishes creating the Pop Up Box and displays it
					AlertDialog dialog = round_input.create();
					try {
                    	Field field=dialog.getClass().getDeclaredField("mAlert");
                    	field.setAccessible(true);
                    	Object obj=field.get(dialog);
                    	field=obj.getClass().getDeclaredField("mHandler");
                    	field.setAccessible(true);
                    	field.set(obj,new ButtonHandler(dialog));
                    }
					catch(Exception e) {
						
					}
                    dialog.show();
			 	}//End if statement
			 	
			 	//If the workout was not finished
				if (!finished) {
					
					//If the workout was started
					if(started)
						 countDownTimer.cancel();
					
					paused = true;
					
					//Prepares the Pop Up Box for display
					done.setCancelable(false)
					.setMessage("Quit?")
					
					//Creates the Yes button and its logic
					.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							//Goes to the Main Menu Screen
							nextActivity = new Intent(WOD_AMRAP.this, IdeaActivity.class);   
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
			}
			break;
		
			//The start button was pressed
			case R.id.amrap_start: {
				
				//If the workout is paused
				if(paused) {
					//Starts or restarts the Timer
					started = true;
					paused = false;
					countDownTimer = new MalibuCountDownTimer(startTime, interval);
					countDownTimer.start();
					text.setTextSize(60);
				}
			}
			break;
			
			//The pause button was pressed
			case R.id.amrap_pause: {
				
				//If the workout was started but not paused
				if (started && (!paused)) {
					//Pauses the Timer
					paused = true;
					countDownTimer.cancel();
				}
			}
			break;
			
			//The resume button was pressed
			case R.id.amrap_resume: {
				System.out.println("resume" + (paused && started));
				
				//If the workout was started and paused
				if(paused && started) {
					//Resumes the Timer
					paused = false;
					pausedtime = lastpause;
					countDownTimer = new MalibuCountDownTimer(pausedtime, interval);
					countDownTimer.start();
				}
			}
			break;
			
		}//End switch
		
	}//End onClick method

	//MalibuCountDownTimer class. Functions as the Timer.
	public class MalibuCountDownTimer extends CountDownTimer {

		//Constructor for the MalibuCountDownTimer
		public MalibuCountDownTimer(long startTime, long interval) {
			super(startTime, interval);
		}

		//When the Timer hits 0
		@Override
		public void onFinish() {
			text.setTextSize(40);
			text.setText("Time's up!");

			paused = true;
			finished = true;
			//timeElapsedView.setText("Time Elapsed: " + String.valueOf(startTime));
		}

		//When the Timer is ticking down
		@Override
		public void onTick(long millisUntilFinished) {
			long Minutes = (millisUntilFinished / (1000*60));
			long Seconds = ((millisUntilFinished % (1000*60*60)) % (1000*60)) / 1000;
			
			//If Minutes and Seconds are both greater than 0
			if( (String.valueOf(Minutes).trim().length() > 1)  && (String.valueOf(Seconds).trim().length() > 1)) {
				text.setText(Minutes + ":" + Seconds);
				lastpause = millisUntilFinished;
			}
			
			//If Minutes is greater than 0 but Seconds is not
			if( (String.valueOf(Minutes).trim().length() > 1) && (String.valueOf(Seconds).trim().length() <= 1) ) {
				text.setText(Minutes + ":0" + Seconds);
				lastpause = millisUntilFinished;
			}
			
			//If Seconds is greater than 0 but Minutes is not
			if( (String.valueOf(Minutes).trim().length() <= 1) && (String.valueOf(Seconds).trim().length() > 1) ) {
				text.setText("0" + Minutes + ":" + Seconds);
				lastpause = millisUntilFinished;
			}
			
			//If Minutes and Seconds are both not greater than 0
			if( (String.valueOf(Minutes).trim().length() <= 1) && (String.valueOf(Seconds).trim().length() <= 1) ) {
				text.setText("0" + Minutes + ":0" + Seconds);
				lastpause = millisUntilFinished;
			}
			
		}
		
	}//End MalibuCountDownTimer class
	
	//ButtonHandler class.
	class ButtonHandler extends Handler {
		private WeakReference<DialogInterface> mDialog;
		
		public ButtonHandler(DialogInterface dialog) {
			mDialog = new WeakReference<DialogInterface>(dialog);
		}
		
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what) {
				case DialogInterface.BUTTON_POSITIVE:
				case DialogInterface.BUTTON_NEUTRAL:
				case DialogInterface.BUTTON_NEGATIVE:
					((DialogInterface.OnClickListener)msg.obj).onClick(mDialog.get(),msg.what);
					break;
			}
			
		}
		
	}//End ButtonHandler class
	
}//End WOD_AMRAP class
