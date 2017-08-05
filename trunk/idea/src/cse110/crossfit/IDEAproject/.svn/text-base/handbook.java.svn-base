package cse110.crossfit.IDEAproject;

import java.util.ArrayList;

import cse110.crossfit.IDEAproject.Databases.DataManager;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

//Activity for the Handbook Screen
public class handbook extends ListActivity implements OnClickListener{
	
	Button HBbackBtn; //Main Menu button
	Button HBcreateBtn; //Create button
	Intent nextActivity; //Next activity
	ListView notes_listView; //List View
	ArrayList<String> chosenList; //List of Notes
	ArrayAdapter<String> listAdapter; //Adapter for the list of Notes
	String noteTitle = "new note"; //Stores the title of the note
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.handbook);
	        
		//Sets the View for the buttons
		HBbackBtn = (Button) findViewById(R.id.HBbackBtn);
	    HBcreateBtn = (Button) findViewById(R.id.HBcreateBtn);
	    
	    //Adds listeners to the buttons
        HBbackBtn.setOnClickListener(this);
        HBcreateBtn.setOnClickListener(this);
        
        //Sets the View for the ListView
        notes_listView = (ListView) findViewById(16908298);
        
        //Sets the Adapter to the List View
        chosenList = new ArrayList<String>();
        listAdapter = new ArrayAdapter<String>(handbook.this, R.layout.list_item, chosenList);
	    notes_listView.setAdapter(listAdapter);
	    
	    listAdapter.notifyDataSetChanged();
        notes_listView.refreshDrawableState();

		String[] notesNameArray = DataManager.getAllNoteNames(handbook.this);
		setListAdapter(new ArrayAdapter<String>(handbook.this, R.layout.list_item, notesNameArray));
		    
		ListView lv1 = getListView();
		lv1.setTextFilterEnabled(true);
		  
		lv1.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		    	ArrayAdapter<String> adapter = (ArrayAdapter<String>) getListAdapter();
		    	noteTitle = adapter.getItem(position);

		    	//Goes to the Note Screen
		    	Intent newIntent = new Intent(handbook.this, handbook_evd.class);		        	  
		    	newIntent.putExtra("noteTitle", noteTitle);
		    	startActivity(newIntent); 
		    }
		}); 
	}

	public void onClick(View v) {
		switch( v.getId() ) {
		
			//The Main Menu button was pressed
			case R.id.HBbackBtn:
				//Goes to the Main Menu
				nextActivity = new Intent(this, IdeaActivity.class);    
				startActivity(nextActivity);
				break;
		 	
			//The Create button was pressed
			case R.id.HBcreateBtn:
				//Goes to the Note Screen
				nextActivity = new Intent(this, handbook_evd.class);    
				nextActivity.putExtra("noteTitle", noteTitle);
			 	startActivity(nextActivity);
			 	break;
			 	
		}
		
	}

}//End handbook class
