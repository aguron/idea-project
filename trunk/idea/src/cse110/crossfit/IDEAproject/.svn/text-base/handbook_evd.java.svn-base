package cse110.crossfit.IDEAproject;

import java.util.Calendar;
import java.util.Locale;

import cse110.crossfit.IDEAproject.Databases.DataForm;
import cse110.crossfit.IDEAproject.Databases.DataManager;
import cse110.crossfit.IDEAproject.ModelsData.noteC;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

//Activity for the Note Screen
public class handbook_evd extends Activity implements OnClickListener {
		
	//title and body of the note before the user is able to edit the note
	String initial_bodyInput = "";
	String initial_titleInput = "";
	
	//on-screen buttons
	private Button HBsaveBtn;
	private Button HBbackBtn;
	private Button HBdeleteBtn;
		
	//the next intent to perform
	Intent nextActivity;
		
	//alerts for error checks and messages
	AlertDialog.Builder message;
	AlertDialog.Builder delete;	 
	AlertDialog.Builder back;
	AlertDialog.Builder save;
		
	//title obtained from previous screen when user selects a note to edit
	String title;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		//sets up the screen
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handbook_ved);
		        
		//sets up on-screen buttons
		HBsaveBtn = (Button) findViewById(R.id.HBsaveBtn);
		HBbackBtn = (Button) findViewById(R.id.HBbackBtn);	
		HBdeleteBtn = (Button) findViewById(R.id.HBdeleteBtn);	       
		        
		HBdeleteBtn.setOnClickListener(this);
		HBsaveBtn.setOnClickListener(this);
		HBbackBtn.setOnClickListener(this);
		        
		//initializes alerts
		delete = new AlertDialog.Builder(this);
		back = new AlertDialog.Builder(this);
		message = new AlertDialog.Builder(this);
		save = new AlertDialog.Builder(this);
		        
		//gets current intent
		Intent intent = this.getIntent();
		        
		//gets the title of the note to be updated
		title = intent.getStringExtra("noteTitle");

		//if user selected a note to edit, import note body from database
		if( !(title.equals("new note")) ) {
			TextView titleview = (TextView) findViewById(R.id.HB_filename);
		    titleview.setText(title);
		    
		    TextView noteview = (TextView) findViewById(R.id.note_input);
		        
		    noteC body = DataManager.getNote(title, handbook_evd.this);
		    noteview.setText(body.getNotesText());
		}
		        
		//body text of note before edit
		EditText initBody = (EditText) findViewById(R.id.note_input);
		initial_bodyInput = (String) initBody.getText().toString();
				
		//title text of note before edit
		EditText initTitle = (EditText) findViewById(R.id.note_input);
		initial_titleInput = (String) initTitle.getText().toString();
	}
		
	@Override
	public void onClick(View v) {
		//final databaseHelper db = new databaseHelper(this);
		LayoutInflater inflater = getLayoutInflater();
		final View layout = inflater.inflate(R.layout.file_save,(ViewGroup) findViewById(R.id.file_save));
			
		//edited body text
		EditText bodyInput = (EditText) findViewById(R.id.note_input);
		final String body_input = (String) bodyInput.getText().toString();
		
		//edited title text
		EditText titleInput = (EditText) findViewById(R.id.HB_filename);
		final String title_input = (String) titleInput.getText().toString();
		
		//gets the date from the system
		Calendar c = Calendar.getInstance();
		String month = "" + c.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.US);
		String day = "" + c.get(Calendar.DATE);
		String year = "" + c.get(Calendar.YEAR);
		final String date = day + "-" + month + "-" + year;
			
		switch( v.getId() ) {
		
			//user selects save button
			case R.id.HBsaveBtn: {
				
				//checks that there is a note body
				if(String.valueOf(body_input).trim().length() > 0) {
					
					//checks that there is a note title
					if(String.valueOf(title_input).trim().length() > 0) {
						
						//checks to see if the note of this title already exists
						final noteC check = DataManager.getNote(title_input, handbook_evd.this);
					
						//new note with a unique name
						if(check == null && initial_titleInput.equals("")) {
							save.setCancelable(false)
							//prompts user to save the note
							.setMessage("Save note " + title_input + "?")
							.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int id) {
									//creates a new note object to add to the database
									noteC note = new noteC(title_input, body_input, date);
									DataForm.recordNote(note, handbook_evd.this);
							
									//confirms that the note has been saved
									Context context = getApplicationContext();
									CharSequence text = "Note has been successfully saved";
									Toast toast = Toast.makeText(context,text,Toast.LENGTH_SHORT);
									toast.show();
						
									//brings user back to main handbook screen
									nextActivity = new Intent(handbook_evd.this, handbook.class);   
									startActivity(nextActivity);
								}
							})
						
							//user does not want to save the note
							.setNegativeButton("No",new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int id) {
									//closes the alert and user will remain on edit screen
									dialog.cancel(); 
								}
							});
							AlertDialog alert = save.create();
							alert.show();
						}
					
						//updates the note when the user changes the title
						else if(check == null && !title.equals("")) {	
							//gets the appropriate note from the database
							noteC note = DataManager.getNote(title, handbook_evd.this);
						
							//updates the note with the title and body text edits
							DataForm.updateNote(note.getNotesID(), title_input, body_input, handbook_evd.this);
					
							//confirms that the note has been saved
							Context context = getApplicationContext();
							CharSequence text = "Changes have been saved";
							Toast toast = Toast.makeText(context,text,Toast.LENGTH_SHORT);
							toast.show();
				
							//takes user back to main handbook screen
							nextActivity = new Intent(handbook_evd.this, handbook.class);   
							startActivity(nextActivity);
						}
					
						//a note of the same title already exists
						else {
							save.setCancelable(false)
							//prompts user to overwrite the existing note
							.setMessage("Overwrite note " + title_input + "?")
							.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int id) {
									//updates the existing note
									DataForm.updateNote(check.getNotesID(), title_input, body_input, handbook_evd.this);
							
									//confirms that changes have been saved
									Context context = getApplicationContext();
									CharSequence text = "Changes have been saved";
									Toast toast = Toast.makeText(context,text,Toast.LENGTH_SHORT);
									toast.show();
						
									//takes user to main handbook screen
									nextActivity = new Intent(handbook_evd.this, handbook.class);   
									startActivity(nextActivity);
								}
							})
							//user does not want to save
							.setNegativeButton("No",new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog, int id) {
									//takes user back to edit screen without saving
									dialog.cancel(); 
								}
							});
							AlertDialog alert = save.create();
							alert.show();
						}
					}
						
					//the user did not input a title for the note
					else {
						//prompts user to provide a title
						Toast toast = Toast.makeText(getApplicationContext() , "Please fill in the title.", Toast.LENGTH_SHORT);
						toast.show();
					}
				
				}
				
				else {
					//prompts user to provide a note body
					Toast toast= Toast.makeText(getApplicationContext(), "Note is empty", Toast.LENGTH_SHORT);
					toast.show();
				}
			
			}
			break;
				
			//user selects the back button
			case R.id.HBbackBtn: {
				back.setCancelable(false)
				//confirms that the user does not want to save
				.setMessage("Leave without saving?")
				.setPositiveButton("Yes",new DialogInterface.OnClickListener()  {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						//returns user to main handbook screen
						nextActivity = new Intent(handbook_evd.this, handbook.class);   
						startActivity(nextActivity);
					}
				})
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
                	@Override
                	public void onClick(DialogInterface dialog, int id) {
                		//returns to edit screen
                		dialog.cancel(); 
                	}
                });
			 	AlertDialog alert = back.create();
			 	alert.show();
			}
	 		break;
		
	 		//user selects the delete button
			case R.id.HBdeleteBtn: {
				//current title of the note
				//EditText inputTitle = (EditText) findViewById(R.id.HB_filename);
				//String input_t = (String) inputTitle.getText().toString();
				
				//check if note is empty so it doesn't search through the database
				//also checks if note was saved before
				if((initial_bodyInput.equals("") && initial_titleInput.equals("")) || title_input.equals("")) {
					
					message.setCancelable(false)
					//notice when user tries to delete a note that does not exist in the database
					.setMessage("Note has not been saved. Please save this note or press on the BACK button to leave without saving.") 
					.setPositiveButton("OK",new DialogInterface.OnClickListener() {
						 @Override
						 public void onClick(DialogInterface dialog, int id) {
							 //returns user to edit screen
							 dialog.cancel();
						 }	
					});
					AlertDialog alert = message.create();
					alert.show();
					break;
				}
					
				delete.setCancelable(false)
				//prompts user to delete the note
				.setMessage("Confirm delete?") 
				.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					 @Override
					 public void onClick(DialogInterface dialog, int id) {
						 Context context = getApplicationContext();
						 //databaseHelper dbHelper = new databaseHelper(context);
						 //EditText inputTitle = (EditText) findViewById(R.id.HB_filename);
						 //String input_t = (String) inputTitle.getText().toString();
						
						 //gets the note to be deleted from the database
						 
						 noteC note_delete = DataManager.getNote(title_input, handbook_evd.this);
						 //System.out.println("note id " + note_delete.getNotesID());
						 
						 //deletes the note from the database
						 DataManager.deleteNote(note_delete.getNotesID(), handbook_evd.this);
						
						 //confirms that the note has been deleted
						 CharSequence text = "Note has been deleted";
						 Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
						 toast.show();
						
						 //takes the user to the main handbook screen
						 nextActivity = new Intent(handbook_evd.this, handbook.class);   
						 startActivity(nextActivity);
					 }
				})
				//user does not want to delete the note
				.setNegativeButton("No",new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						//returns to edit screen
						dialog.cancel(); 
					}
				});
				AlertDialog alert = delete.create();
				alert.show();
			}
			break;
		}
	
	}
	
}
