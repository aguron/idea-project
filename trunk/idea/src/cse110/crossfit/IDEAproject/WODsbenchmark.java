package cse110.crossfit.IDEAproject;

import java.util.ArrayList;
import java.util.List;

import cse110.crossfit.IDEAproject.Databases.databaseHelper;
import cse110.crossfit.IDEAproject.ModelsData.workoutC;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

//Activity for the Benchmark Screen
public class WODsbenchmark extends ListActivity implements OnClickListener {
	
	Button WODsBKbackBtn; //Back button
	Button WODsbenchmarkStartBtn; //Start button
	Intent nextActivity; //Next activity
	String selectedWOName; //Name of the selected Benchmark
	int selectedWOID; //ID of the selected Benchmark
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.wodsbenchmark);
        
        //Sets the View for the buttons
        WODsBKbackBtn = (Button) findViewById(R.id.WODsBKbackBtn);
        WODsbenchmarkStartBtn = (Button) findViewById(R.id.WODsbenchmarkStartBtn);
        
        //Adds listeners to the buttons
        WODsbenchmarkStartBtn.setOnClickListener(this);
        WODsBKbackBtn.setOnClickListener(this);
        
        //Gets all the Benchmarks from the database
        final databaseHelper db = new databaseHelper(this);
        int workoutCount = db.getWorkOutCount(); 
        List<Integer> workoutIDList = new ArrayList<Integer>();
        List<String> workoutNameList = new ArrayList<String>();
        int preWorkoutID = -1;
       
        //Store all the Benchmarks' name and ID
        for(int i =1 ; i <= workoutCount; i++) {
        	int tempWorkoutId = db.getWorkOutByPK(i).getWorkoutID();
        	
        	if(tempWorkoutId != preWorkoutID) {
        		workoutIDList.add(tempWorkoutId);
        		preWorkoutID = tempWorkoutId; 
        		//System.out.println("workout ID " + tempWorkoutId);
        		workoutNameList.add(db.getWorkOut(tempWorkoutId).getWorkoutName());
        	}
        }
        
        //Prepares the list for displaying
        String[] workoutNameArr = workoutNameList.toArray(new String[workoutNameList.size()]);
        workoutNameList.toArray();
        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, workoutNameArr));
		
        //Sets the View for the list
        ListView lv1 = getListView();
		lv1.setTextFilterEnabled(true);
		
		lv1.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

				//Prepares the TextView for display
		        TextView text = (TextView)findViewById(R.id.WODsTextView);
		        text.setMovementMethod(new ScrollingMovementMethod());
		        
		        //Gets the Name of the selected Benchmark
		        String tempShowText ="";
		        selectedWOName = ((TextView) view).getText().toString();
		        
		        workoutC selectedWorkout = db.getWorkOut(selectedWOName);
		        selectedWOID = selectedWorkout.getWorkoutID();
		        tempShowText = selectedWorkout.getWorkoutName();
		    
		        //Formats the Benchmark's description
		        String[] tempWorkText = selectedWorkout.getWorkOutText();
		        
		        for(int i = 0; i < tempWorkText.length; i ++) {
		        	tempShowText += "\n" + tempWorkText[i];
		        }
		        
		        tempShowText += "\n" + "Description: " +selectedWorkout.getWorkoutDescription();
		        
		        if(selectedWorkout.getTime() == 1)
		        	tempShowText += "\n" + "Type: timed";
		        else
		        	tempShowText += "\n" + "Type: AMRAP   Time:" + selectedWorkout.getWorkoutTimeLimit() + " mins" ;
		        
		        //Sets the View for the TextView
		        text.setText(tempShowText);
		    }
		});
	 }
	
	@Override
	public void onClick(View v) {
		final databaseHelper db = new databaseHelper(this);
		switch(v.getId()) {
		
			//The Back button was pressed
			case R.id.WODsBKbackBtn:
				nextActivity = new Intent(this, IdeaActivity.class);    
		 	    startActivity(nextActivity);
		 	    break;
		 	    
		 	//The Start button was pressed
			case R.id.WODsbenchmarkStartBtn: {
				
				//If there is no selected Benchmark
				if (selectedWOName == null) {
					Toast toast = Toast.makeText(getApplicationContext() , "Please select a Benchmark first.", Toast.LENGTH_SHORT);
					toast.show();
					break;
				}
				
				//If the selected Benchmark is Timed
				if (db.getWorkOut(selectedWOID).getTime() == 1) {
					db.close();
					
					//Goes to the Timed Workout Screen
					nextActivity = new Intent(WODsbenchmark.this, WOD.class);
					nextActivity.putExtra("key", selectedWOID);
            		startActivity(nextActivity);
				}
				
				//If the selected Benchmark is AMRAP
				else {
					db.close();
					
					//Goes to the AMRAP Workout Screen
					nextActivity = new Intent(WODsbenchmark.this, WOD_AMRAP.class);
					nextActivity.putExtra("key", selectedWOID);
            		startActivity(nextActivity);
				}
				break;
				
    		 }//end Start case	
			
		}//end switch
		
	}//end onClick method  
	
}//end WODsbenchmark class
