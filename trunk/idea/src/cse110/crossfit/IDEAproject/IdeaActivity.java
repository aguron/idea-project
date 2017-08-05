package cse110.crossfit.IDEAproject;

import cse110.crossfit.IDEAproject.Databases.DataManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//Activity for the Main Menu
public class IdeaActivity extends Activity implements OnClickListener {

	Button MainhandBookBtn; //Handbook button
	Button MainstatisticsBtn; //Statistics button
	Button MainWODsBtn; //WOD button
	Intent nextActivity; //Next activity
	AlertDialog.Builder WODs; //Pop Up Box

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//Sets the View for the buttons
		MainhandBookBtn = (Button) findViewById(R.id.MainhandBookBtn);
		MainstatisticsBtn = (Button) findViewById(R.id.MainstatisticBtn);
		MainWODsBtn =(Button) findViewById(R.id.MainWODsBtn);

		System.out.println("Check the database: "+ checkDataBase());
	      
		//Checks if the Database exists
		if(!checkDataBase()) {
			//Creates the database if it does not exist
			DataManager.createDatabase(IdeaActivity.this);
		}
		
		//Adds listeners to the buttons
		MainstatisticsBtn.setOnClickListener(this);
		MainhandBookBtn.setOnClickListener(this);
		MainWODsBtn.setOnClickListener(this);
		
		//Initializes the Pop Up Box
		WODs = new AlertDialog.Builder(this);
	}//end onCreate() method
	
	@Override
	public void onClick(View v) {
		switch( v.getId() ) {
		
			//The WOD button is pressed
			case R.id.MainWODsBtn: {
		 		processWODButton();
		 	}
			break;
		 	
			//The Handbook button is pressed
		 	case R.id.MainhandBookBtn:
		 		//Goes to the Handbook Screen
			 	nextActivity = new Intent(IdeaActivity.this, handbook.class); 
			 	startActivity(nextActivity);
			 	break;
		 	
			//The Statistics button is pressed
		 	case R.id.MainstatisticBtn:
		 		//Goes to the Statistics Screen
			 	nextActivity = new Intent(IdeaActivity.this, statistics.class);    
			 	startActivity(nextActivity);
			 	break;
		 	
		 }//end switch()
		
	}//end onClick method

	/*
	 * Author: ???
	 * Function Name: processWODButton()
	 * Description: Creates and displays the Pop Up Box. The Pop Up Box has three buttons (Benchmark, Customize, Cancel).
	 * Parameters: None
	 * Error Conditions: None
	 * Return Value: None
	 */
	public void processWODButton() {
		WODs.setCancelable(false)
		
		//Creates the Benchmark button and its logic
		.setPositiveButton("Benchmark",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id ) {
				//Goes to the Benchmark Screen
				nextActivity = new Intent(IdeaActivity.this, WODsbenchmark.class);  
				startActivity(nextActivity);
			}
		})
		
		//Creates the Customize button and its logic
		.setNeutralButton("Customize",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id ) {
				//Goes to the Custom Workout Screen
				nextActivity = new Intent(IdeaActivity.this, customWOD.class);   
				startActivity(nextActivity);
			}
		})
		
		//Creates the Cancel button and its logic
		.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int id) {
				//Closes the Pop Up Box
				dialog.cancel(); 
			}
		});
		
		//Finishes creating the Pop Up Box and displays it
		AlertDialog alert = WODs.create();
		alert.show();
	}
	
	/*
	 * Author: Carter
	 * Function Name: checkdataBase()
	 * Description: Checks to see if the database exists.
	 * Parameters: None
	 * Error Conditions: None
	 * Return Value: True if the database exists, False if otherwise
	 */
	private boolean checkDataBase() {
		String DB_PATH  = "data/data/cse110.crossfit.IDEAproject/databases/";
		String DB_NAME = "database.db";
        SQLiteDatabase checkDB = null;
        
        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        }
        catch (Exception e) {
            System.out.println("database does't exist yet.");
        }
        
        if (checkDB != null) {
            checkDB.close();
            System.out.println("My db is:- " + checkDB.isOpen());
            return true;
        }
        else
            return false;
     }
	
}//end class IdeaActivity