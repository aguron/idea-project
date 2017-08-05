package cse110.crossfit.IDEAproject;

import java.util.ArrayList;
import java.util.List;

import cse110.crossfit.IDEAproject.Databases.DataManager;
import cse110.crossfit.IDEAproject.ModelsData.benchmarkC;
import cse110.crossfit.IDEAproject.ModelsData.workoutC;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

//Activity for the Personal Best Screen
public class personalBest extends Activity implements OnClickListener{
	
	private Button PBbackBtn; //Back button
	Intent nextActivity; //Next activity
	ListView myPB_Timed_listview; //List View for the Timed Workouts
	ListView myPB_AMRAP_listview; //List View for the AMRAP Workouts
	List<String> myPB_AMRAP; //List of AMRAP Workouts
	List<String> myPB_Timed; //List of Timed Workouts
	private ArrayAdapter<String> myPB_Timed_adapter; //Adapter for Timed List
    private ArrayAdapter<String> myPB_AMRAP_adapter; //Adapter for AMRAP List
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personalbest);
        
        //Sets the View for the button and adds a listener to it
        PBbackBtn = (Button) findViewById(R.id.PBbackBtn);
        PBbackBtn.setOnClickListener(this);
        
        //Sets the View for the List Views
        myPB_AMRAP_listview = (ListView) findViewById(R.id.PB_AMRAP);
        myPB_Timed_listview = (ListView) findViewById(R.id.PB_Timed);
        
        //Initializes the ArrayLists
        myPB_Timed = new ArrayList<String>();
        myPB_AMRAP = new ArrayList<String>();
        ArrayList<Integer> added_check = new ArrayList<Integer>();
        
        //Sets the adapter to the List Views
        myPB_Timed_adapter = new ArrayAdapter<String>(personalBest.this, R.layout.list_item, myPB_Timed);
	    myPB_AMRAP_adapter = new ArrayAdapter<String>(personalBest.this, R.layout.list_item, myPB_AMRAP);
		
	    int historyCount = DataManager.getHistoryCount(personalBest.this);
	    
	    //Traverses through all of the workouts in the workout history
        for(int i = 1; i <= historyCount; i++) {
        	//Stores the workout history obtained
        	int tempId = DataManager.getHistory(i, personalBest.this).getWorkoutID();
        	
        	if( !added_check.contains(tempId) ) {
        		//Gets the benchmark based on the workout history's ID
        		workoutC tempBenchmark = DataManager.getBenchmark(tempId, personalBest.this);
        		
        		//Gets the type of the Benchmark
        		int type_AMRAP = tempBenchmark.getAMRAP();
        		int type_Timed = tempBenchmark.getTime();
        	
        		//If the Benchmark is AMRAP
        		if(type_AMRAP == 1) {
        			//Gets the benchmark to use and compare to other benchmarks
        			benchmarkC historyI = DataManager.getHistory(i, personalBest.this);
        			
        			//Record the reps and date of the benchmark
        			int PB_rep = historyI.getReps();
        			String PB_rep_date = historyI.getBenchmarkDate();
        			
        			//Traverses through the other workouts in the workout history to compare workouts to the first benchmark
        			for(int j = i + 1; j <= historyCount; j++) {
        				//Gets another benchmark to use and compare to the first benchmark
        				benchmarkC historyJ = DataManager.getHistory(j, personalBest.this);
        				
        				//If the second benchmark is the same benchmark as the first, and is better than the first
						if( ( historyI.getWorkoutID() == historyJ.getWorkoutID() ) && ( historyJ.getReps() > historyI.getReps() ) ) {
							
							//Record the reps and date of the second benchmark
							PB_rep = historyJ.getReps();
							PB_rep_date = historyJ.getBenchmarkDate();
						}									
        			}
        			
        			//Adds the information to the AMRAP List
        			String tempinfo = tempBenchmark.getWorkoutName() + "     Best round: " + PB_rep + " Rnds   " + PB_rep_date;
					myPB_AMRAP.add(tempinfo);	
					added_check.add(tempId);
        		}
        	
        		//If the Benchmark is Timed
        		if(type_Timed == 1) {
        			//Gets the benchmark to use and compare to other benchmarks
        			benchmarkC historyI = DataManager.getHistory(i, personalBest.this);
        			
        			//Record the time and date of the benchmark
        			long PB_time = Long.parseLong( historyI.getTime() );
        			String PB_time_date = historyI.getBenchmarkDate();
        			
        			//Traverses through the other workouts in the workout history to compare workouts to the first benchmark
        			for(int j = i + 1; j <= historyCount; j++) {
        				//Gets another benchmark to use and compare to the first benchmark
        				benchmarkC historyJ = DataManager.getHistory(j, personalBest.this);
        				
        				//If the second benchmark is the same benchmark as the first, and is better than the first
        				if( (historyI.getWorkoutID() == historyJ.getWorkoutID() ) && ( Long.parseLong( historyJ.getTime() ) < Long.parseLong( historyI.getTime() ) ) ) {
        					
        					//Record the time and date of the second benchmark
        					PB_time = Long.parseLong( historyJ.getTime() );
        					PB_time_date = historyJ.getBenchmarkDate();
        				}
        			}
        			
        			//Adds the information to the Timed List
        			String temptime = convert(PB_time);
        			String tempinfo = tempBenchmark.getWorkoutName() + "     Best time: " + temptime + "   " + PB_time_date;
					myPB_Timed.add(tempinfo);	
					added_check.add(tempId);
        		}
        		
        	}
        	
        }//End outer for loop
        
        System.out.println(myPB_AMRAP);
        System.out.println(myPB_Timed);
        
        //Updates the List Views
        myPB_Timed_listview.setClickable(false);
        myPB_AMRAP_listview.setClickable(false);
        
        myPB_Timed_listview.setAdapter(myPB_Timed_adapter);
        myPB_AMRAP_listview.setAdapter(myPB_AMRAP_adapter);
	}

	@Override
	public void onClick(View v) {
		switch( v.getId() ) {
		
			//The Back button is pressed
			case R.id.PBbackBtn:
				//Goes to the Statistics Screen
				nextActivity = new Intent(this, statistics.class);    
				startActivity(nextActivity);
				break;
		}
	}
	
	//Converts the time to a proper format (Minutes and seconds)
	public static String convert(long temptime) {
		long Minutes = (temptime / (1000*60));
		long Seconds = ((temptime % (1000*60*60)) % (1000*60)) / 1000;
		String time = null;
		
		if( (String.valueOf(Minutes).trim().length() > 1)  && (String.valueOf(Seconds).trim().length() > 1)) {
			time = Minutes + ":" + Seconds;
		}
		
		if( (String.valueOf(Minutes).trim().length() > 1) && (String.valueOf(Seconds).trim().length() <= 1) ) {
			time = Minutes + ":0" + Seconds;
		}
		
		if( (String.valueOf(Minutes).trim().length() <= 1) && (String.valueOf(Seconds).trim().length() > 1) ) {
			time = "0" + Minutes + ":" + Seconds;
		}
		
		if( (String.valueOf(Minutes).trim().length() <= 1) && (String.valueOf(Seconds).trim().length() <= 1) ) {
			time = "0" + Minutes + ":0" + Seconds;
		}
		return time;
	}

}
