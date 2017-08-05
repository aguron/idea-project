package cse110.crossfit.IDEAproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//Activity for the Exercise Screen
public class exercise_customize extends Activity implements OnClickListener {
	
	 private Button exercise_done; //Done button
	 private Button exercise_back; //Back button
	 EditText CWexercise_num; //Text Field for Reps
	 EditText CWexercise_weight; //Text Field for Weight
	 EditText CWexercise_unit; //Text Field for Unit
	 String chosen_exercise; //Name of the exercise chosen
	 Intent nextActivity; //Next activity
	 String rep; //Stores the rep
	 String weight; //Stores the weight
	 String unit; //Stores the unit
	 int position;
	 
	 public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	     setContentView(R.layout.wod_customize_layout);
	     
	     //Sets the View for the buttons and Text Fields
	     exercise_back = (Button) findViewById(R.id.CWbackBtn);
	     exercise_done = (Button) findViewById(R.id.CWdoneBtn);
	     CWexercise_num = (EditText) findViewById(R.id.CWexercise_num);
	     CWexercise_weight = (EditText) findViewById(R.id.CWexercise_weight);
	     CWexercise_unit = (EditText) findViewById(R.id.CWexercise_unit);
	     
	     //Adds listeners to the buttons
	     exercise_back.setOnClickListener(this);
	     exercise_done.setOnClickListener(this);
	     
	     //Modifies the input type for the Text Fields
	     CWexercise_num.setInputType(InputType.TYPE_CLASS_NUMBER);
	     CWexercise_weight.setInputType(InputType.TYPE_CLASS_NUMBER);
	        
	     //Gets the name of the exercise chosen
	     Intent intent = this.getIntent();
	     Bundle bundle = intent.getExtras();
	     chosen_exercise = bundle.getString("chosen_exercise");
	     
	     //Sets up the Text View
	     TextView textview = (TextView) findViewById(R.id.exercise_desciption);
	     textview.setMovementMethod(new ScrollingMovementMethod());
	     textview.setText(chosen_exercise);
	 }

	 public void onClick(View v) {
		 switch( v.getId() ) {
		
		 	//The Back button is pressed
		 	case R.id.CWbackBtn: {
		 		//Goes to the Custom Workout Screen
		 		Intent temp = new Intent();
				setResult(exercise_customize.RESULT_CANCELED, temp);
				finish();
				break;
			}
			
		 	//The Done button is pressed
			case R.id.CWdoneBtn: {
				String rep = CWexercise_num.getText().toString();			
				String weight = CWexercise_weight.getText().toString();
				String unit = CWexercise_unit.getText().toString();
			
				//If reps OR weight and unit was entered
				if ( ( String.valueOf(rep).trim().length() >= 1 ) || ( (String.valueOf(weight).trim().length() >= 1 ) && ( String.valueOf(unit).trim().length() >= 1 ) ) ) {
					System.out.println("position " + position);
					Intent data = new Intent();
					
					//If weight and unit was entered
					if( !( String.valueOf(weight).trim().length() >= 1 ) && ( String.valueOf(unit).trim().length() >= 1) ) {
						//Processes data
						data.putExtra("rep", rep);
					  	data.putExtra("weight", "");
					  	data.putExtra("unit", "");
					  	data.putExtra("Rposition", position);
					}
					
					//If rep was entered
					if(String.valueOf(rep).trim().length() < 1) {
						//Processes data
						data.putExtra("rep", "");
						data.putExtra("weight", weight);
						data.putExtra("unit", unit);
						data.putExtra("Rposition", position);
					}
					
					//If another combination of the three was entered
					else {
						//Processes data
						data.putExtra("rep", rep);
						data.putExtra("weight", weight);
						data.putExtra("unit", unit);
						data.putExtra("Rposition", position);
					}

					setResult(1, data);
					finish();
				}
				
				//If weight was entered but unit was not
				if ( ( String.valueOf(weight).trim().length() > 1 ) && ( String.valueOf(unit).trim().length() < 1 ) ) {
					Toast toast_rw = Toast.makeText(getApplicationContext() , "Please fill in the unit", Toast.LENGTH_SHORT);
					toast_rw.show();
				}
		        
				//If reps and weight was not entered
				if ( ( String.valueOf(rep).trim().length() < 1 ) && ( String.valueOf(weight).trim().length() < 1 ) ) {
					Toast toast_rw = Toast.makeText(getApplicationContext() , "Please fill in the reps or weight", Toast.LENGTH_SHORT);
					toast_rw.show();
				}
				break;
			}//End done case
			
		}//End switch
		 
	}//End onClick method
	 
}//End exercise_customize class
