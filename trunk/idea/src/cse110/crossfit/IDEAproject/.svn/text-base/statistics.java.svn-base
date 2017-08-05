package cse110.crossfit.IDEAproject;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cse110.crossfit.IDEAproject.Databases.DataForm;
import cse110.crossfit.IDEAproject.Databases.DataManager;
import cse110.crossfit.IDEAproject.Utilities.DateDifference;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.DialogInterface; 
import android.view.LayoutInflater;
import android.widget.EditText;   
import android.widget.TextView;
import android.widget.Toast;

//Activity for the Statistics Screen
public class statistics extends Activity implements OnClickListener{
	private Button STbackBtn; //Main Menu button
    Button STweight; //Weight button
    Button STpersonalbest; //Personal Best button
    Button historyBtn; //History button
    Button STweighin; //Weigh in button
    Intent nextActivity; //Next activity
    TextView showweight; //Text View
    double tempWeight;
    Calendar c = Calendar.getInstance(); //Calendar to get today's date
    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy"); //Formatting for date
    String formattedDate = df.format(c.getTime()); //Today's date
         
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
	    setContentView(R.layout.statistics);
        
	    //Sets the View for the buttons and Text View
        STbackBtn = (Button) findViewById(R.id.STmain);
        STweight = (Button) findViewById(R.id.STweight);
        STpersonalbest = (Button) findViewById(R.id.STpersonalbest);
        STweighin = (Button) findViewById(R.id.STweighin);
        historyBtn = (Button) findViewById(R.id.SThistory);
        showweight = (TextView) findViewById(R.id.showweight);    
        
        //Adds listeners to the buttons
        STpersonalbest.setOnClickListener(this);
        STweight.setOnClickListener(this);
        STbackBtn.setOnClickListener(this);
        STweighin.setOnClickListener(this);
        historyBtn.setOnClickListener(this);
        
        System.out.println("Current time => " + formattedDate);      
    }
    
    @Override
    public void onClick(View v) {    
    	switch( v.getId() ) {
    	
    		//The History button is pressed
            case R.id.SThistory:
            	//Goes to the History Screen
	            nextActivity = new Intent(this, CalendarActivity.class);    
	            startActivity(nextActivity);
	            break;
            
	        //The Main Menu button is pressed
            case R.id.STmain:
            	//Goes to the Main Menu
		        nextActivity = new Intent(this, IdeaActivity.class);    
		        startActivity(nextActivity);
		        break;
            
		    //The Weight button is pressed
            case R.id.STweight:
            	//If there are less than two weights entered
            	if( DataManager.getWeightCount(statistics.this) < 2 ) {
            		//Displays a message saying that at least two weights need to be entered
            		Toast toast = Toast.makeText(getApplicationContext() , "At least two weight entries are needed for the graph.", Toast.LENGTH_SHORT);
                    toast.show();
            	}
            	
            	//If there are at least two weights entered
            	else {
            		//Goes to the Graph Screen
            		nextActivity = new Intent(this, statistics_weightchart.class);    
            		startActivity(nextActivity);
            	}
	            break;
            
	        //The Personal Best button is pressed
            case R.id.STpersonalbest:
            	//Goes to the Personal Best Screen
                nextActivity = new Intent(this, personalBest.class);    
                startActivity(nextActivity);
                break;
            
            //The Weigh In button is pressed
            case R.id.STweighin: {
            	//Prepares the Pop Up Box for display
                LayoutInflater inflater = getLayoutInflater();
                final View layout = inflater.inflate(R.layout.weighin,(ViewGroup) findViewById(R.id.weighin));
                final EditText weightInput=(EditText) layout.findViewById(R.id.STweighin);
                AlertDialog.Builder weight_input = new AlertDialog.Builder(statistics.this);
                weight_input.setCancelable(false)
                .setTitle("Please enter your weight.").setView(layout)
                
                //Creates the Ok button and its logic
                .setPositiveButton("Ok",  new DialogInterface.OnClickListener() { 
                    public void onClick(DialogInterface dialog, int buttonId) {
                    	
                    	//If the User entered a weight
                    	if(String.valueOf(weightInput.getText()).trim().length() > 0) {
                                  
	                        /*
	                         * CODE FOR TESTING
	                         * 
	                         * THIS IS WHERE I PUT WEIGHT AND DATE INFORMATION INTO
	                         * THE DATABASE IN ORDER TO TEST IT. IF MULTIPLE WEIGHT
	                         * ENTRIES ARE MADE FOR A PARTICULAR WEIGHT DATE, ONLY
	                         * THE LAST ONE WILL PERSIST.
	                         */
	                        String[] weights = new String[] {"250", "249", "248", "247", 
	                        								 "244", "240", "235", "229",
	                        								 "222", "214", "205", "195",
	                        								 "184", "172"};
	                                 
	                        String[] dates = new String[14];
	                        long startDate = DateDifference.setToStartOfDay(1337000000000L);    
	                        for (int i = 0; i < dates.length; i++) {
	                        	dates[i] = "" + ((i * DateDifference.DAY_MILLISECONDS)
	                                			  + startDate);
	                                	  DataForm.recordWeight(weights[i],dates[i],statistics.this);
	                                  }
	                        /*
	                         * RECORDING WEIGHT ENTRY
	                         */
                            // Get the weight input by the user
                            String inputWeight = weightInput.getText().toString();
                            // Get the current date
                            Date tempDate = new Date();
                            // Standardize the dates to time 00:00:00 of the day
                            long tempDateTime = DateDifference.setToStartOfDay(tempDate.getTime());
                            String inputDate = "" + tempDateTime;
                            /*
                             * TESTING
                             */
                            Log.d("MyApp", "Date: " + inputDate + " Weight: " + inputWeight);
                            
                            // Record the date
                            DataForm.recordWeight(inputWeight, inputDate, statistics.this);
                            dialog.dismiss();
                        }
                    	
                    	//If the User did not enter a weight
                        else {
                            Toast toast = Toast.makeText(getApplicationContext() , "Please input your weight", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                })
                
                //Creates the Cancel button and its logic
                .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    	//Closes the Pop Up Box
                		dialog.dismiss(); 
                    }
                });
                
                //Finishes creating the Pop Up Box and displays it
                AlertDialog dialog = weight_input.create();
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
            }
            break;
	    }
    }
    
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
    
}//End statistics class
