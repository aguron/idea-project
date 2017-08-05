package cse110.crossfit.IDEAproject;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cse110.crossfit.IDEAproject.Databases.DataForm;
import cse110.crossfit.IDEAproject.Databases.DataManager;
import cse110.crossfit.IDEAproject.ModelsData.WODsC;
import cse110.crossfit.IDEAproject.ModelsData.exerciseC;
import cse110.crossfit.IDEAproject.ModelsData.workoutC;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

//Activity for the Custom Workout Screen
public class customWOD extends ListActivity implements OnClickListener { 
	Button CWbackButton; //Main Menu button
	Button CWdoneBtn; //Done button
	Intent nextActivity; //Next activity
	String selected;
	String chosen_exercise;
	TextView chosen;
	List<String> wodsWeight = new ArrayList<String>(); //List of all the weights
	List<String> wodsRep = new ArrayList<String>(); //List of all the reps
	List<String> wodsUnit = new ArrayList<String>() ; //List of all the units
	List<Integer> exerciseList = new ArrayList<Integer>(); //List of exercises
	int workoutCount;
	int wodsCount;
	ListView chosenexercise_listView; //List View for the exercises in the Custom Workout
	ArrayList<String> chosenList; //List of Exercises in the Custom Workout
	ArrayAdapter<String> listAdapter; //Adapter for the List
	int selectedPosition;
	String filename;
	String exerciseName;
	String exerciseDescription;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customwod);
	     
		//Initializes the Buttons
		CWbackButton = (Button) findViewById(R.id.CWbackBtn);
		CWdoneBtn = (Button) findViewById(R.id.CWdoneBtn);
		chosen = (TextView) findViewById(R.id.chosenexercise_TextView);
		
		//Sets the Listeners for the Buttons
		CWbackButton.setOnClickListener(this);
		CWdoneBtn.setOnClickListener(this);
		
		//Initializes the View
		chosenexercise_listView = (ListView) findViewById(R.id.chosenexercise_listView);
		chosenList = new ArrayList<String>();
			
		listAdapter = new ArrayAdapter<String>(customWOD.this,R.layout.list_item, chosenList);
		chosenexercise_listView.setAdapter(listAdapter);
		 
		//Gets all the exercise names
		String[] exerciseNameArray = DataManager.getAllExerciseNames(this);
		setListAdapter(new ArrayAdapter<String>(customWOD.this, R.layout.list_item, exerciseNameArray));

		ListView lv1 = getListView();
		lv1.setTextFilterEnabled(true);
		
		//Sets the onItemClickListener
		lv1.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				selected = (String) ((TextView) view).getText();
				
				ArrayAdapter<String> adapter = (ArrayAdapter<String>) getListAdapter();
		        String Exercise = adapter.getItem(position);

		        Intent newIntent = new Intent(customWOD.this, exercise_customize.class);          
		         
		        //Processes data for the selected Exercise
		        exerciseC myExerciseC = DataManager.getExercise(position + 1, customWOD.this);
		        selectedPosition = position + 1;
		        try {
		        	exerciseName = myExerciseC.getExerciseName();
		        }	
		        catch (Exception e) {
		        	exerciseName = Exercise;
		        }
		        
		        try {
		        	exerciseDescription = myExerciseC.getDescription();
		        }	
		        catch (Exception e) {
		        	exerciseDescription = "Insert Description Here";
		        }		        
		        
		        //Goes to the Exercise Screen
		        newIntent.putExtra("chosen_exercise", exerciseName + "\n" + exerciseDescription);
		        startActivityForResult(newIntent, 1);
		    }
		});
	 }//end onCreate method

	@Override
	public void onClick(View v) {
		switch( v.getId() ) {
		
			//The Back button was pressed
			case R.id.CWbackBtn: {
			     nextActivity = new Intent(this, IdeaActivity.class);    
		 	     startActivity(nextActivity);
		 	     break;
			}
			
			//The Done button was pressed
			case R.id.CWdoneBtn: {
				
				//If no exercises are selected
				if(chosenList.isEmpty()) {
					Toast toast = Toast.makeText(getApplicationContext() , "Please select at least one exercise.", Toast.LENGTH_SHORT);
					toast.show();
				}
				
				//If exercises have been selected
				else
					processDoneButton();
				break;
			}
			
		}//End switch
		
	}//End onClick method

	//Logic for what happens after the Done button is pressed
	private void processDoneButton() {
		//Prepares the Pop Up Box for display
		LayoutInflater inflater = getLayoutInflater();
		final View layout = inflater.inflate(R.layout.file_save,(ViewGroup) findViewById(R.id.file_save));
		final AlertDialog.Builder cw_done = new AlertDialog.Builder(customWOD.this);
		final EditText filenameInput=(EditText) layout.findViewById(R.id.filename); 
		cw_done.setCancelable(false)
		.setTitle("Please name your WOD.").setView(layout)
		
		//Creates the AMRAP button and its logic 
		.setPositiveButton("AMRAP",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int buttonId) {
				
				//If a name was entered for the Custom WOD
				if(String.valueOf(filenameInput.getText()).trim().length() > 0) {
					filename =filenameInput.getText().toString();
					//Displays a new pop up box for AMRAP
					processAMRAPButton();
				}
				
				//If a name was NOT entered for the Custom WOD
				else {
					Toast toast = Toast.makeText(getApplicationContext() , "Please name your WOD.", Toast.LENGTH_SHORT);
					toast.show();
				}
				
			}//End onClick
			
		})//End of Positive Button (AMRAP)
		
		//Creates the Timed button and its logic
		.setNeutralButton("Timed",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int BtnId) {
				
    	   		//If a name was entered for the Custom WOD
    	   		if(String.valueOf(filenameInput.getText()).trim().length() > 0) {
    	   			//Starts up the Workout Screen
    	   			System.out.println("your workout name" + filenameInput.getText());
    	   			filename = filenameInput.getText().toString();
    	   			
    	   			//Processes data for storage
    	   			wodsCount = DataManager.getWODCount(customWOD.this);
    	   			int addWodsId = DataManager.getWODID(wodsCount, customWOD.this) + 1;
      	   			      
    	   			int tempExSize = exerciseList.size();     
    	   			int[] tempexerciseId = new int[tempExSize];
    	   			System.out.println("tempExSize " + tempExSize );
    	   			List<String> tempWeightList = new ArrayList<String>();
    	   			String[] wodsRepArr = wodsRep.toArray(new String[wodsRep.size()]);
    	   			wodsRep.toArray(wodsRepArr);
    	   			
    	   			for(int i = 0; i < wodsWeight.size(); i++) {
    	   				tempWeightList.add(wodsWeight.get(i) + " " + wodsUnit.get(i));
    	   			}
    	   			
    	   			String[] wodsWeightArr = tempWeightList.toArray(new String[tempWeightList.size()]);
    	   			Log.i("before fore exercise"," here");
    	   			
    	   			for (int i = 0; i < tempExSize; i++) {
    	   				tempexerciseId[i] = exerciseList.get(i);
    	   				System.out.println("exercise  " + exerciseList.get(i));
    	   			}
    	   			
    	   			//Stores the data in the database
      	   			WODsC tempWods = new WODsC(addWodsId, tempexerciseId, wodsRepArr, wodsWeightArr);	   
      	   			DataForm.recordWOD(tempWods, customWOD.this);
      	   			
      	   			workoutC tempWorkout = new workoutC(addWodsId,filename,"",1,0,0);
      	   			DataForm.recordBenchmark(tempWorkout, customWOD.this);
      	   			
      	   			//Goes to the Workout Screen
   			   		Intent newIntent= new Intent(customWOD.this, WOD.class); 
    	   			newIntent.putExtra("key", addWodsId);
    	   			startActivityForResult(newIntent, 2 );
    	   			dialog.dismiss();
    	   		}
		    	   		
    	   		//If a name was NOT entered for the Custom WOD
    	   		else {
    	   			Toast toast = Toast.makeText(getApplicationContext() , "Please name your WOD.", Toast.LENGTH_SHORT);
    	   			toast.show();
    	   		}
    	   		
    	   	}//End onClick
			
		})//End Neutral button (Timed) 
		
		//Creates the Cancel button and its logic
		.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {
				//Closes the Ppp Up Box
				dialog.cancel(); 
			}
		});//End Negative button (Cancel)
		
		//Finishes creating the Pop Up Box and displays it
		AlertDialog dialog = cw_done.create();
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
	}//End processDoneButton method

	//Logic for what happens after the AMRAP button is pressed
	private void processAMRAPButton() {
		
		//Prepares the Pop Up Box for display
		LayoutInflater inflater = getLayoutInflater();
		final View layout = inflater.inflate(R.layout.time_input,(ViewGroup) findViewById(R.id.time_input));
		final EditText diaInput=(EditText) layout.findViewById(R.id.time_input); 
		AlertDialog.Builder cw_done_time = new AlertDialog.Builder(customWOD.this);
		cw_done_time.setCancelable(false)
		.setTitle("Please enter workout time.").setView(layout)
		
		//Creates the Ok button and its logic
		.setPositiveButton("OK",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int buttonId) {
				
				//If a time was entered for AMRAP
				if(String.valueOf(diaInput.getText()).trim().length() > 0) {
					//Starts up the Workout Screen
					String TimeLmt = diaInput.getText().toString();
					long time_limit = Long.parseLong(TimeLmt);
					System.out.println(time_limit);
					
					//Processes data for storage
					wodsCount = DataManager.getWODCount(customWOD.this);
  	   			    int addWodsId = DataManager.getWODID(wodsCount, customWOD.this) + 1;
  	   			    
  	   			    System.out.println("addWodsId  " + addWodsId);
  	   			    int tempExSize = exerciseList.size();     
  	   			    int[] tempexerciseId = new int[tempExSize];
  	   			    System.out.println("tempExSize " + tempExSize );
  	   			    List<String> tempWeightList = new ArrayList<String>();
  	   			    String[] wodsRepArr = wodsRep.toArray(new String[wodsRep.size()]);
  	   			    wodsRep.toArray(wodsRepArr);
  	   			    
  	   			    for(int i = 0; i < wodsWeight.size(); i++) {
  	   			    	tempWeightList.add(wodsWeight.get(i) + " " + wodsUnit.get(i));
  	   			    }
  	   			    
  	   			    String[] wodsWeightArr = tempWeightList.toArray(new String[tempWeightList.size()]);
  	   			    Log.i("before fore exercise"," here");
  	   			   
  	   			    for (int i = 0; i < tempExSize; i++) {
  	   			    	tempexerciseId[i] = exerciseList.get(i);
  	   			    }
	      	   			 
  	   			    //Stores the data in the database
  	   			    WODsC tempWods = new WODsC(addWodsId, tempexerciseId, wodsRepArr, wodsWeightArr);	   
  	   			    DataForm.recordWOD(tempWods, customWOD.this);
	      	   			  
  	   			    workoutC tempWorkout = new workoutC(addWodsId,filename,"",0,1, time_limit);
	      	   		DataForm.recordBenchmark(tempWorkout, customWOD.this); 
	      	   		
	      	   		//Goes to the Workout Screen
					Intent newIntent = new Intent(customWOD.this, WOD_AMRAP.class);		        
					newIntent.putExtra("key", addWodsId);  		  
					startActivityForResult(newIntent, 1);
					dialog.dismiss();
				}
						
				//If no time was entered for AMRAP
				else {
					Toast toast = Toast.makeText(getApplicationContext() , "Please enter a workout time.", Toast.LENGTH_SHORT);
					toast.show();
				}
				
			}//End onClick
			
		})//End Positive Button (OK)
		
		//Creates the Cancel button and its logic
		.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {
				//Closes the Pop Up Box
				dialog.cancel(); 
			}
		});
		
		//Finishes creating the Pop up Box and displays it
		AlertDialog dialog = cw_done_time.create();
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
	}//End processAMRAPButton Method
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    TextView textview = (TextView) findViewById(R.id.chosenexercise_TextView);	
	    String tempRep;
	    String tempWeight;
	    String tempUnit;
	    int Rposition = 0;
	    
	    if(resultCode == 1) {
		    textview.setText("Added: " + selected);
		    //System.out.println(data.getStringExtra(chosen_exercise_back));
		    chosenList.add(selected);
			//System.out.println("added");
		    
	    	tempRep = data.getStringExtra("rep");
	    	tempWeight = data.getStringExtra("weight"); 	
	    	tempUnit = data.getStringExtra("unit");
	    	wodsRep.add(String.valueOf(tempRep));
	    	wodsWeight.add(String.valueOf(tempWeight));		    
			wodsUnit.add(String.valueOf(tempUnit));
	    	Rposition = data.getIntExtra("Rposition", 0) + 1;
	    	exerciseList.add(selectedPosition);
		  
		    System.out.println("Weight " + tempWeight);
		    System.out.println("tempRep  " + tempRep);
		    System.out.println("tempUnit  " + tempUnit);
			System.out.println("Contents of al: " + chosenList);
			System.out.println("Positionn " + selectedPosition);
			super.onActivityResult(requestCode, resultCode, data);
	    }//End if statement
	    
	}//End of onActivityResult method
	
	//ButtonHandler class
	class ButtonHandler extends Handler {
		private WeakReference<DialogInterface> mDialog;
		
		public ButtonHandler(DialogInterface dialog) {
			mDialog=new WeakReference<DialogInterface>(dialog);
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
	
}//End customWOD class
